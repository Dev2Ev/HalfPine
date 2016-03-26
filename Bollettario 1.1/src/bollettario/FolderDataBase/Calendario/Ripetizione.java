/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase.Calendario;

import bollettario.FolderDataBase.Calendario.RipetizioneSettimanale;
import bollettario.FolderDataBase.Calendario.UnitaDiFrequenza;
import java.util.GregorianCalendar;

/**
 *
 * @author DiegoCarlo
 */
public class Ripetizione
{
    RipetizioneEventoOccasionale occasionale;
    RipetizioneGiornaliera giornaliera;
    RipetizioneSettimanale settimanale;
    RipetizioneMensile mensile;
    RipetizioneAnnuale annuale;

    UnitaDiFrequenza unita;
    
    public Ripetizione(UnitaDiFrequenza unita, PeriodoEFrequenza ripetizione)
    {
        this.unita = unita;
        
        switch(this.unita)
        {
            case OCCASIONALE:
                occasionale = (RipetizioneEventoOccasionale)ripetizione;
                break;
            case GIORNALIERA:
                giornaliera = (RipetizioneGiornaliera)ripetizione;
                break;
            case SETTIMANALE:
                settimanale = (RipetizioneSettimanale)ripetizione;
                break;
            case MENSILE:
                mensile = (RipetizioneMensile)ripetizione;
                break;
            case ANNUALE:
                annuale = (RipetizioneAnnuale)ripetizione;
                break;
        }
    }
    
    public boolean giornoValido(GregorianCalendar giorno)
    {
        switch(unita)
        {
            case OCCASIONALE:
                return occasionale.giornoValido(giorno);
            case GIORNALIERA:
                return giornaliera.giornoValido(giorno);
            case SETTIMANALE:
                return settimanale.giornoValido(giorno);
            case MENSILE:
                return mensile.giornoValido(giorno);
            case ANNUALE:
                return annuale.giornoValido(giorno);
        }
    }
    
    
    
    
    
    
    
}
