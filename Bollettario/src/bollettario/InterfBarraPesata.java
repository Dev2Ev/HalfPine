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
public class InterfBarraPesata {
   
    int id;
    JPanel pannello;
    JButton meno;
    JButton piu;
    JToggleButton prodotto;
    JTextField quantita;
    JTextField altro;
    StatoPesata stato;
    JTextField qDaFare;

    public InterfBarraPesata(String nome, String numero, int id)
    {
        this.id = id;
        this.pannello = new javax.swing.JPanel();
        this.meno = new javax.swing.JButton();
        this.prodotto = new javax.swing.JToggleButton();
        this.piu = new javax.swing.JButton();
        this.quantita = new javax.swing.JTextField();
        this.altro = new javax.swing.JTextField();
        this.stato = StatoPesata.INATTIVA;
        initComponents(nome, numero);
    }
    
    public void setStato(StatoPesata stato)
    {
        this.stato = stato;
        switch(stato)
        {
            case ESAURITA:
                pannello.setBackground(new Color(204, 204, 255));
                break;
            case INATTIVA:
                pannello.setBackground(new Color(240,240,240));
                break;
            case FOCUS_ATTIVA:
                pannello.setBackground(new Color(153, 255, 153));
                Bollettario.interfaccia.selezioneFocusPesata(id);
                break;
            case ATTIVA:
                pannello.setBackground(new Color(255, 255, 204));
        }
        
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
        
        quantita.setText(numero);
        quantita.setHorizontalAlignment(SwingConstants.CENTER);
        quantita.setFont(fontGrassetto);
        
        altro.setText("0");
        altro.setHorizontalAlignment(SwingConstants.CENTER);
        altro.setFont(new Font(nomeFont, Font.BOLD, 10));
        
        piu.setText("+");
        piu.setFont(font);
        
        pannello.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prodotto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(quantita, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qDaFare, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                    .addComponent(altro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(piu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jTextField3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        /*
        javax.swing.GroupLayout pannelloLayout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(pannelloLayout);
        pannelloLayout.setHorizontalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prodotto, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(meno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantita)
                    .addComponent(altro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(piu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pannelloLayout.setVerticalGroup(
            pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(piu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(meno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(prodotto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pannelloLayout.createSequentialGroup()
                            .addComponent(quantita)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(altro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );*/
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
