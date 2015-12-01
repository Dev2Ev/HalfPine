/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author DiegoCarlo
 */
public class InterfBarraPesataNumero extends InterfBarraPesata{
   
    JButton jBMeno;
    JButton jBPiu;
    JTextField jTFQuantitaDaFare;
    //Pesata pesataRichiesta;
    //Pesata pesataDaFare;
    
    public InterfBarraPesataNumero(long id, long idPesata)
    {
        super(id, idPesata);
        this.jBMeno = new javax.swing.JButton();
        this.jBPiu = new javax.swing.JButton();
        this.jTFQuantitaDaFare = new javax.swing.JTextField();
        initComponents();
    }
    
    
    public void setEnableItems(boolean enable)
    {
        jBMeno.setEnabled(enable);
        jBPiu.setEnabled(enable);
        jTFQuantitaRichiesta.setEnabled(enable);
        jTFQuantitaDaFare.setEnabled(enable);
    }
    public void initComponents()
    {
        super.initComponents();
        setEnableItems(false);
        
        
        jBMeno.setText("-");
        jBMeno.setFont(font);
        
        jTFQuantitaDaFare.setText("0");
        jTFQuantitaDaFare.setHorizontalAlignment(SwingConstants.CENTER);
        jTFQuantitaDaFare.setFont(fontGrassetto);
        
        jBPiu.setText("+");
        jBPiu.setFont(font);
        
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
                .addComponent(jTFQuantitaRichiesta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBMeno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFQuantitaDaFare, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jTFQuantitaDaFare)
                    .addComponent(jBPiu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jTBOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                /*switch(stato)
                {
                    case ESAURITA:
                        break;
                    case INATTIVA:
                        break;
                    case FOCUS_ATTIVA:
                        setStato(StatoPesata.ATTIVA);
                        break;
                    case ATTIVA:
                        break;
                }*/
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
                    if(jTBOk.isSelected())
                    {
                        setEnableItems(true);
                    }
                    else
                    {
                        setEnableItems(false);
                    }
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
                    jTFQuantitaDaFare.setText(jTFQuantitaRichiesta.getText());
                }
            }
        });
        jBPiu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(jBPiu.isEnabled())
                {
                    String cifra = jTFQuantitaDaFare.getText();
                    int numero;
                    try
                    {
                        numero = Integer.parseInt(cifra);
                        numero++;
                    } catch (NumberFormatException e) {
                          numero = 0;
                    }
                    jTFQuantitaDaFare.setText(numero+"");
                }
            }
        });
        jBMeno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(jBMeno.isEnabled())
                {
                    String cifra = jTFQuantitaDaFare.getText();
                    int numero;
                    try
                    {
                        numero = Integer.parseInt(cifra);
                        if(numero > 0)
                        {
                            numero--;
                        }
                    } catch (NumberFormatException e) {
                          numero = 0;
                    }
                    jTFQuantitaDaFare.setText(numero+"");
                }
            }
        });
    }
}
