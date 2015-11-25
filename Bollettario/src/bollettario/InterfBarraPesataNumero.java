/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

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
   
    JButton meno;
    JButton piu;
    JToggleButton prodotto;
    JTextField qRichiesta;
    JTextField qDaFare;
    JButton ok;

    public InterfBarraPesataNumero(String nome, String numero, int id)
    {
        super(id);
        this.meno = new javax.swing.JButton();
        this.prodotto = new javax.swing.JToggleButton();
        this.piu = new javax.swing.JButton();
        this.qRichiesta = new javax.swing.JTextField();
        this.ok = new javax.swing.JButton();
        this.qDaFare = new javax.swing.JTextField();
        initComponents(nome, numero);
    }
    
    
    
    public void initComponents(String nome, String numero)
    {
        String nomeFont = "SansSerif";
        int dimFont = 25;
        Font fontGrassetto = new Font(nomeFont, Font.BOLD, dimFont);
        Font font = new Font(nomeFont, 0, dimFont);
        prodotto.setText(nome);
        prodotto.setFont(font);

        meno.setText("-");
        meno.setFont(font);
        
        qRichiesta.setText(numero);
        qRichiesta.setHorizontalAlignment(SwingConstants.CENTER);
        qRichiesta.setFont(fontGrassetto);
        
        piu.setText("+");
        piu.setFont(font);
        
        ok.setText("OK");
        ok.setFont(font);
        
        pannello.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        javax.swing.GroupLayout pannelloLayout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(pannelloLayout);
        pannelloLayout.setHorizontalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prodotto, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qRichiesta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meno, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qDaFare, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(piu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pannelloLayout.setVerticalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(meno, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prodotto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(qRichiesta))
                    .addComponent(qDaFare)
                    .addComponent(piu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
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
        prodotto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                switch(stato)
                {
                    case ESAURITA:
                        break;
                    case INATTIVA:
                        break;
                    case FOCUS_ATTIVA:
                        prodotto.setSelected(true);
                        break;
                    case ATTIVA:
                        break;
                }
            }
        });
        prodotto.addMouseListener(new java.awt.event.MouseAdapter() {
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
    }
}
