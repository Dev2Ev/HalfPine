package bollettario;

import static bollettario.Bollettario.debug;
import bollettario.FolderDataBase.PrototipoPesata;
import bollettario.FolderDataBase.StatoPesata;
import javax.swing.JButton;

public class InterfBarraPesataNumero extends InterfBarraPesata{
   
    JButton jBMeno;
    JButton jBPiu;
    //Pesata pesataRichiesta;
    //Pesata pesataDaFare;
    
    public InterfBarraPesataNumero(long id, long idPesata)
    {
        super(id, idPesata);
        if(debug)System.out.println("InterfBarraPesataNumero.InterfBarraPesataNumero()");
        this.jBMeno = new javax.swing.JButton();
        this.jBPiu = new javax.swing.JButton();
        initComponents();
    }
    
    
    public void setEnableItems(boolean enable)
    {
        if(debug)System.out.println("InterfBarraPesataNumero.setEnableItems()");
        jBMeno.setEnabled(enable);
        jBPiu.setEnabled(enable);
        jTFQuantitaRichiesta.setEnabled(enable);
        jTFQuantitaFisica.setEnabled(enable);
    }
    public void initComponents()
    {
        super.initComponents();
        if(debug)System.out.println("InterfBarraPesataNumero.initComponents()");
        setEnableItems(false);
        
        jBMeno.setText("-");
        jBMeno.setFont(font);

        jBPiu.setText("+");
        jBPiu.setFont(font);
        
        aggiornaQFisica(getPesata().quantitaFisica);
        
        jTBOk.setText("OK");
        jTBOk.setFont(font);
        
        pannello.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        javax.swing.GroupLayout pannelloLayout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(pannelloLayout);
        pannelloLayout.setHorizontalGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTBprodotto, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFQuantitaRichiesta, javax.swing.GroupLayout.PREFERRED_SIZE, larghezzaJText-15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBMeno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFQuantitaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, larghezzaJText-15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPiu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTBOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pannelloLayout.setVerticalGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBMeno, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(jTBOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTBprodotto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTFQuantitaRichiesta))
                    .addComponent(jTFQuantitaFisica)
                    .addComponent(jBPiu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        
        jTBOk.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                if(debug)System.out.println("InterfBarraPesataNumero.jTBOk.itemStateChanged()");
                jTBOkStateChanged();
            }
        });
        
        jTBprodotto.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                if(debug)System.out.println("InterfBarraPesataNumero.jTBprodotto.itemStateChanged()");
                jTBprodottoStateChanged();
                if(jTBprodotto.isSelected())
                {
                    setEnableItems(true);
                }
                else
                {
                    setEnableItems(false);
                }
            }
        });
        jTBprodotto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(debug)System.out.println("InterfBarraPesataNumero.jTBprodotto.mousePressed()");
                /*switch(stato)
                {
                    case ESAURITA: break;
                    case INATTIVA: 
                        //prodotto.setSelected(true);
                        setStato(StatoPesata.FOCUS_ATTIVA);
                        break;
                    case FOCUS_ATTIVA:
                        //prodotto.setSelected(false);
                        setStato(StatoPesata.INATTIVA);
                        break;
                    case ATTIVA: 
                        setStato(StatoPesata.FOCUS_ATTIVA);
                        break;
                }*/
            }
        });
        jTFQuantitaRichiesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(debug)System.out.println("InterfBarraPesataNumero.jTFQuantitaRichiesta.mousePressed()");
                if(jTFQuantitaRichiesta.isEnabled())
                {
                    aggiornaQFisica(quantitaRichiesta);
                    aggiornaInterfacciaStato();
                }
            }
        });
        jBPiu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(debug)System.out.println("InterfBarraPesataNumero.jBPiu.mousePressed()");
                if(jBPiu.isEnabled())
                {
                    aggiornaQFisica(quantitaFisica+1);
                    
                    aggiornaInterfacciaStato();
                }
            }
        });
        jBMeno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(debug)System.out.println("InterfBarraPesataNumero.jBMeno.mousePressed()");
                if(jBMeno.isEnabled())
                {
                    float temp = quantitaFisica - 1;
                    if(temp < 0) temp = 0;
                    aggiornaQFisica(temp);
                    
                    aggiornaInterfacciaStato();
                }
            }
        });
    }
    protected void jTBOkStateChanged()
    {
        if(debug)System.out.println("InterfBarraPesataNumero.jTBOkStateChanged()");
        PrototipoPesata pe = getPesata();
        boolean valida = jTBOk.isSelected();
        if(valida)
        {
            pe.stato = StatoPesata.VALIDA;
            stato = StatoInterfBarraPesata.NON_ATTIVA;
            setEnableItems(false);
        }
        else
        {
            pe.stato = StatoPesata.NUOVA;
            stato = StatoInterfBarraPesata.ATTIVA;
            aggiornaQFisica(0);
            setEnableItems(true);
        }
        valida = !valida;
        
        jTBprodotto.setEnabled(valida);
        Bollettario.interfaccia.interfPesate.gruppo.clearSelection();
        aggiornaInterfacciaStato();
    }
    private void aggiornaQFisica(float valore)
    {
        if(debug)System.out.println("InterfBarraPesataNumero.aggiornaQFisica()");
        quantitaFisica = valore;
        jTFQuantitaFisica.setText((int)valore+"");
        getPesata().quantitaFisica = quantitaFisica;
    }
}
