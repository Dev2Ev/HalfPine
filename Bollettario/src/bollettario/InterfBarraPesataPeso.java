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
public class InterfBarraPesataPeso extends InterfBarraPesata
{
   
    JTextField tara;
    JToggleButton prodotto;
    JTextField qRichiesta;
    JTextField altro;
    JTextField qDaFare;
    JButton ok;

    public InterfBarraPesataPeso(String nome, String numero, int id)
    {
        super(id);
        this.prodotto = new javax.swing.JToggleButton();
        this.tara = new javax.swing.JTextField();
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
        
        qRichiesta.setText(numero);
        qRichiesta.setHorizontalAlignment(SwingConstants.CENTER);
        qRichiesta.setFont(fontGrassetto);
        
        qDaFare.setText("0");
        qDaFare.setHorizontalAlignment(SwingConstants.CENTER);
        qDaFare.setFont(font);
        
        tara.setText("0");
        tara.setHorizontalAlignment(SwingConstants.CENTER);
        tara.setFont(font);
        
        
        
        ok.setText("OK");
        ok.setFont(font);
        
        pannello.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        
        javax.swing.GroupLayout pannelloLayout = new javax.swing.GroupLayout(pannello);
        pannello.setLayout(pannelloLayout);
        pannelloLayout.setHorizontalGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prodotto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qRichiesta, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tara, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qDaFare, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pannelloLayout.setVerticalGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(prodotto, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                        .addComponent(ok, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                    .addGroup(pannelloLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(qDaFare))
                    .addComponent(qRichiesta, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tara, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
    }
}
