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
    public long idCliente;
    public Calendar dataRichiesta;
    public Calendar dataDiCompletamento;
    public StatoContabileOrdine statoContabile;
    public StatoFisicoOrdine statoFisico;

    public Ordine(long id,long idCliente, Calendar dataRichiesta, StatoContabileOrdine statoContabile, StatoFisicoOrdine statoFisico) 
    {
        super(id);
        this.idCliente = idCliente;
        this.dataRichiesta = dataRichiesta;
        this.statoContabile = statoContabile;
        this.statoFisico = statoFisico;
    }
    
    
    
}
class OrdineDataComparator implements Comparator<Ordine>
{
    public int compare(Ordine ordine1, Ordine ordine2)
    {
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