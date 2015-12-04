/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import bollettario.FolderDataBase.UnitaDiMisura;
import bollettario.FolderDataBase.Pesata;
import bollettario.FolderDataBase.Prodotto;
import bollettario.FolderDataBase.StatoPesata;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
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
    long idOrdine;
    ButtonGroup gruppo;
    public InterfPesate()
    {
        this.barrePesate = new ArrayList<InterfBarraPesata>();
        this.gruppo = new ButtonGroup();
    }
    
    public ArrayList<Long> getPesate()
    {
        ArrayList<Long> e = new ArrayList<Long>();
        for(int i=0; i<barrePesate.size(); i++)
        {
            e.add(barrePesate.get(i).idPesata);
        }
        return e;
    }
    public void creaBarrePesate()
    {
        if(idOrdine >= 0)
        {
            barrePesate = null;
            barrePesate = new ArrayList<InterfBarraPesata>();
            ArrayList<Long> listaIdPesate = Bollettario.dataBase.elencoPesate.listaIdPesate(idOrdine);
            for(int i=0; i<listaIdPesate.size(); i++)
            {
                // cerca la pesata
                Pesata pe = Bollettario.dataBase.getPesata(listaIdPesate.get(i));
                // cerca il prodotto
                Prodotto pr = Bollettario.dataBase.getProdotto(pe.idProdotto);
                InterfBarraPesata barra;
                switch(pr.unitaDiMisura)
                {
                    case QUANTITA:
                        barra = new InterfBarraPesataNumero(i, pe.getId());
                        break;
                    case KILOGRAMMO:
                        barra = new InterfBarraPesataPeso(i, pe.getId());
                        break;
                    default:
                        barra = new InterfBarraPesataPeso(i, pe.getId());
                }
                barrePesate.add(barra);
                gruppo.add(barra.jTBprodotto);
            }
        }
    }
    public void selezioneFocusPesata(int id)
    {
        for(int i=0; i<barrePesate.size(); i++)
        {
            /*if(
                    barrePesate.get(i).idPesata == StatoPesata.FOCUS_ATTIVA &&
                    barrePesate.get(i).id != id
            )
            {
                barrePesate.get(i).setStato(StatoPesata.ATTIVA);
            }*/
        }
    }

    public JPanel getJPanel(long idOrdine)
    {
        this.idOrdine = idOrdine;
        JPanel jPanelSfondo = new javax.swing.JPanel();
        
        if(idOrdine >= 0)
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

    public void aggiornaInterfaceStato()
    {
        for(int i=0; i < barrePesate.size(); i++)
        {
            barrePesate.get(i).aggiornaInterfacciaStato();
        }
    }

    public void aggiornaStatoBarreStampate()
    {
        for(int i=0; i < barrePesate.size(); i++)
        {
            if(barrePesate.get(i).getPesata().stato == StatoPesata.STAMPATA)
            {
                barrePesate.get(i).jTBOk.setEnabled(false);
            }
        }
    }
}