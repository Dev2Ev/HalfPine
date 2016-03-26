/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import bollettario.FolderDataBase.Calendario.PeriodoEFrequenza;
import bollettario.FolderDataBase.Calendario.RipetizioneSettimanale;
import java.util.ArrayList;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoPrototipiPesate {
    
    private long idCounter;
    ArrayList<PrototipoPesata> elenco;

    public ElencoPrototipiPesate()
    {
        this.elenco = new ArrayList<PrototipoPesata>();
        this.idCounter = 0;
    }
    private long getNewId()
    {
        long temp = idCounter;
        idCounter++;
        return temp;
    }
    public void test()
    {
        long idProdotto = 0;
        long idCliente = 0;
        float quantitaRichiesta = 10;
        boolean[] giorni = {true, false, true, false, false, true, false};
        
        PrototipoPesata pesata = new PrototipoPesata
                (
                        getNewId(),
                        idProdotto,
                        idCliente,
                        quantitaRichiesta
                );
        elenco.add(pesata);
    }
    
    
}
