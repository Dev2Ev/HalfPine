/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import bollettario.FolderDataBase.StatoPesata;
import bollettario.FolderDataBase.Pesata;
import bollettario.FolderDataBase.Prodotto;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 *
 * @author DiegoCarlo
 */
public class InterfBarraPesata
{
    public JPanel pannello;
    public long idPesata;
    public JToggleButton jTBprodotto;
    public JToggleButton jTBOk;
    public JTextField jTFQuantitaRichiesta;
    public long id;
    protected Font fontGrassetto;
    protected Font font;
    
    public InterfBarraPesata(long id, long idPesata)
    {
        this.id = id;
        this.idPesata = idPesata;
        this.pannello = new JPanel();
        this.jTBprodotto = new JToggleButton();
        this.jTBOk = new JToggleButton();
        this.jTFQuantitaRichiesta = new javax.swing.JTextField();
        Pesata pe = Bollettario.dataBase.getPesata(idPesata);
        switch(pe.stato)
        {
            case ATTESA_PESO:
                jTBprodotto.setSelected(true);
                jTBOk.setSelected(false);
                break;
            case INATTIVA:
                jTBprodotto.setSelected(false);
                jTBOk.setSelected(false);
                break;
            case PESATA:
                jTBprodotto.setSelected(false);
                jTBOk.setSelected(true);
                break;
                
        }
    }
    public void jTBprodottoStateChanged()
    {
        /*System.out.println(jTBprodotto.getText());
        Pesata pe = Bollettario.dataBase.getPesata(idPesata);
        // cerca il prodotto
        Prodotto pr = Bollettario.dataBase.getProdotto(pe.idProdotto);
        System.out.print(pe.getId() + " " + pr.nome+"\n");*/
        StatoPesata stato = Bollettario.dataBase.getPesata(idPesata).stato;
        if(jTBprodotto.isSelected())
        {
            stato = StatoPesata.ATTESA_PESO;
            jTBOk.setEnabled(true);
        }
        else
        {
            if(!jTBOk.isSelected())
            {
                stato = StatoPesata.INATTIVA;
                jTBOk.setEnabled(false);
            }
        }
        Bollettario.dataBase.getPesata(idPesata).stato = stato;
        aggiornaInterfacciaStato();
        
        salva();
    }
    public void initComponents()
    {
        
        String nomeFont = "SansSerif";
        int dimFont = 25;
        fontGrassetto = new Font(nomeFont, Font.BOLD, dimFont);
        font = new Font(nomeFont, 0, dimFont);
        
        Pesata pe = Bollettario.dataBase.getPesata(idPesata);
        // cerca il prodotto
        Prodotto pr = Bollettario.dataBase.getProdotto(pe.idProdotto);
        
        //System.out.print(pe.getId() + " " + pr.nome+"\n");
        
        aggiornaInterfacciaStato();
        
        jTBprodotto.setText(pr.nome);
        jTBprodotto.setFont(font);

        
        int a = (int)pe.quantitaRichiesta;
        jTFQuantitaRichiesta.setText(a+"");
        jTFQuantitaRichiesta.setHorizontalAlignment(SwingConstants.CENTER);
        jTFQuantitaRichiesta.setFont(fontGrassetto);
        jTFQuantitaRichiesta.setEditable(false);
        
        jTBOk.setEnabled(false);
        
        jTBOk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                StatoPesata stato;
                if(jTBOk.isSelected())
                {
                   stato = StatoPesata.PESATA;
                }
                else
                {
                    stato = StatoPesata.ATTESA_PESO;
                }
                Bollettario.dataBase.getPesata(idPesata).stato = stato;
                aggiornaInterfacciaStato();
                
                salva();
            }
        });
        aggiornaInterfacciaStato();
    }
    public void aggiornaInterfacciaStato()
    {
        Pesata pe = Bollettario.dataBase.getPesata(idPesata);
        
        switch(pe.stato)
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
    protected void salva()
    {
        Bollettario.salva();
    }
}
