/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author DiegoCarlo
 */
class ElencoOrdini
{
    
    ArrayList<Ordine> elenco;
    long id;
    public ElencoOrdini()
    {
        elenco = new ArrayList<Ordine>();
    }
    public void test()
    {
        int tot = 28;
        System.out.println(tot+"ordini");
        int max = Bollettario.dataBase.elencoClienti.size();
        
        for(int i=0; i<tot; i++)
        {
            int indice = (int)(Math.random()*max);
            String codice = Bollettario.dataBase.elencoClienti.get(indice).codice;
            Calendar g = new GregorianCalendar().getInstance();
            int giorno = (int)((i+1)%7);
            switch(giorno)
            {
                case 0:
                    g.add(GregorianCalendar.DAY_OF_MONTH, -3);
                    break;
                case 1:
                    g.add(GregorianCalendar.DAY_OF_MONTH, -2);
                    break;
                case 2:
                    g.add(GregorianCalendar.DAY_OF_MONTH, -1);
                    break;
                case 3:
                    g.add(GregorianCalendar.DAY_OF_MONTH, 0);
                    break;
                case 4:
                    g.add(GregorianCalendar.DAY_OF_MONTH, 1);
                    break;
                case 5:
                    g.add(GregorianCalendar.DAY_OF_MONTH, 2);
                    break;
                case 6:
                    g.add(GregorianCalendar.DAY_OF_MONTH, 3);
                    break;
            }
            Ordine p = new Ordine(getNewId(), codice, g);
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
    public void add(Ordine ordine)
    {
        elenco.add(ordine);
    }
    public Ordine get(int i)
    {
        if(i >= 0 && i < elenco.size())
        {
            return elenco.get(i);
        }
        return null;
    }
    public Ordine get(long indice)
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
    public ElencoOrdini getOrdiniGiorno(Calendar data)
    {
        ElencoOrdini el = new ElencoOrdini();
        for(int i=0; i<elenco.size(); i++)
        {
            Calendar d = elenco.get(i).dataDiConsegna;
            if(
                    d.get(GregorianCalendar.YEAR) == data.get(GregorianCalendar.YEAR) &&
                    d.get(GregorianCalendar.MONTH) == data.get(GregorianCalendar.MONTH) &&
                    d.get(GregorianCalendar.DAY_OF_MONTH) == data.get(GregorianCalendar.DAY_OF_MONTH)
                    )
            {
                el.add(elenco.get(i));
            }
        }
        return el;
    }
    public void ordinaData()
    {
        Collections.sort(elenco, new OrdineDataComparator());
    }
}
