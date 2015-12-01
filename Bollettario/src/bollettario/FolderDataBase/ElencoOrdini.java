/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import bollettario.Bollettario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoOrdini extends ElencoIndicizzato implements Serializable
{
    public static int ORDINA_DATA = 1;
    private ArrayList<Ordine> elenco;
    
    public ElencoOrdini()
    {
        super();
        this.elenco = new ArrayList<Ordine>();
    }
    @Override
    public String toString()
    {
        String a = "ElencoOrdini";
        for(int i=0; i<elenco.size(); i++)
        {
            a += "\n  " + elenco.get(i).toString();
        }
        return a;
    }
    public void test()
    {
        int tot = 28;
        //System.out.println(tot+"ordini");
        int max = Bollettario.dataBase.elencoClienti.size();
        
        for(int i=0; i<tot; i++)
        {
            int indice = (int)(Math.random()*max);
            long idCliente = Bollettario.dataBase.getCliente(indice).getId();
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
            add(idCliente, g);
        }
    }
    public void add(long idCliente, Calendar dataRichiesta)
    {
        StatoContabileOrdine statoContabile = StatoContabileOrdine.PENDENTE;
        StatoFisicoOrdine statoFisico = StatoFisicoOrdine.DA_FARE;
        Ordine o = new Ordine
            (
                    getNewId(),
                    idCliente,
                    dataRichiesta,
                    statoContabile,
                    statoFisico
            );
        elenco.add(o);
        ordinaData();
    }
    public int size()
    {
        return elenco.size();
    }
    public Ordine get(long id)
    {
        for(int i=0; i<size(); i++)
        {
            Ordine o = (Ordine)elenco.get(i);
            if(o.getId() == id)
            {
                return o;
            }
        }
        return null;
    }
    public Ordine get(int i)
    {
        return elenco.get(i);
    }
    public ArrayList<Long> getOrdiniGiorno(Calendar data)
    {
        ArrayList<Long> el = new ArrayList<Long>();
        for(int i=0; i<elenco.size(); i++)
        {
            Calendar d = ((Ordine)elenco.get(i)).dataRichiesta;
            if(
                    d.get(GregorianCalendar.YEAR) == data.get(GregorianCalendar.YEAR) &&
                    d.get(GregorianCalendar.MONTH) == data.get(GregorianCalendar.MONTH) &&
                    d.get(GregorianCalendar.DAY_OF_MONTH) == data.get(GregorianCalendar.DAY_OF_MONTH)
                    )
            {
                el.add(((Ordine)elenco.get(i)).getId());
            }
        }
        return el;
    }
    public ArrayList<Long> ordina(int discriminante, ArrayList<Long> selezione)
    {
        ElencoOrdini a;
        switch(discriminante)
        {
            case 1:
                a = getElenco(selezione);
                a.ordinaData();
                return a.getIndici();
            default:
            {
                a = getElenco(selezione);
                a.ordinaData();
                return a.getIndici();
            }
        }
    }
    public ArrayList<Long> getIndici()
    {
        ArrayList<Long> a = new ArrayList<Long>();
        for(int i=0; i<size(); i++)
        {
            a.add(((Ordine)get(i)).getId());
        }
        return a;
    }
    private ElencoOrdini getElenco(ArrayList<Long> indici)
    {
        ElencoOrdini e = new ElencoOrdini();
        for(int i=0; i<indici.size(); i++)
        {
            e.add(get(indici.get(i)));
        }
        return e;
    }
    private void add(Ordine a)
    {
        elenco.add(a);
    }
    public void ordinaData()
    {
        Collections.sort(elenco, new OrdineDataComparator());
    }
}
