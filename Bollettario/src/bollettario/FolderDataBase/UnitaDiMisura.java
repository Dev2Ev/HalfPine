/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

/**
 *
 * @author DiegoCarlo
 */
public enum UnitaDiMisura
{
    KILOGRAMMO ("Kg"),
    QUANTITA ("n°")
    ;

    private final String text;
    
    private UnitaDiMisura(final String text) {
        this.text = text;
    }
    
    @Override
    public String toString() {
        return text;
    }
}
