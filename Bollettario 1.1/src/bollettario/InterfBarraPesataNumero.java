package bollettario;

import bollettario.FolderDataBase.PrototipoPesata;
import bollettario.FolderDataBase.StatoPesata;
import java.awt.Event;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InterfBarraPesataNumero extends InterfBarraPesata{
   
    JButton jBMeno;
    JButton jBPiu;
    //Pesata pesataRichiesta;
    //Pesata pesataDaFare;
    
    public InterfBarraPesataNumero(long id, long idPesata)
    {
        super(id, idPesata);
        this.jBMeno = new javax.swing.JButton();
        this.jBPiu = new javax.swing.JButton();
        initComponents();
    }
    
    
    public void setEnableItems(boolean enable)
    {
        jBMeno.setEnabled(enable);
        jBPiu.setEnabled(enable);
        jTFQuantitaRichiesta.setEnabled(enable);
        jTFQuantitaFisica.setEnabled(enable);
    }
    public void initComponents()
    {
        super.initComponents();
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
        
        jTBOk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jTBOkStateChanged();
            }
        });
        
        jTBprodotto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
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
                if(jTFQuantitaRichiesta.isEnabled())
                {
                    aggiornaQFisica(quantitaRichiesta);
                    aggiornaInterfacciaStato();
                }
            }
        });
        jBPiu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(jBPiu.isEnabled())
                {
                    aggiornaQFisica(quantitaFisica+1);
                    
                    aggiornaInterfacciaStato();
                }
            }
        });
        jBMeno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
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
        quantitaFisica = valore;
        jTFQuantitaFisica.setText((int)valore+"");
        getPesata().quantitaFisica = quantitaFisica;
    }
}
