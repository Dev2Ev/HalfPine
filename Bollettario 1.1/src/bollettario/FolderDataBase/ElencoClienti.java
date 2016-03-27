/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import static bollettario.Bollettario.debug;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoClienti extends ElencoIndicizzato implements Serializable
{
    ArrayList<Cliente> elenco;
    long idCounter;
    
    public ElencoClienti()
    {
        super();
        if(debug)System.out.println("ElencoClienti.ElencoClienti()");
        this.elenco = new ArrayList<Cliente>();
    }
    void setArrayList(ArrayList<Cliente> elenco)
    {
        if(debug)System.out.println("ElencoClienti.setArrayList()");
        this.elenco = elenco;
        ordina();
    }

    private void ordina()
    {
        if(debug)System.out.println("ElencoClienti.ordina()");
        if(elenco.size() > 1)
        {
            Collections.sort(elenco, new ClienteRagioneSocialeComparator());
        }
    }
    public void add(String ragioneSociale, String codice, String partitaIva, String codiceFiscale, String indirizzo, String cap, String citta, String provincia, String stato, String telefono, String fax)
    {
        if(debug)System.out.println("ElencoClienti.add()");
        Cliente c = new Cliente
        (
                getNewId(),
                ragioneSociale,
                codice,
                partitaIva,
                codiceFiscale,
                indirizzo,
                cap,
                citta,
                provincia,
                stato,
                telefono,
                fax
        );
        elenco.add(c);
        ordina();
    }
    public int size()
    {
        if(debug)System.out.println("ElencoClienti.size()");
        return elenco.size();
    }
    public Cliente get(long id)
    {
        if(debug)System.out.println("ElencoClienti.get()");
        for(int i=0; i<size(); i++)
        {
            Cliente c = (Cliente)elenco.get(i);
            if(c.getId() == id)
            {
                return c;
            }
        }
        return null;
    }
    public Cliente get(int i)
    {
        if(debug)System.out.println("ElencoClienti.get()");
        return elenco.get(i);

    }
    @Override
    public String toString()
    {
        if(debug)System.out.println("ElencoClienti.toString()");
        String a = "ElencoClienti";
        for(int i=0; i<elenco.size(); i++)
        {
            a += "\n  " + elenco.get(i).toString();
        }
        return a;

    }
    public void test()
    {
        if(debug)System.out.println("ElencoClienti.test()");
        int maxClienti = 15;
        elenco = new ArrayList<Cliente>();
        for(int i=0; i<maxClienti; i++)
        {
            String ragioneSociale = "ragioneSociale "+i;
            String codice = "codice "+i;
            String partitaIva = "partitaIva "+i;
            String codiceFiscale = "codiceFiscale "+i;
            String indirizzo = "indirizzo "+i;
            String cap = "cap "+1;
            String citta = "citta "+1;
            String provincia = "provincia "+1;
            String stato = "stato "+1;
            String telefono = "telefono "+1;
            String fax = "fax "+1;
            add
            (
                    ragioneSociale,
                    codice,
                    partitaIva,
                    codiceFiscale,
                    indirizzo,
                    cap,
                    citta,
                    provincia,
                    stato,
                    telefono,
                    fax);
        }
    }
}
