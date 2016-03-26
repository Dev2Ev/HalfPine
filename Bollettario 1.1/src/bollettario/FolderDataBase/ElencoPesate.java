/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoPesate extends ElencoIndicizzato implements Serializable
{
    ArrayList<PrototipoPesata> elenco;
    public ElencoPesate()
    {
        super();
        this.elenco = new ArrayList<PrototipoPesata>();
    }

    public void add(PrototipoPesata pesata)
    {
        if(pesata != null)
        {
            elenco.add(pesata);
        }
    }
   
    public int size()
    {
        return elenco.size();
    }
    public PrototipoPesata get(long id)
    {
        for(int i=0; i<size(); i++)
        {
            PrototipoPesata p = (PrototipoPesata)elenco.get(i);
            if(p.getId() == id)
            {
                return p;
            }
        }
        return null;
    }
    public PrototipoPesata get(int i)
    {
        return elenco.get(i);
    }
    public ArrayList<Long> listaIdPesate(long idCliente, GregorianCalendar giorno)
    {
        ArrayList<Long> listaIdPesate = new ArrayList<Long>();
        for(int i=0; i<size(); i++)
        {
            PrototipoPesata p = (PrototipoPesata)get(i);
            if(p.idCliente == idCliente && p.validaIl(giorno))
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
    public void remove(long idPesata)
    {
        elenco.remove(get(idPesata));
    }
    
     
}
