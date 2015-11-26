/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import bollettario.FolderDataBase.StatoPesata;
import bollettario.FolderDataBase.Pesata;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 *
 * @author DiegoCarlo
 */
public class InterfBarraPesataNumero extends InterfBarraPesata{
   
    JButton jFMeno;
    JButton jBPiu;
    JToggleButton jTBprodotto;
    JTextField jTFQuantitaRichiesta;
    JTextField jTFQuantitaDaFare;
    JButton jBOk;
    //Pesata pesataRichiesta;
    //Pesata pesataDaFare;
    
    public InterfBarraPesataNumero(Pesata pesataRichiesta)
    {
        super(pesataRichiesta);
        this.jFMeno = new javax.swing.JButton();
        this.jTBprodotto = new javax.swing.JToggleButton();
        this.jBPiu = new javax.swing.JButton();
        this.jTFQuantitaRichiesta = new javax.swing.JTextField();
        this.jBOk = new javax.swing.JButton();
        this.jTFQuantitaDaFare = new javax.swing.JTextField();
        initComponents();
    }
    
    
    
    public void initComponents()
    {
        String nomeFont = "SansSerif";
        int dimFont = 25;
        Font fontGrassetto = new Font(nomeFont, Font.BOLD, dimFont);
        Font font = new Font(nomeFont, 0, dimFont);
        
        String prodotto = Bollettario.dataBase.elencoProdotti.get(pesataRichiesta.idProdotto);
        jTBprodotto.setText(nome);
        jTBprodotto.setFont(font);

        jFMeno.setText("-");
        jFMeno.setFont(font);
        
        jTFQuantitaRichiesta.setText(numero);
        jTFQuantitaRichiesta.setHorizontalAlignment(SwingConstants.CENTER);
        jTFQuantitaRichiesta.setFont(fontGrassetto);
        jTFQuantitaRichiesta.setEditable(false);
        
        jTFQuantitaDaFare.setText("0");
        jTFQuantitaDaFare.setHorizontalAlignment(SwingConstants.CENTER);
        jTFQuantitaDaFare.setFont(fontGrassetto);
        
        jBPiu.setText("+");
        jBPiu.setFont(font);
        
        jBOk.setText("OK");
        jBOk.setFont(font);
        
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
                .addComponent(jFMeno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFQuantitaDaFare, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBPiu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pannelloLayout.setVerticalGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFMeno, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(jBOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTBprodotto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jTFQuantitaRichiesta))
                    .addComponent(jTFQuantitaDaFare)
                    .addComponent(jBPiu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jBOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                switch(stato)
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
                }
            }
        });
        jTBprodotto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                switch(stato)
                {
                    case ESAURITA:
                        break;
                    case INATTIVA:
                        break;
                    case FOCUS_ATTIVA:
                        jTBprodotto.setSelected(true);
                        break;
                    case ATTIVA:
                        break;
                }
            }
        });
        jTBprodotto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                switch(stato)
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
                }
            }
        });
        jTFQuantitaRichiesta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTFQuantitaDaFare.setText(jTFQuantitaRichiesta.getText());
            }
        });
    }
}
