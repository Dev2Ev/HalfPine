/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoPesate extends ElencoIndicizzato implements Serializable
{
    ArrayList<Pesata> elenco;
    public ElencoPesate()
    {
        super();
        this.elenco = new ArrayList<Pesata>();
    }

    public void add(Pesata pesata)
    {
        if(pesata != null)
        {
            elenco.add(pesata);
        }
    }
    public void add(long idProdotto, long idOrdine, float quantita)
    {
        StatoPesata stato = StatoPesata.NUOVA;
        elenco.add
        (
                new Pesata
                (
                        getNewId(),
                        idProdotto, 
                        idOrdine, 
                        quantita, 
                        stato
                )
        );
    }
    public int size()
    {
        return elenco.size();
    }
    public Pesata get(long id)
    {
        for(int i=0; i<size(); i++)
        {
            Pesata p = (Pesata)elenco.get(i);
            if(p.getId() == id)
            {
                return p;
            }
        }
        return null;
    }
    public Pesata get(int i)
    {
        return elenco.get(i);
    }
    public ArrayList<Long> listaIdPesate(long idOrdine)
    {
        ArrayList<Long> listaIdPesate = new ArrayList<Long>();
        for(int i=0; i<size(); i++)
        {
            Pesata p = (Pesata)get(i);
            if(p.idOrdine == idOrdine)
            {
                listaIdPesate.add(p.getId());
            }
        }
        return listaIdPesate;
    }
    @Override
    public String toString()
    {
        String a = "toString() ElencoPesate";
        for(int i=0; i<elenco.size(); i++)
        {
            a += "\n  " + elenco.get(i).toString();
        }
        return a;
    }
    public boolean isEmpty()
    {
        return elenco.isEmpty();
    }
    public String stampa()
    {
        String a = "stampa() ElencoPesate";
        for(int i=0; i<elenco.size(); i++)
        {
            a += "\n  " + elenco.get(i).stampa();
        }
        return a;
    }
    void test()
    {
        int totaleOrdini = bollettario.Bollettario.dataBase.elencoOrdini.size();
        for(int j=0; j<totaleOrdini; j++)
        {
            int totPesateOrdine = 2+(int)(Math.random()*8);
            int totProdotti = bollettario.Bollettario.dataBase.elencoProdotti.size();
            ArrayList<Integer> indiciProdotti = bollettario.Utilita.indiciUnivoci(totPesateOrdine, 0, totProdotti);
            
            for(int i=0; i<totPesateOrdine; i++)
            {
                Prodotto p = bollettario.Bollettario.dataBase.getProdotto(indiciProdotti.get(i));
                float quantita = (float)Math.random(); // creao quantità random
                if(p.unitaDiMisura == UnitaDiMisura.KILOGRAMMO)
                {
                    quantita = ((int) quantita * 10000)/1000;
                }
                if(p.unitaDiMisura == UnitaDiMisura.QUANTITA)
                {
                    quantita = 1+(int)(quantita * 7.25f);
                }          
                add
                (
                        indiciProdotti.get(i),//prodotto
                        bollettario.Bollettario.dataBase.getOrdine(j).getId(),//ordine
                        quantita
                );
            }
        }
    }

    public void remove(long idPesata)
    {
        elenco.remove(get(idPesata));
    }
    
     
}
