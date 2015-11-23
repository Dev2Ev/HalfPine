/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import java.io.Serializable;

/**
 *
 * @author DiegoCarlo
 */
public class DataBase implements Serializable{
    ElencoClienti elencoClienti;
    ElencoPrototipiOrdini elencoPrototipiOrdini;
    ElencoOrdiniElaborati elencoOrdiniElaborati;

    public DataBase() {
        elencoClienti = new ElencoClienti();
        elencoOrdiniElaborati = new ElencoOrdiniElaborati();
        elencoPrototipiOrdini = new ElencoPrototipiOrdini();
    }
    public void test()
    {
        elencoClienti.test();
        elencoPrototipiOrdini.test();
    }
}
