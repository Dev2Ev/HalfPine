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
public class RipetizioneMensile extends PeriodoEFrequenza
{
    TipoFrequenzaMensile tfm;
    public RipetizioneMensile(PeriodoDaA periodo, int frequenza, GregorianCalendar dataDiRiferimento)
    {
        super(periodo, frequenza, dataDiRiferimento);
    }
    public RipetizioneMensile(int frequenza, GregorianCalendar dataDiRiferimento) {
        super(frequenza, dataDiRiferimento);
    }
}
