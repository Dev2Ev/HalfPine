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
public class RipetizioneEventoOccasionale extends PeriodoEFrequenza
{

    public RipetizioneEventoOccasionale(GregorianCalendar dataDiRiferimento)
    {
        super(1, dataDiRiferimento);
    }
    public boolean giornoValido(GregorianCalendar giorno)
    {
        if
                (
                        dataDiRiferimento.get(GregorianCalendar.YEAR) ==
                        giorno.get(GregorianCalendar.YEAR)
                        &&
                        dataDiRiferimento.get(GregorianCalendar.MONTH) ==
                        giorno.get(GregorianCalendar.MONTH)
                        &&
                        dataDiRiferimento.get(GregorianCalendar.DAY_OF_MONTH) ==
                        giorno.get(GregorianCalendar.DAY_OF_MONTH)
                )
        {
            return true;
        }
        return false;
    }
}
