/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import bollettario.FolderDataBase.Cliente;
import bollettario.FolderDataBase.Ordine;
import bollettario.FolderDataBase.Pesata;
import bollettario.FolderDataBase.Prodotto;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;

/**
 *
 * @author Armandillo
 */
public class JFModificaPesata extends javax.swing.JFrame {

    /**
     * Creates new form ModificaPesata
     */
    ArrayList<Long> elencoJListPesate;
    Font font;
    float quantita;
    long idOrdine;
    
    public JFModificaPesata(long idOrdine, Font font)
    {
        this.font = font;
        this.idOrdine = idOrdine;
        initComponents();
        
        Ordine o = Bollettario.dataBase.getOrdine(idOrdine);
        
        Cliente c = Bollettario.dataBase.getCliente(o.idCliente);
        
        jLabel1.setText(c.ragioneSociale);
        
        popolaJlist();
        
        verificaCorrettezza();
    }
    private void verificaCorrettezza()
    {
        int i = jList1.getSelectedIndex();
        if(quantita > 0 && (i >= 0 && i < elencoJListPesate.size()))
        {
            jButtonAggiungi.setEnabled(true);
        }
        else
        {
            jButtonAggiungi.setEnabled(false);
        }
    }
    public void popolaJlist()
    {
        elencoJListPesate = Bollettario.interfaccia.interfPesate.getPesate();
        final String[] testoLista = new String[elencoJListPesate.size()];
        for(int i=0; i<elencoJListPesate.size(); i++)
        {
            Long idPesata = elencoJListPesate.get(i);
            Pesata pe = Bollettario.dataBase.getPesata(idPesata);
            Prodotto pr = Bollettario.dataBase.elencoProdotti.get(pe.idProdotto);
            
            String nome = pr.nome;
            testoLista[i] = idPesata + "| " + nome;
        }
        jList1.setModel(new javax.swing.AbstractListModel() {
        String[] strings = testoLista;
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
        });
        verificaCorrettezza();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jButtonAggiungi = new javax.swing.JButton();

        setTitle("Modifica della Pesata");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jList1.setFont(font);
        jScrollPane1.setViewportView(jList1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prodotto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18))); // NOI18N

        jTextField1.setFont(font);
        jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setFont(font);
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel1.setText("jLabel1");
        jLabel1.setFont(font);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        jButtonReset.setText("Reset");
        jButtonReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonResetMouseClicked(evt);
            }
        });
        jButtonReset.setFont(font);

        jButtonAggiungi.setText("Inserisci");
        jButtonAggiungi.setFont(font);
        jButtonAggiungi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonAggiungiMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAggiungi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        int i = jList1.getSelectedIndex();
        if(i >= 0 && i < elencoJListPesate.size())
        {
            Pesata pe = Bollettario.dataBase.getPesata(elencoJListPesate.get(i));
            Prodotto pr = Bollettario.dataBase.getProdotto(pe.idProdotto);
            String a = " "+pr.unitaDiMisura;
            String nome = pr.nome+a;
            jLabel2.setText(nome);
            
            quantita = pe.quantitaRichiesta;
            jTextField1.setText(quantita+"");
        }
        verificaCorrettezza();
    }//GEN-LAST:event_jList1ValueChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        try
        {
            float valore = Float.parseFloat(jTextField1.getText());
            quantita = valore;
            verificaCorrettezza();
        }
        catch(NumberFormatException e)
        {
            quantita = 0;
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButtonResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonResetMouseClicked
        reset();
    }//GEN-LAST:event_jButtonResetMouseClicked
    public void reset()
    {
        jList1.setSelectedIndex(-1);
        jLabel2.setText("");
        quantita = 0;
        jTextField1.setText(quantita+"");
    }
    private void jButtonAggiungiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAggiungiMousePressed
        if(jButtonAggiungi.isEnabled())
        {
            long idPesata = elencoJListPesate.get(jList1.getSelectedIndex());
            Pesata pe = Bollettario.dataBase.elencoPesate.get(idPesata);
            try
            {
                quantita = Float.parseFloat(jTextField1.getText());
                pe.quantitaRichiesta = quantita;
                Bollettario.salva();
                this.setVisible(false);
                Bollettario.interfaccia.aggiorna();
            }
            catch(NumberFormatException c)
            {
                
            }
        }
    }//GEN-LAST:event_jButtonAggiungiMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Bollettario.interfaccia.setEnabled(true);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAggiungi;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
