/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import static bollettario.Bollettario.debug;
import bollettario.FolderDataBase.Calendario.PeriodoEFrequenza;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import sun.util.calendar.Gregorian;

/**
 *
 * @author DiegoCarlo
 */
public class PrototipoPesata extends OggettoIndicizzato implements Serializable
{
    public long idProdotto;
    public long idCliente;
    public float quantitaRichiesta;
    public float quantitaFisica;
    public StatoPesata stato;
    public GregorianCalendar dataDiCompletamento;

    public PrototipoPesata
            (
                    long id,
                    long idProdotto,
                    long idCliente,
                    float quantitaRichiesta
            )
    {
        super(id);
        if(debug)System.out.println("PrototipoPesata.PrototipoPesata()");
        this.idProdotto = idProdotto;
        this.idCliente = idCliente;
        this.quantitaRichiesta = quantitaRichiesta;
        this.stato = StatoPesata.NUOVA;
    }
    
    

    @Override
    public String toString()
    {
        if(debug)System.out.println("PrototipoPesata.toString()");
        String s = getId() +" "+ idCliente +" "+ idProdotto +" "+ quantitaRichiesta + " " + quantitaFisica +" "+ stato;
        return s;
    }
    public String stampa()
    {
        if(debug)System.out.println("PrototipoPesata.stampa()");
        DataBase d = bollettario.Bollettario.dataBase;
        Prodotto p = d.getProdotto(idProdotto);
        String s = "Ordine " + idCliente +"  "+ p.nome +"  "+ quantitaFisica + p.unitaDiMisura;
        return s;
    }
    
    public boolean validaIl(GregorianCalendar giorno)
    {
        if(debug)System.out.println("PrototipoPesata.validaIl()");
        boolean valida = false;
        return valida;
    }
}
