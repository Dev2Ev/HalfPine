/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoClienti extends ElencoIndicizzato implements Serializable
{
    public ElencoClienti()
    {
        super(new ArrayList<Cliente>());
    }

    
    void setArrayList(ArrayList<Cliente> elenco)
    {
        this.elenco = elenco;
        ordina();
    }

    private void ordina()
    {
        Collections.sort(elenco, new ClienteRagioneSocialeComparator());
    }
    public void add(String ragioneSociale, String codice, String partitaIva, String codiceFiscale, String indirizzo, String cap, String citta, String provincia, String stato, String telefono, String fax)
    {
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
        return elenco.size();
    }
    public Cliente get(long id)
    {
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
    public void test()
    {
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
