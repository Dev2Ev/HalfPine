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

/**
 *
 * @author DiegoCarlo
 */
public class InterfBarraPesata
{
    public JPanel pannello;
    public long idPesata;
    public long id;
    
    public InterfBarraPesata(long id, long idPesata)
    {
        this.id = id;
        this.idPesata = idPesata;
        pannello = new JPanel();
    }

    public void setStato(StatoPesata stato)
    {
        /*
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
                // Bollettario.interfaccia.selezioneFocusPesata(id);
                break;
            case ATTIVA:
                pannello.setBackground(new Color(255, 255, 204));
        }*/
    }
    public long getId()
    {
        return idPesata;
    }
}
