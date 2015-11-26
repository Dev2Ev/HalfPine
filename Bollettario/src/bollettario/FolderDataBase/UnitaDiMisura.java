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
public class UnitaDiMisura extends OggettoIndicizzato implements Serializable
{
    String sigla;
    String descrizione;

    public UnitaDiMisura(long id, String sigla, String descrizione)
    {
        super(id);
        this.sigla = sigla;
        this.descrizione = descrizione;
    }

    public boolean equals(UnitaDiMisura b)
    {
        if(sigla.equals(b.toString()))
        {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return sigla;
    }
    
    
}
