/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoProdotti extends ElencoIndicizzato implements Serializable
{
    public ElencoProdotti()
    {
        super(new ArrayList<Prodotto>());
    }
    public void test()
    {
        elenco.add(new Prodotto(getNewId(), "Pane", 0));
        elenco.add(new Prodotto(getNewId(), "Focaccia", 1));
        elenco.add(new Prodotto(getNewId(), "Grano Duro", 0));
        elenco.add(new Prodotto(getNewId(), "Ciabatte", 1));
        elenco.add(new Prodotto(getNewId(), "Pizza", 1));
        elenco.add(new Prodotto(getNewId(), "Kinoa Amaranto", 0));
        elenco.add(new Prodotto(getNewId(), "Brioches Marmellata", 1));
        elenco.add(new Prodotto(getNewId(), "Brioches Crema", 1));
        elenco.add(new Prodotto(getNewId(), "Brioches Cioccolata", 1));
        elenco.add(new Prodotto(getNewId(), "Brioches Vuote", 1));
        elenco.add(new Prodotto(getNewId(), "Focaccia Farcita", 1));
        elenco.add(new Prodotto(getNewId(), "Pizza Farcita", 1));
        elenco.add(new Prodotto(getNewId(), "Pane Expo", 1));
        elenco.add(new Prodotto(getNewId(), "Fondo Pizza", 0));
        elenco.add(new Prodotto(getNewId(), "Pizza Tonda", 1));
    }
    public Prodotto get(long id)
    {
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
    
    public String getNome(long id)
    {
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
    
    public long getIdUnitaDiMisura(long id)
    {
        for(int i=0; i<elenco.size(); i++)
        {
            Prodotto p = (Prodotto)elenco.get(i); 
            if(id == p.getId())
            {
                return p.idUnitaDiMisura; 
            }
        }
        return -1;
    }
}
