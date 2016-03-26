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
public class RipetizioneSettimanale extends PeriodoEFrequenza
{
    boolean[] giorni;
    public RipetizioneSettimanale(PeriodoDaA periodo, int frequenza, boolean[] giorni, GregorianCalendar dataDiRiferimento)
    {
        super(periodo, frequenza, dataDiRiferimento);
        this.giorni = giorni;
    }
    public RipetizioneSettimanale(int frequenza, boolean[] giorni, GregorianCalendar dataDiRiferimento)
    {
        super(frequenza, dataDiRiferimento);
        this.giorni = giorni;
    }
}
