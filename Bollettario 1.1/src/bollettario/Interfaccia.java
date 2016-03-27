/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import static bollettario.Bollettario.debug;
import bollettario.FolderDataBase.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JPanel;

/**
 *
 * @author DiegoCarlo
 */
public class Interfaccia extends javax.swing.JFrame {

    /**
     * Creates new form Interfaccia
     */
    InterfPesate interfPesate;
    Font font = new Font("Sans-serif", 0, 20);
    Dimension dimRadioButton = new Dimension(200, 100);
    Calendar giornoVisualizzato;
    int giornoDaVisualizzare;
    ArrayList<Long> elencoJListOrdini;
    public static JFAggiuntaPesata aggiuntaPesata;
    public static JFEliminaPesata eliminaPesata;
    public static JFModificaPesata modificaPesata;
    
    
    public Interfaccia()
    {
        if(debug)System.out.println("Interfaccia.Interfaccia()");
        /*try { 
           font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, new java.io.File("src\\Font\\OpenDyslexicAlta-Regular.ttf")); 
           font =  font.deriveFont(30F);
        } 
        catch(Exception ex) { 
           System.out.println(ex.getMessage()); 
        } */

        initGiorno();
        initComponents();
        initComponents2();
    }

    private void initGiorno()
    {
        if(debug)System.out.println("Interfaccia.initGiorno()");
        Calendar c = GregorianCalendar.getInstance();
        giornoDaVisualizzare = c.get(Calendar.DAY_OF_WEEK);
    }
    private void initComponents2()
    {
        if(debug)System.out.println("Interfaccia.initComponents2()");
        initJRBGiorni();
        initJTable();
        ricercaComboCalendario.setText("");
        initComboCalendario();
        initScrollPanelPesate();
        aggiornaInterfacciaPesate();
        togglePannelloPulsantiProdotto();
        
        aggiuntaListener();
    }
    private void aggiuntaListener()
    {
        if(debug)System.out.println("Interfaccia.aggiuntaListener()");
        jButtonStampa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                
                if(jButtonStampa.isEnabled())
                {
                    stampa();
                    Bollettario.salva();
                }
            }
        });
    }
    private void initScrollPanelPesate()
    {
        if(debug)System.out.println("Interfaccia.initScrollPanelPesate()");
        jScrollPane5.getVerticalScrollBar().setPreferredSize(new Dimension(50, 0));
    }
    private void initJRBGiorni()
    {
        if(debug)System.out.println("Interfaccia.initJRBGiorni()");
        jRadioButtonLunedi.setText("Lunedì");
        jRadioButtonMartedi.setText("Martedì");
        jRadioButtonMercoledi.setText("Mercoledì");
        jRadioButtonGiovedi.setText("Giovedì");
        jRadioButtonVenerdi.setText("Venerdì");
        jRadioButtonSabato.setText("Sabato");
        jRadioButtonDomenica.setText("Domenica");
        switch(giornoDaVisualizzare)
        {
            case 2:
                jRadioButtonLunedi.setText("LUNEDI");
                jRadioButtonLunedi.setSelected(true);
                break;
            case 3:
                jRadioButtonMartedi.setText("MARTEDI");
                jRadioButtonMartedi.setSelected(true);
                break;
            case 4:
                jRadioButtonMercoledi.setText("MERCOLEDI");
                jRadioButtonMercoledi.setSelected(true);
                break;
            case 5:
                jRadioButtonGiovedi.setText("GIOVEDI");
                jRadioButtonGiovedi.setSelected(true);
                break;
            case 6:
                jRadioButtonVenerdi.setText("VENERDI");
                jRadioButtonVenerdi.setSelected(true);
                break;
            case 7:
                jRadioButtonSabato.setText("SABATO");
                jRadioButtonSabato.setSelected(true);
                break;
            case 1:
                jRadioButtonDomenica.setText("DOMENICA");
                jRadioButtonDomenica.setSelected(true);
                break;
        }
        
    }
    private void initJTable()
    {
        if(debug)System.out.println("Interfaccia.initJTable()");
        int righe = 25;
        int colonne = 8;
        Object[][] tab = new Object [righe][colonne];
        int oraInizio = 6;
        int incremento = -1;
        for(int i=0; i<righe; i++)
        {
            for(int j=0; j<colonne; j++)
            {
                if(j == 0)
                {
                    String minuti;
                    if(i%2 == 0)
                    {
                        minuti = ":00";
                        incremento++;
                    }
                    else
                    {
                        minuti = ":30";
                    }
                    tab[i][j] = (oraInizio + incremento) + minuti;
                }
            }
        }
        jTable1.setModel(new JTableModel(
            tab,
            new String [] {
                "Ora", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"
            }
        ));
        jTable1.setRowHeight(60);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
    }
    private void stampa()
    {
        if(debug)System.out.println("Interfaccia.stampa()");
        if(interfPesate.idOrdine >= 0)
        {
            ElencoPesate elenco = new ElencoPesate();
            
            ArrayList<Long> listaIdPesate = Bollettario.dataBase.elencoPesate.listaIdPesate(interfPesate.idOrdine);
            for(int i=0; i<listaIdPesate.size(); i++)
            {
                // cerca la pesata
                PrototipoPesata pe = Bollettario.dataBase.getPesata(listaIdPesate.get(i));
                
                if(pe.stato == StatoPesata.VALIDA)
                {
                    pe.stato = StatoPesata.STAMPATA;
                    elenco.add(pe);
                }
            }
            if(!elenco.isEmpty())
            {
                interfPesate.aggiornaInterfaceStato();
                interfPesate.aggiornaStatoBarreStampate();
                System.out.println(elenco.stampa());
            }
        }
    }
    private void togglePannelloPulsantiProdotto()
    {
        if(debug)System.out.println("Interfaccia.togglePannelloPulsantiProdotto()");
        int indiceLista = jList1.getSelectedIndex();
        System.out.print(indiceLista);
        if(indiceLista >= 0 && indiceLista < elencoJListOrdini.size())
        {
            jButtonProdottoAggiungi.setEnabled(true);
            jBProdottoModifica.setEnabled(true);
            jBProdottoElimina.setEnabled(true);
        }
        else
        {
            jButtonProdottoAggiungi.setEnabled(false);
            jBProdottoModifica.setEnabled(false);
            jBProdottoElimina.setEnabled(false);
        }
    }
    private void aggiornaTab()
    {
        if(debug)System.out.println("Interfaccia.aggiornaTab()");
        int tabSelected = jTabbedPane.getSelectedIndex();
        switch(tabSelected)
        {
            case 0: aggiornaPannelloOrdini(); break;
            case 1: aggiornaPannelloCalendario(); break;
            case 2: aggiornaPannelloOpzioni(); break;
        }
    }
    private void setGiornoDaVisualizzare()
    {
        if(debug)System.out.println("Interfaccia.setGiornoDaVisualizzare()");
        if(jRadioButtonLunedi.isSelected())
        {
            giornoDaVisualizzare = GregorianCalendar.MONDAY;
        }
        if(jRadioButtonMartedi.isSelected())
        {
            giornoDaVisualizzare = GregorianCalendar.TUESDAY;
        }
        if(jRadioButtonMercoledi.isSelected())
        {
            giornoDaVisualizzare = GregorianCalendar.WEDNESDAY;
        }
        if(jRadioButtonGiovedi.isSelected())
        {
            giornoDaVisualizzare = GregorianCalendar.THURSDAY;
        }
        if(jRadioButtonVenerdi.isSelected())
        {
            giornoDaVisualizzare = GregorianCalendar.FRIDAY;
        }
        if(jRadioButtonSabato.isSelected())
        {
            giornoDaVisualizzare = GregorianCalendar.SATURDAY;
        }
        if(jRadioButtonDomenica.isSelected())
        {
            giornoDaVisualizzare = GregorianCalendar.SUNDAY+7;
        }
    }
    public void aggiornaPannelloOrdini()
    {
        if(debug)System.out.println("Interfaccia.aggiornaPannelloOrdini()");
        setGiornoDaVisualizzare();
        togglePulsanti();
        aggiornaListaOrdini();
        aggiornaInterfacciaPesate();
        
    }
    private void aggiornaInterfacciaPesate()
    {
        if(debug)System.out.println("Interfaccia.aggiornaInterfacciaPesate()");
        interfPesate = new InterfPesate();
        int indJlist = jList1.getSelectedIndex();
        if(indJlist >= 0 && indJlist < elencoJListOrdini.size())
        {
            long idOrd = elencoJListOrdini.get(indJlist);
            jScrollPane5.setViewportView
            (
                    interfPesate.getJPanel
                    (
                            idOrd
                    )
            );
        }
        else
        {
            jScrollPane5.setViewportView
            (
                    new JPanel()
            );
        }
    }
    public void aggiorna()
    {
        if(debug)System.out.println("Interfaccia.aggiorna()");
        this.setEnabled(true);
        
        jList1.setSelectedIndex(jList1.getSelectedIndex());
        this.requestFocus();
        aggiornaInterfacciaPesate();
    }
    private void aggiornaListaOrdini()
    {
        if(debug)System.out.println("Interfaccia.aggiornaListaOrdini()");
        int gap = giornoDaVisualizzare - GregorianCalendar.getInstance().get(Calendar.DAY_OF_WEEK);
        Calendar c = GregorianCalendar.getInstance();
        c.add(GregorianCalendar.DAY_OF_MONTH, gap);
        ElencoOrdini e = Bollettario.dataBase.elencoOrdini;
        elencoJListOrdini = new ArrayList<Long>();
        if(elencoJListOrdini.size() >= 0)
        {
        
            final String[] testoLista = new String[elencoJListOrdini.size()];
            for(int i=0; i<elencoJListOrdini.size(); i++)
            {
                Ordine o = (Ordine)e.get(elencoJListOrdini.get(i));
                long idOrdine = o.getId();

                String ragioneSociale = (Bollettario.dataBase.elencoClienti.get(o.idCliente)).ragioneSociale;
                testoLista[i] = idOrdine + "| " + ragioneSociale;
            }
            jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = testoLista;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
            });
            DataBase s = Bollettario.dataBase;
            int i = 0;
        }
    }
    private void togglePulsanti()
    {
        if(debug)System.out.println("Interfaccia.togglePulsanti()");
        if(GregorianCalendar.getInstance().get(Calendar.DAY_OF_WEEK) == giornoDaVisualizzare)
        {
            jButtonStampa.setEnabled(true);
            jButtonTara.setEnabled(true);
            jComboBoxTara.setEnabled(true);
        }
        else
        {
            jButtonTara.setEnabled(false);
            jButtonStampa.setEnabled(false);
            jComboBoxTara.setEnabled(false);
        }
    }
    private void aggiornaPannelloCalendario()
    {
        if(debug)System.out.println("Interfaccia.aggiornaPannelloCalendario()");
        
    }
    private void initComboCalendario()
    {
        
        if(debug)System.out.println("Interfaccia.initComboCalendario()");
        /*ElencoClienti selezione = new ElencoClienti();
        ElencoClienti el = Bollettario.dataBase.elencoClienti;
        for(int i=0; i<el.size(); i++)
        {
            if(el.get(i).ragioneSociale.toLowerCase().contains(ricercaComboCalendario.getText().toLowerCase()))
            {
                selezione.add(el.get(i));
            }
        }
        ElementoIndicizzato[] comboCalendario = new ElementoIndicizzato[selezione.size()];
        for(int i=0; i<selezione.size(); i++)
        {
            comboCalendario[i] = new ElementoIndicizzato(
                    selezione.get(i).codice,
                    selezione.get(i).ragioneSociale);
        }
        jComboBoxCalendarioClienti.setModel(new javax.swing.DefaultComboBoxModel(comboCalendario));*/
    }
    private void aggiornaPannelloOpzioni()
    {
        if(debug)System.out.println("Interfaccia.aggiornaPannelloOpzioni()");
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanelOrdini = new javax.swing.JPanel();
        jRadioButtonLunedi = new javax.swing.JRadioButton();
        jRadioButtonMartedi = new javax.swing.JRadioButton();
        jRadioButtonMercoledi = new javax.swing.JRadioButton();
        jRadioButtonGiovedi = new javax.swing.JRadioButton();
        jRadioButtonVenerdi = new javax.swing.JRadioButton();
        jRadioButtonSabato = new javax.swing.JRadioButton();
        jRadioButtonDomenica = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonStampa = new javax.swing.JButton();
        jButtonTara = new javax.swing.JButton();
        jComboBoxTara = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonOrdineAggiungi = new javax.swing.JButton();
        jButtonOrdineElimina = new javax.swing.JButton();
        jPannelloPulsantiProdotto = new javax.swing.JPanel();
        jButtonProdottoAggiungi = new javax.swing.JButton();
        jBProdottoElimina = new javax.swing.JButton();
        jBProdottoModifica = new javax.swing.JButton();
        jPanelCalendario = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBoxCalendarioClienti = new javax.swing.JComboBox();
        ricercaComboCalendario = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanelOpzioni = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 800));

        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonLunedi);
        jRadioButtonLunedi.setText("Lunedì");
        jRadioButtonLunedi.setMaximumSize(new java.awt.Dimension(60, 23));
        jRadioButtonLunedi.setFont(font);
        jRadioButtonLunedi.setSize(dimRadioButton);
        jRadioButtonLunedi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonLunediItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonMartedi);
        jRadioButtonMartedi.setText("Martedì");
        jRadioButtonMartedi.setFont(font);
        jRadioButtonMartedi.setSize(dimRadioButton);
        jRadioButtonMartedi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonMartediItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonMercoledi);
        jRadioButtonMercoledi.setText("Mercoledì");
        jRadioButtonMercoledi.setFont(font);
        jRadioButtonMercoledi.setSize(dimRadioButton);
        jRadioButtonMercoledi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonMercolediItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonGiovedi);
        jRadioButtonGiovedi.setText("Giovedì");
        jRadioButtonGiovedi.setFont(font);
        jRadioButtonGiovedi.setSize(dimRadioButton);
        jRadioButtonGiovedi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonGiovediItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonVenerdi);
        jRadioButtonVenerdi.setText("Venerdì");
        jRadioButtonVenerdi.setFont(font);
        jRadioButtonVenerdi.setSize(dimRadioButton);
        jRadioButtonVenerdi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonVenerdiItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonSabato);
        jRadioButtonSabato.setText("Sabato");
        jRadioButtonSabato.setFont(font);
        jRadioButtonSabato.setSize(dimRadioButton);
        jRadioButtonSabato.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonSabatoItemStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonDomenica);
        jRadioButtonDomenica.setText("Domenica");
        jRadioButtonDomenica.setFont(font);
        jRadioButtonDomenica.setSize(dimRadioButton);
        jRadioButtonDomenica.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButtonDomenicaItemStateChanged(evt);
            }
        });

        jLabel1.setText("Ordini");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setFont(font);
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel3.setText("Ora Attuale");

        jLabel4.setText("00 : 00");

        jLabel5.setText("Ora di Consegna");

        jButtonStampa.setText("Stampa");
        jButtonStampa.setFont(font);

        jButtonTara.setText("Tara");
        jButtonTara.setFont(font);

        jComboBoxTara.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(jPanel3);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordine"));

        jButtonOrdineAggiungi.setText("Aggiungi");
        jButtonOrdineAggiungi.setFont(font);

        jButtonOrdineElimina.setText("Elimina");
        jButtonOrdineElimina.setFont(font);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonOrdineElimina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonOrdineAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonOrdineAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOrdineElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPannelloPulsantiProdotto.setBorder(javax.swing.BorderFactory.createTitledBorder("Prodotto"));

        jButtonProdottoAggiungi.setText("Aggiungi");
        jButtonProdottoAggiungi.setFont(font);
        jButtonProdottoAggiungi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonProdottoAggiungiMousePressed(evt);
            }
        });

        jBProdottoElimina.setText("Elimina");
        jBProdottoElimina.setFont(font);
        jBProdottoElimina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBProdottoEliminaMousePressed(evt);
            }
        });

        jBProdottoModifica.setText("Modifica");
        jBProdottoModifica.setMaximumSize(new java.awt.Dimension(96, 25));
        jBProdottoModifica.setMinimumSize(new java.awt.Dimension(96, 25));
        jBProdottoModifica.setPreferredSize(new java.awt.Dimension(96, 25));
        jBProdottoModifica.setFont(font);
        jBProdottoModifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBProdottoModificaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPannelloPulsantiProdottoLayout = new javax.swing.GroupLayout(jPannelloPulsantiProdotto);
        jPannelloPulsantiProdotto.setLayout(jPannelloPulsantiProdottoLayout);
        jPannelloPulsantiProdottoLayout.setHorizontalGroup(
            jPannelloPulsantiProdottoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPannelloPulsantiProdottoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPannelloPulsantiProdottoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProdottoAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPannelloPulsantiProdottoLayout.createSequentialGroup()
                        .addComponent(jBProdottoElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBProdottoModifica, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPannelloPulsantiProdottoLayout.setVerticalGroup(
            jPannelloPulsantiProdottoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPannelloPulsantiProdottoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonProdottoAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPannelloPulsantiProdottoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBProdottoModifica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBProdottoElimina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelOrdiniLayout = new javax.swing.GroupLayout(jPanelOrdini);
        jPanelOrdini.setLayout(jPanelOrdiniLayout);
        jPanelOrdiniLayout.setHorizontalGroup(
            jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrdiniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOrdiniLayout.createSequentialGroup()
                        .addComponent(jRadioButtonLunedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonMartedi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonMercoledi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonGiovedi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonVenerdi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonSabato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonDomenica)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelOrdiniLayout.createSequentialGroup()
                        .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOrdiniLayout.createSequentialGroup()
                                .addComponent(jPannelloPulsantiProdotto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTara, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonTara, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonStampa, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelOrdiniLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5))))
                .addContainerGap())
        );
        jPanelOrdiniLayout.setVerticalGroup(
            jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrdiniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonMartedi)
                        .addComponent(jRadioButtonMercoledi)
                        .addComponent(jRadioButtonGiovedi)
                        .addComponent(jRadioButtonVenerdi)
                        .addComponent(jRadioButtonSabato)
                        .addComponent(jRadioButtonDomenica))
                    .addComponent(jRadioButtonLunedi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonStampa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTara, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPannelloPulsantiProdotto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane.addTab("Ordini", jPanelOrdini);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jComboBoxCalendarioClienti.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ricercaComboCalendario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ricercaComboCalendarioKeyReleased(evt);
            }
        });

        jButton6.setText("x");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCalendarioLayout = new javax.swing.GroupLayout(jPanelCalendario);
        jPanelCalendario.setLayout(jPanelCalendarioLayout);
        jPanelCalendarioLayout.setHorizontalGroup(
            jPanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalendarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                    .addGroup(jPanelCalendarioLayout.createSequentialGroup()
                        .addComponent(jComboBoxCalendarioClienti, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ricercaComboCalendario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        jPanelCalendarioLayout.setVerticalGroup(
            jPanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalendarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCalendarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCalendarioClienti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ricercaComboCalendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Calendario", jPanelCalendario);

        jButton1.setText("Stampante");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpzioniLayout = new javax.swing.GroupLayout(jPanelOpzioni);
        jPanelOpzioni.setLayout(jPanelOpzioniLayout);
        jPanelOpzioniLayout.setHorizontalGroup(
            jPanelOpzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpzioniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(910, Short.MAX_VALUE))
        );
        jPanelOpzioniLayout.setVerticalGroup(
            jPanelOpzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpzioniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(681, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Opzioni", jPanelOpzioni);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneStateChanged
        if(debug)System.out.println("Interfaccia.jTabbedPaneStateChanged()");
        aggiornaTab();
    }//GEN-LAST:event_jTabbedPaneStateChanged

    private void ricercaComboCalendarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ricercaComboCalendarioKeyReleased
        if(debug)System.out.println("Interfaccia.ricercaComboCalendarioKeyReleased()");
        initComboCalendario();
    }//GEN-LAST:event_ricercaComboCalendarioKeyReleased

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        if(debug)System.out.println("Interfaccia.jButton6MousePressed()");
        ricercaComboCalendario.setText("");
        initComboCalendario();
    }//GEN-LAST:event_jButton6MousePressed

    private void jRadioButtonLunediItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonLunediItemStateChanged
        if(debug)System.out.println("Interfaccia.jRadioButtonLunediItemStateChanged()");
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonLunediItemStateChanged

    private void jRadioButtonMartediItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMartediItemStateChanged
        if(debug)System.out.println("Interfaccia.jRadioButtonMartediItemStateChanged()");
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonMartediItemStateChanged

    private void jRadioButtonMercolediItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMercolediItemStateChanged
        if(debug)System.out.println("Interfaccia.jRadioButtonMercolediItemStateChanged()");
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonMercolediItemStateChanged

    private void jRadioButtonGiovediItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonGiovediItemStateChanged
        if(debug)System.out.println("Interfaccia.jRadioButtonGiovediItemStateChanged()");
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonGiovediItemStateChanged

    private void jRadioButtonVenerdiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonVenerdiItemStateChanged
        if(debug)System.out.println("Interfaccia.jRadioButtonVenerdiItemStateChanged()");
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonVenerdiItemStateChanged

    private void jRadioButtonSabatoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonSabatoItemStateChanged
        if(debug)System.out.println("Interfaccia.jRadioButtonSabatoItemStateChanged()");
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonSabatoItemStateChanged

    private void jRadioButtonDomenicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonDomenicaItemStateChanged
        if(debug)System.out.println("Interfaccia.jRadioButtonDomenicaItemStateChanged()");
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonDomenicaItemStateChanged

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        if(debug)System.out.println("Interfaccia.jList1ValueChanged()");
        if (!evt.getValueIsAdjusting())
        {//This line prevents double events
            aggiornaInterfacciaPesate();
            togglePannelloPulsantiProdotto();
        }
    }//GEN-LAST:event_jList1ValueChanged

    private void jButtonProdottoAggiungiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProdottoAggiungiMousePressed
        if(debug)System.out.println("Interfaccia.jButtonProdottoAggiungiMousePressed()");
        if(jButtonProdottoAggiungi.isEnabled())
        {
            JFAggiuntaPesata a = new JFAggiuntaPesata(interfPesate.idOrdine, font);
            a.setVisible(true);
            this.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonProdottoAggiungiMousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        if(debug)System.out.println("Interfaccia.jButton1MousePressed()");
        PrinterJob pj = PrinterJob.getPrinterJob();
        if (pj.printDialog()) {
        try {pj.print();}
        catch (PrinterException exc) {
            System.out.println(exc);
         }
     }   
    }//GEN-LAST:event_jButton1MousePressed

    private void jBProdottoEliminaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProdottoEliminaMousePressed
        if(debug)System.out.println("Interfaccia.jBProdottoEliminaMousePressed()");
        if(jBProdottoElimina.isEnabled())
        {
            JFEliminaPesata a = new JFEliminaPesata(interfPesate.idOrdine, font);
            a.setVisible(true);
            this.setEnabled(false);
        }
    }//GEN-LAST:event_jBProdottoEliminaMousePressed

    private void jBProdottoModificaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBProdottoModificaMousePressed
        if(debug)System.out.println("Interfaccia.jBProdottoModificaMousePressed()");
        if(jBProdottoModifica.isEnabled())
        {
            JFModificaPesata a = new JFModificaPesata(interfPesate.idOrdine, font);
            a.setVisible(true);
            this.setEnabled(false);
        }
    }//GEN-LAST:event_jBProdottoModificaMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBProdottoElimina;
    private javax.swing.JButton jBProdottoModifica;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonOrdineAggiungi;
    private javax.swing.JButton jButtonOrdineElimina;
    private javax.swing.JButton jButtonProdottoAggiungi;
    private javax.swing.JButton jButtonStampa;
    private javax.swing.JButton jButtonTara;
    private javax.swing.JComboBox jComboBoxCalendarioClienti;
    private javax.swing.JComboBox jComboBoxTara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCalendario;
    private javax.swing.JPanel jPanelOpzioni;
    private javax.swing.JPanel jPanelOrdini;
    private javax.swing.JPanel jPannelloPulsantiProdotto;
    private javax.swing.JRadioButton jRadioButtonDomenica;
    private javax.swing.JRadioButton jRadioButtonGiovedi;
    private javax.swing.JRadioButton jRadioButtonLunedi;
    private javax.swing.JRadioButton jRadioButtonMartedi;
    private javax.swing.JRadioButton jRadioButtonMercoledi;
    private javax.swing.JRadioButton jRadioButtonSabato;
    private javax.swing.JRadioButton jRadioButtonVenerdi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField ricercaComboCalendario;
    // End of variables declaration//GEN-END:variables


}
