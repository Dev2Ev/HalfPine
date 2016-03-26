/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase.Calendario;

import java.util.GregorianCalendar;

/**
 *
 * @author DiegoCarlo
 */
public class RipetizioneAnnuale extends PeriodoEFrequenza
{
    public RipetizioneAnnuale(PeriodoDaA periodo, int frequenza, GregorianCalendar dataDiRiferimento)
    {
        super(periodo, frequenza, dataDiRiferimento);
    }
    public RipetizioneAnnuale(int frequenza, GregorianCalendar dataDiRiferimento)
    {
        super(frequenza, dataDiRiferimento);
    }
    public boolean giornoValido(GregorianCalendar giorno)
    {
        if(periodo == null)
        {
            return verifica(giorno);
        }
        else
        {
            if
                    (
                            periodo.da.compareTo(giorno) > 0 &&
                            periodo.a.compareTo(giorno) < 0
                    )
            {
                return verifica(giorno);
            }
        }
        return false;
    }
    
    private boolean verifica(GregorianCalendar giorno)
    {
        if
                    (
                            dataDiRiferimento.get(GregorianCalendar.MONTH) ==
                            giorno.get(GregorianCalendar.MONTH)
                    )
        {
            if
                    (
                            dataDiRiferimento.get(GregorianCalendar.DAY_OF_MONTH) ==
                            giorno.get(GregorianCalendar.DAY_OF_MONTH)
                    )
            {
                return true;
            }
        }
        return false;
    }
}
