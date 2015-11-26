/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import bollettario.FolderDataBase.StatoPesata;
import bollettario.FolderDataBase.Quantita;
import bollettario.FolderDataBase.UnitaDiMisura;
import bollettario.FolderDataBase.Ordine;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.GroupLayout.Group;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JPanel;

/**
 *
 * @author DiegoCarlo
 */
public class InterfPesate {
    private ArrayList<InterfBarraPesata> barrePesate;
    Ordine ordineSelezionato;

    public InterfPesate()
    {
        barrePesate = new ArrayList<InterfBarraPesata>();
    }
    
    
    public void creaBarrePesate()
    {
        if(ordineSelezionato != null)
        {
            barrePesate = null;
            barrePesate = new ArrayList<InterfBarraPesata>();
            for(int i=0; i<ordineSelezionato.size(); i++)
            {
                String nome = ordineSelezionato.get(i).idProdotto;
                Quantita quantita = ordineSelezionato.get(i).quantita;
                if(quantita.unita == UnitaDiMisura.NUMERO)
                {
                    barrePesate.add(new InterfBarraPesataNumero(nome, quantita.toString(), i));
                }
                if(quantita.unita == UnitaDiMisura.KILOGRAMMI)
                {
                    barrePesate.add(new InterfBarraPesataPeso(nome, quantita.toString(), i));
                }
            }
        }
    }
    public void selezioneFocusPesata(int id)
    {
        for(int i=0; i<barrePesate.size(); i++)
        {
            if(
                    barrePesate.get(i).stato == StatoPesata.FOCUS_ATTIVA &&
                    barrePesate.get(i).id != id
            )
            {
                barrePesate.get(i).setStato(StatoPesata.ATTIVA);
            }
        }
    }

    public JPanel getJPanel(Ordine ordineSelezionato)
    {
        this.ordineSelezionato = ordineSelezionato;
        JPanel jPanelSfondo = new javax.swing.JPanel();
        
        if(ordineSelezionato != null)
        {
            creaBarrePesate();
            jPanelSfondo = new JPanel();
            javax.swing.GroupLayout jPanelSfondoLayout = new javax.swing.GroupLayout(jPanelSfondo);
            jPanelSfondo.setLayout(jPanelSfondoLayout);

            ParallelGroup gruppoParallelo2 = jPanelSfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
            for(int i=0; i<barrePesate.size(); i++)
            {
                gruppoParallelo2.addComponent(
                        barrePesate.get(i).pannello,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE);
            }

            SequentialGroup gruppoSequenziale = jPanelSfondoLayout.createSequentialGroup();
            gruppoSequenziale.addContainerGap();
            gruppoSequenziale.addGroup(gruppoParallelo2);
            gruppoSequenziale.addContainerGap();

            ParallelGroup gruppoParallelo1 = jPanelSfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
            gruppoParallelo1.addGroup(gruppoSequenziale);

            jPanelSfondoLayout.setHorizontalGroup(gruppoParallelo1);

            SequentialGroup gruppoV2 = jPanelSfondoLayout.createSequentialGroup();
            gruppoV2.addContainerGap();
            for(int i=0; i<barrePesate.size(); i++)
            {
                if(i != 0)
                {
                    gruppoV2.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
                }
                gruppoV2.addComponent(barrePesate.get(i).pannello,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE);
            }
            gruppoV2.addContainerGap();
            Group gruppoV = jPanelSfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER);
            gruppoV.addGroup(gruppoV2);
            jPanelSfondoLayout.setVerticalGroup(gruppoV);
        }
        return jPanelSfondo;
    }
}