/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import java.util.ArrayList;

/**
 *
 * @author DiegoCarlo
 */
public class TestDati {
    
    static ArrayList<Cliente> creaClienti()
    {
        int maxClienti = 15;
        ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
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
            Cliente cliente = new Cliente
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
                fax
            );
            listaClienti.add(cliente);
        }
        return listaClienti;
    }
    
}
