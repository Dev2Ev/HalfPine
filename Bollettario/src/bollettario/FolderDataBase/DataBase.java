/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;

/**
 *
 * @author DiegoCarlo
 */
public class DataBase implements Serializable{
    public ElencoClienti elencoClienti;
    public ElencoOrdini elencoOrdini;
    public ElencoProdotti elencoProdotti;
    public ElencoPesate elencoPesate;
    
    public DataBase() {
        elencoClienti = new ElencoClienti();
        elencoProdotti = new ElencoProdotti();
        elencoOrdini = new ElencoOrdini();
        elencoPesate = new ElencoPesate();
    }
    public void test()
    {
        elencoClienti.test();
        
        elencoProdotti.test();
        
        elencoOrdini.test();
        
        elencoPesate.test();
    }
    public Cliente getCliente(long id)
    {
        return elencoClienti.get(id);
    }
    public Ordine getOrdine(long id)
    {
        return elencoOrdini.get(id);
    }
    public Prodotto getProdotto(long id)
    {
        return elencoProdotti.get(id);
    }
    public Pesata getPesata(long id)
    {
        return elencoPesate.get(id);
    }
    
    public Cliente getCliente(int i)
    {
        return elencoClienti.get(i);
    }
    public Ordine getOrdine(int i)
    {
        return elencoOrdini.get(i);
    }
    public Prodotto getProdotto(int i)
    {
        return elencoProdotti.get(i);
    }
    public Pesata getPesata(int i)
    {
        return elencoPesate.get(i);
    }
}
