/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author DiegoCarlo
 */
public class Ordine extends OggettoIndicizzato implements Serializable
{
    long idCliente;
    Calendar dataRichiesta;
    Calendar dataDiCompletamento;
    StatoContabileOrdine statoContabile;
    StatoFisicoOrdine statoFisico;
    
    
    public Ordine(long id, long idCliente, Calendar dataDiConsegna)
    {
        super(id);
        this.idCliente = idCliente;
        this.dataRichiesta = dataDiConsegna;
        
        this.statoContabile = StatoContabileOrdine.PENDENTE;
        this.statoFisico = StatoFisicoOrdine.DA_FARE;
        
    }
}
class OrdineDataComparator implements Comparator<Ordine>
{
    public int compare(Ordine ordine1, Ordine ordine2) {
        if(ordine1.dataRichiesta.getTimeInMillis() - ordine2.dataRichiesta.getTimeInMillis()>=0)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}