/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author DiegoCarlo
 */
class ElencoPrototipiOrdini
{
    
    ArrayList<PrototipoOrdine> elenco;
    long id;
    public ElencoPrototipiOrdini()
    {
        elenco = new ArrayList<PrototipoOrdine>();
    }
    public void test()
    {
        int tot = 5+(int)(Math.random()*5);
        System.out.println(tot+"ordini");
        int max = Bollettario.dataBase.elencoClienti.size();
        int indice = (int)(Math.random()*max);
        String codice = Bollettario.dataBase.elencoClienti.get(indice).codice;
        for(int i=0; i<tot; i++)
        {
            PrototipoOrdine p = new PrototipoOrdine(getNewId(), codice, Calendar.MONDAY);
            p.test();
            elenco.add(p);
        }
    }
    public int size()
    {
        return elenco.size();
    }
    public long getNewId()
    {
        long temp = id;
        id++;
        return temp; 
    }
    public void add(PrototipoOrdine ordine)
    {
        elenco.add(ordine);
    }
    public PrototipoOrdine get(int i)
    {
        if(i >= 0 && i < elenco.size())
        {
            return elenco.get(i);
        }
        return null;
    }
    public PrototipoOrdine get(long indice)
    {
        for(int i=0; i<elenco.size(); i++)
        {    
            if(elenco.get(i).id == indice)
            {
                return elenco.get(i);
            }
        }
        return null;
    }
}
