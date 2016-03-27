/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import static bollettario.Bollettario.debug;
import java.io.Serializable;
import java.util.ArrayList;
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
        if(debug)System.out.println("ElencoPesate.ElencoPesate()");
        this.elenco = new ArrayList<PrototipoPesata>();
    }

    public void add(PrototipoPesata pesata)
    {
        if(debug)System.out.println("ElencoPesate.add()");
        if(pesata != null)
        {
            elenco.add(pesata);
        }
    }
   
    public int size()
    {
        if(debug)System.out.println("ElencoPesate.size()");
        return elenco.size();
    }
    public PrototipoPesata get(long id)
    {
        if(debug)System.out.println("ElencoPesate.get()");
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
        if(debug)System.out.println("ElencoPesate.get()");
        return elenco.get(i);
    }
    public ArrayList<Long> listaIdPesate(long idCliente, GregorianCalendar giorno)
    {
        if(debug)System.out.println("ElencoPesate.listaIdPesate()");
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
        if(debug)System.out.println("ElencoPesate.toString()");
        String a = "toString() ElencoPesate";
        for(int i=0; i<elenco.size(); i++)
        {
            a += "\n  " + elenco.get(i).toString();
        }
        return a;
    }
    public boolean isEmpty()
    {
        if(debug)System.out.println("ElencoPesate.isEmpty()");
        return elenco.isEmpty();
    }
    public String stampa()
    {
        if(debug)System.out.println("ElencoPesate.stampa()");
        String a = "stampa() ElencoPesate";
        for(int i=0; i<elenco.size(); i++)
        {
            a += "\n  " + elenco.get(i).stampa();
        }
        return a;
    }
    public void remove(long idPesata)
    {
        if(debug)System.out.println("ElencoPesate.remove()");
        elenco.remove(get(idPesata));
    }
}
