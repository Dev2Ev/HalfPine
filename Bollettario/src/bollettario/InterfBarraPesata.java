/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import bollettario.FolderDataBase.StatoPesata;
import bollettario.FolderDataBase.Pesata;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author DiegoCarlo
 */
public class InterfBarraPesata
{
    public JPanel pannello;
    public long idPesata;
    public JToggleButton jTBprodotto;
    public JToggleButton jBOk;
    public long id;
    private StatoPesata stato;
    
    public InterfBarraPesata(long id, long idPesata)
    {
        this.id = id;
        this.idPesata = idPesata;
        this.pannello = new JPanel();
        this.jTBprodotto = new JToggleButton();
        this.jBOk = new JToggleButton();
    }
    public void jTBprodottoStateChanged()
    {
        if(jTBprodotto.isSelected())
        {
            setStato(StatoPesata.ATTESA_PESO);
            jBOk.setEnabled(true);
        }
        else
        {
            if(!jBOk.isSelected())
            {
                setStato(StatoPesata.INATTIVA);
                jBOk.setEnabled(false);
            }
        }
    }
    public void initComponents()
    {
        jBOk.setEnabled(false);
        
        jBOk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                if(jBOk.isSelected())
                {
                    setStato(StatoPesata.PESATA);
                }
                else
                {
                    setStato(StatoPesata.ATTESA_PESO);
                }
            }
        });
    }
    public void setStato(StatoPesata stato)
    {
        this.stato = stato;
        switch(stato)
        {
            case INATTIVA:
                pannello.setBackground(new Color(240,240,240));// grigio
                break;
            case ATTESA_PESO:
                pannello.setBackground(new Color(204, 204, 255));
                break;
            case PESATA:
                pannello.setBackground(new Color(153, 255, 153));
                break;
        }
    }
    public long getId()
    {
        return idPesata;
    }
}
