/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase.Calendario;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * da  a
 * sempre
 * occasionale
 * giornaliera
 * settimanale
 * mensile
 * annuale
 * ogni tot settimane  il lunedi 
 * giorni della settimana
 * 
 * @author DiegoCarlo
 */
public abstract class PeriodoEFrequenza
{
    PeriodoDaA periodo;
    
    int frequenza;
    
    GregorianCalendar dataDiRiferimento;
    
    public PeriodoEFrequenza(PeriodoDaA periodo, int frequenza, GregorianCalendar dataDiRiferimento)
    {
        this.periodo = periodo;
        this.frequenza = frequenza;
    }
    public PeriodoEFrequenza(int frequenza, GregorianCalendar dataDiRiferimento)
    {
        this.frequenza = frequenza;
        this.periodo = null;
    }
}
