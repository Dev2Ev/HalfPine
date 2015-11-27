/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

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
public class InterfBarraPesataPeso extends InterfBarraPesata
{
    long idPesata;
    JTextField tara;
    JTextField qRichiesta;
    JTextField altro;
    JTextField qDaFare;

    public InterfBarraPesataPeso(long id, long idPesata)
    {
        super(id, idPesata);
        this.tara = new javax.swing.JTextField();
        this.qRichiesta = new javax.swing.JTextField();
        this.qDaFare = new javax.swing.JTextField();
        initComponents();
    }
    
    
    
    public void initComponents()
    {
        super.initComponents();
        String nomeFont = "SansSerif";
        int dimFont = 25;
        Font fontGrassetto = new Font(nomeFont, Font.BOLD, dimFont);
        Font font = new Font(nomeFont, 0, dimFont);
        
        Pesata p = Bollettario.dataBase.getPesata(idPesata);
        String nomeProdotto = Bollettario.dataBase.getProdotto(p.idProdotto).nome;
        jTBprodotto.setText(nomeProdotto);
        jTBprodotto.setFont(font);
        
        qRichiesta.setText(p.quantitaRichiesta+"");
        qRichiesta.setHorizontalAlignment(SwingConstants.CENTER);
        qRichiesta.setFont(fontGrassetto);
        
        qDaFare.setText("0");
        qDaFare.setHorizontalAlignment(SwingConstants.CENTER);
        qDaFare.setFont(font);
        
        tara.setText("0");
        tara.setHorizontalAlignment(SwingConstants.CENTER);
        tara.setFont(font);
        
        
        
        jBOk.setText("OK");
        jBOk.setFont(font);
        
        pannello.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        javax.swing.GroupLayout pannelloLayout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(pannelloLayout);
        pannelloLayout.setHorizontalGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTBprodotto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qRichiesta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tara, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qDaFare, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pannelloLayout.setVerticalGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTBprodotto, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                        .addComponent(jBOk, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(qDaFare))
                    .addComponent(qRichiesta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tara, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jTBprodotto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jTBprodottoStateChanged();
            }
        });
    }
}
