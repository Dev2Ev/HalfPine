/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import bollettario.FolderDataBase.StatoPesata;
import bollettario.FolderDataBase.PrototipoPesata;
import bollettario.FolderDataBase.Prodotto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 * Questa classe gestisce l'interfaccia di una singola pesata
 * @author DiegoCarlo
 */
public class InterfBarraPesata
{
    
    public long id;
    public long idPesata;
    
    protected static int iconDimension = 30;
    protected static int larghezzaJText = 150;
    
    public JPanel pannello;
    public JToggleButton jTBprodotto;
    public JToggleButton jTBOk;
    public JTextField jTFQuantitaRichiesta;
    public JTextField jTFQuantitaFisica;
    
    protected float quantitaRichiesta;
    protected float quantitaFisica;
    
    protected Font fontGrassetto;
    protected Font font;
    
    protected StatoInterfBarraPesata stato;
    
    public InterfBarraPesata(long id, long idPesata)
    {
        this.id = id;
        this.idPesata = idPesata;
        this.pannello = new JPanel();
        this.jTBprodotto = new JToggleButton();
        this.jTBprodotto.setMaximumSize(new Dimension(180, 100));
        this.jTBOk = new JToggleButton();
        this.jTFQuantitaRichiesta = new javax.swing.JTextField();
        this.jTFQuantitaFisica = new javax.swing.JTextField();
        
        PrototipoPesata pe = getPesata();
        
        this.quantitaRichiesta = pe.quantitaRichiesta;
        this.quantitaFisica = pe.quantitaFisica;
        
        switch(pe.stato)
        {
            case NUOVA:
                jTBOk.setSelected(false);
                break;
            case VALIDA:
                jTBOk.setSelected(true);
                break;
            case STAMPATA:
                jTBOk.setSelected(true);
                break;    
        }
        stato = StatoInterfBarraPesata.NON_ATTIVA;
        aggiornaInterfacciaStato();
    }
    protected PrototipoPesata getPesata()
    {
        return Bollettario.dataBase.getPesata(idPesata);
    }
    public void jTBprodottoStateChanged()
    {
        if(jTBprodotto.isSelected())
        {
            stato = StatoInterfBarraPesata.ATTIVA;
        }
        else
        {
            stato = StatoInterfBarraPesata.NON_ATTIVA;
        }
        aggiornaInterfacciaStato();
    }
    protected Prodotto getProdotto(PrototipoPesata pe)
    {
        return Bollettario.dataBase.getProdotto(pe.idProdotto);
    }
    public void initComponents()
    {
        String nomeFont = "SansSerif";
        int dimFont = 25;
        fontGrassetto = new Font(nomeFont, Font.BOLD, dimFont);
        font = new Font(nomeFont, 0, dimFont);
        
        PrototipoPesata pe = getPesata();
        // cerca il prodotto
        Prodotto pr = getProdotto(pe);
        
        //System.out.print(pe.getId() + " " + pr.nome+"\n");
        
        aggiornaInterfacciaStato();
        
        jTBprodotto.setText(pr.nome);
        jTBprodotto.setFont(font);

        
        int a = (int)pe.quantitaRichiesta;
        jTFQuantitaRichiesta.setText(a+"");
        jTFQuantitaRichiesta.setHorizontalAlignment(SwingConstants.CENTER);
        jTFQuantitaRichiesta.setFont(fontGrassetto);
        jTFQuantitaRichiesta.setEditable(false);
        
        
        jTFQuantitaFisica.setHorizontalAlignment(SwingConstants.CENTER);
        jTFQuantitaFisica.setFont(fontGrassetto);
        
        
        
        aggiornaInterfacciaStato();
    }
    /**
     * 
     */
   
    public void aggiornaInterfacciaStato()
    {
        
        switch(stato)
        {
            case ATTIVA:
                pannello.setBackground(new Color(153, 255, 153));
                break;
            case NON_ATTIVA:
                switch(getPesata().stato)
                {
                    case NUOVA:
                        pannello.setBackground(new Color(240,240,240));// grigio
                        break;
                    case VALIDA:
                        pannello.setBackground(new Color(255,204,153));//azzurro
                        break;
                    case STAMPATA:
                        
                        pannello.setBackground(new Color(204, 204, 255));// arancio
                        jTBprodotto.setEnabled(false);
                        jTBOk.setEnabled(false);
                        break;
                }
                break;
        }
        ImageIcon iconaStatoPesata = new ImageIcon();
        float gap = quantitaFisica - quantitaRichiesta;
        
        if(quantitaFisica == 0)
        {
            jTBOk.setEnabled(false);
            iconaStatoPesata = new ImageIcon(
                new ImageIcon("src\\Icone\\cross.png")
                        .getImage()
                        .getScaledInstance(iconDimension, iconDimension, Image.SCALE_DEFAULT)
                );
        }
        else
        {
            if(getPesata().stato != StatoPesata.STAMPATA)jTBOk.setEnabled(true);
            if(gap == 0)
            {
                iconaStatoPesata = new ImageIcon(
                new ImageIcon("src\\Icone\\checked.png")
                        .getImage()
                        .getScaledInstance(iconDimension, iconDimension, Image.SCALE_DEFAULT)
                );
            }
            else
            {
                iconaStatoPesata = new ImageIcon(
                new ImageIcon("src\\Icone\\warning.png")
                        .getImage()
                        .getScaledInstance(iconDimension, iconDimension, Image.SCALE_DEFAULT)
                );
            }
        }
        jTBprodotto.setIcon(iconaStatoPesata);
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
