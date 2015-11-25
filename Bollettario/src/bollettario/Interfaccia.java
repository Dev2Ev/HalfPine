/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JPanel;
import javax.swing.table.TableColumn;

/**
 *
 * @author DiegoCarlo
 */
public class Interfaccia extends javax.swing.JFrame {

    /**
     * Creates new form Interfaccia
     */
    InterfPesate interfPesate;
    Font font = font = new Font("SansSerif", 0, 20);
    Dimension dimRadioButton = new Dimension(200, 100);
    Calendar giornoVisualizzato;
    int giornoDaVisualizzare;
    ElencoOrdini elencoJListOrdini;
    
    public Interfaccia() {
        initComponents();
        initComponents2();
    }

    private void initComponents2()
    {
        initJTable();
        ricercaComboCalendario.setText("");
        initComboCalendario();
        initTime();
        initListaOrdini();
        initScrollPanelPesate();
        aggiornaInterfacciaPesate();
    }
    private void initListaOrdini()
    {
        /*ElencoOrdini selezione = Bollettario.dataBase.elencoPrototipiOrdini.getOrdiniGiorno(getOggi());
        
        DefaultListModel listModel = new DefaultListModel();
        for(int i=0; i<selezione.size(); i++)
        {
            String ragioneSociale = Bollettario.dataBase.elencoClienti.get(
                    selezione.get(i).codiceCliente
            ).ragioneSociale;
            listModel.addElement(
                    new ElementoIndicizzato(
                            selezione.get(i).id
                            ragioneSociale
                    )
            );
        }
        
           
        if(selezione.size()>0)
        {
            jList1.setModel(listModel);
        }*/
    }
    private void initScrollPanelPesate()
    {
        jScrollPane5.getVerticalScrollBar().setPreferredSize(new Dimension(50, 0));
    }
    private void initTime()
    {
        Calendar c = GregorianCalendar.getInstance();
        giornoDaVisualizzare = c.get(Calendar.DAY_OF_WEEK);
        
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
    private void aggiornaTab()
    {
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
    private void aggiornaPannelloOrdini()
    {
        setGiornoDaVisualizzare();
        togglePulsanti();
        aggiornaListaOrdini();
    }
    private void aggiornaInterfacciaPesate()
    {
        interfPesate = new InterfPesate();
        jScrollPane5.setViewportView(interfPesate.getJPanel(elencoJListOrdini.get(jList1.getSelectedIndex())));
    }
    private void aggiornaListaOrdini()
    {
        int gap = giornoDaVisualizzare - GregorianCalendar.getInstance().get(Calendar.DAY_OF_WEEK);
        Calendar c = GregorianCalendar.getInstance();
        c.add(GregorianCalendar.DAY_OF_MONTH, gap);
        elencoJListOrdini = Bollettario.dataBase.elencoiOrdini.getOrdiniGiorno(c);
        elencoJListOrdini.ordinaData();
        final String[] testoLista = new String[elencoJListOrdini.size()];
        for(int i=0; i<elencoJListOrdini.size(); i++)
        {
            String codice = elencoJListOrdini.get(i).codiceCliente;
            String ragioneSociale = Bollettario.dataBase.elencoClienti.get(codice).ragioneSociale;
            testoLista[i] = ragioneSociale;
        }
        jList1.setModel(new javax.swing.AbstractListModel() {
        String[] strings = testoLista;
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
        });
    }
    private void togglePulsanti()
    {
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
        
    }
    private void initComboCalendario()
    {
        ElencoClienti selezione = new ElencoClienti();
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
        jComboBoxCalendarioClienti.setModel(new javax.swing.DefaultComboBoxModel(comboCalendario));
    }
    private void aggiornaPannelloOpzioni()
    {
        
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonProdottoAggiungi = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanelCalendario = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBoxCalendarioClienti = new javax.swing.JComboBox();
        ricercaComboCalendario = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jPanelOpzioni = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });

        buttonGroup1.add(jRadioButtonLunedi);
        jRadioButtonLunedi.setText("Lunedì");
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
        jButtonStampa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonStampaMousePressed(evt);
            }
        });
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

        jButton1.setText("Aggiungi");
        jButton1.setFont(font);

        jButton3.setText("Elimina");
        jButton3.setFont(font);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Prodotto"));

        jButtonProdottoAggiungi.setText("Aggiungi");
        jButtonProdottoAggiungi.setFont(font);

        jButton4.setText("Elimina");
        jButton4.setFont(font);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonProdottoAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProdottoAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jRadioButtonLunedi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonLunedi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonMartedi)
                    .addComponent(jRadioButtonMercoledi)
                    .addComponent(jRadioButtonGiovedi)
                    .addComponent(jRadioButtonVenerdi)
                    .addComponent(jRadioButtonSabato)
                    .addComponent(jRadioButtonDomenica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrdiniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonStampa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxTara, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanelOpzioniLayout = new javax.swing.GroupLayout(jPanelOpzioni);
        jPanelOpzioni.setLayout(jPanelOpzioniLayout);
        jPanelOpzioniLayout.setHorizontalGroup(
            jPanelOpzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 989, Short.MAX_VALUE)
        );
        jPanelOpzioniLayout.setVerticalGroup(
            jPanelOpzioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 715, Short.MAX_VALUE)
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
        aggiornaTab();
    }//GEN-LAST:event_jTabbedPaneStateChanged

    private void ricercaComboCalendarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ricercaComboCalendarioKeyReleased
        initComboCalendario();
    }//GEN-LAST:event_ricercaComboCalendarioKeyReleased

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        ricercaComboCalendario.setText("");
        initComboCalendario();
    }//GEN-LAST:event_jButton6MousePressed

    private void jButtonStampaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonStampaMousePressed
              
    }//GEN-LAST:event_jButtonStampaMousePressed

    private void jRadioButtonLunediItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonLunediItemStateChanged
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonLunediItemStateChanged

    private void jRadioButtonMartediItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMartediItemStateChanged
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonMartediItemStateChanged

    private void jRadioButtonMercolediItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMercolediItemStateChanged
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonMercolediItemStateChanged

    private void jRadioButtonGiovediItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonGiovediItemStateChanged
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonGiovediItemStateChanged

    private void jRadioButtonVenerdiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonVenerdiItemStateChanged
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonVenerdiItemStateChanged

    private void jRadioButtonSabatoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonSabatoItemStateChanged
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonSabatoItemStateChanged

    private void jRadioButtonDomenicaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonDomenicaItemStateChanged
        aggiornaPannelloOrdini();
    }//GEN-LAST:event_jRadioButtonDomenicaItemStateChanged

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        aggiornaInterfacciaPesate();
    }//GEN-LAST:event_jList1ValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCalendario;
    private javax.swing.JPanel jPanelOpzioni;
    private javax.swing.JPanel jPanelOrdini;
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
