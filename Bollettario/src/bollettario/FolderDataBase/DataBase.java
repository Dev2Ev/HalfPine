/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;

/**
 *
 * @author DiegoCarlo
 */
public class DataBase implements Serializable{
    ElencoClienti elencoClienti;
    ElencoOrdini elencoOrdini;
    ElencoProdotti elencoProdotti;
    ElencoUnitaDiMisura elencoUnitaDiMisura;
    ElencoPesate elencoPesate;
    
    public DataBase() {
        elencoUnitaDiMisura = new ElencoUnitaDiMisura();
        elencoClienti = new ElencoClienti();
        elencoProdotti = new ElencoProdotti();
        elencoOrdini = new ElencoOrdini();
        elencoPesate = new ElencoPesate();
    }
    public void test()
    {
        elencoClienti.test();
        
        elencoUnitaDiMisura.test();
        
        elencoProdotti.test();
        
        elencoOrdini.test();
        
        elencoPesate.test();
    }
}
