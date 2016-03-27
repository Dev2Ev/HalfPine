/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import static bollettario.Bollettario.debug;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoProdotti extends ElencoIndicizzato implements Serializable
{
    ArrayList<Prodotto> elenco;
    
    public ElencoProdotti()
    {
        super();
        if(debug)System.out.println("ElencoProdotti.ElencoProdotti()");
        this.elenco = new ArrayList<Prodotto>();
    }
    public int size()
    {
        if(debug)System.out.println("ElencoProdotti.size()");
        return elenco.size();
    }

    @Override
    public String toString()
    {
        if(debug)System.out.println("ElencoProdotti.toString()");
        String a = "ElencoProdotti";
        for(int i=0; i<elenco.size(); i++)
        {
            a += "\n  " + elenco.get(i).toString();
        }
        return a;
    }
    
    public void test()
    {
        if(debug)System.out.println("ElencoProdotti.test()");
        elenco.add(new Prodotto(getNewId(), "Pane", UnitaDiMisura.KILOGRAMMO));
        elenco.add(new Prodotto(getNewId(), "Focaccia", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Grano Duro", UnitaDiMisura.KILOGRAMMO));
        elenco.add(new Prodotto(getNewId(), "Ciabatte", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Pizza", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Kinoa Amaranto", UnitaDiMisura.KILOGRAMMO));
        elenco.add(new Prodotto(getNewId(), "Brioches Marmellata", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Brioches Crema", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Brioches Cioccolata", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Brioches Vuote", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Focaccia Farcita", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Pizza Farcita", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Pane Expo", UnitaDiMisura.KILOGRAMMO));
        elenco.add(new Prodotto(getNewId(), "Fondo Pizza", UnitaDiMisura.QUANTITA));
        elenco.add(new Prodotto(getNewId(), "Pizza Tonda", UnitaDiMisura.QUANTITA));
    }
    public Prodotto get(long id)
    {
        if(debug)System.out.println("ElencoProdotti.get()");
        for(int i=0; i<elenco.size(); i++)
        {
            Prodotto p = (Prodotto)elenco.get(i); 
            if(id == p.getId())
            {
                return p; 
            }
        }
        return null;
    }
    
    public Prodotto get(int i)
    {
        if(debug)System.out.println("ElencoProdotti.get()");
        return elenco.get(i);
    }
    public String getNome(long id)
    {
        if(debug)System.out.println("ElencoProdotti.getNome()");
        for(int i=0; i<elenco.size(); i++)
        {
            Prodotto p = (Prodotto)elenco.get(i); 
            if(id == p.getId())
            {
                return p.nome; 
            }
        }
        return "";
    }
    
    public UnitaDiMisura getIdUnitaDiMisura(long id)
    {
        if(debug)System.out.println("ElencoProdotti.getIdUnitaDiMisura()");
        for(int i=0; i<elenco.size(); i++)
        {
            Prodotto p = (Prodotto)elenco.get(i); 
            if(id == p.getId())
            {
                return p.unitaDiMisura; 
            }
        }
        return null;
    }
}
