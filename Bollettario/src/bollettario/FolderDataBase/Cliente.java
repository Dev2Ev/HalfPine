/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author DiegoCarlo
 */
public class Cliente extends OggettoIndicizzato implements Serializable
{    
    public String ragioneSociale;
    public String codice;
    public String partitaIva;
    public String codiceFiscale;
    public String indirizzo;
    public String cap;
    public String citta;
    public String provincia;
    public String stato;
    public String telefono;
    public String fax;

    public Cliente(long id, String ragioneSociale, String codice, String partitaIva, String codiceFiscale, String indirizzo, String cap, String citta, String provincia, String stato, String telefono, String fax) 
    {
        super(id);
        this.ragioneSociale = ragioneSociale;
        this.codice = codice;
        this.partitaIva = partitaIva;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
        this.stato = stato;
        this.telefono = telefono;
        this.fax = fax;
    }
}
class ClienteRagioneSocialeComparator implements Comparator<Cliente>
{
    public int compare(Cliente Cliente1, Cliente Cliente2)
    {
        return ordineAlfabetico(Cliente1.ragioneSociale, Cliente2.ragioneSociale);
    }

    private int ordineAlfabetico(String uno, String due) {
        int max = 0;
        if(uno.length() > due.length())
        {
            max = due.length();
        }
        else
        {
            max = uno.length();
        }
        for(int i=0; i<max; i++)
        {
            if(uno.charAt(i) < due.charAt(i))
            {
                return -1;
            }
            if(uno.charAt(i) > due.charAt(i))
            {
                return +1;
            }
        }
        if(uno.length() > due.length())
        {
            return +1;
        }
        else
        {
            return -1;
        }
    }
}
