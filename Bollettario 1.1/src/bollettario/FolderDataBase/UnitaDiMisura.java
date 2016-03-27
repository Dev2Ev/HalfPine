/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import static bollettario.Bollettario.debug;
import java.io.Serializable;

/**
 *
 * @author DiegoCarlo
 */
public enum UnitaDiMisura implements Serializable
{
    KILOGRAMMO ("Kg"),
    QUANTITA ("n°")
    ;

    private final String text;
    
    private UnitaDiMisura(final String text) {
        if(debug)System.out.println("UnitaDiMisura.UnitaDiMisura()");
        this.text = text;
    }
    
    @Override
    public String toString() {
        if(debug)System.out.println("UnitaDiMisura.toString()");
        return text;
    }
}
