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
public class OggettoIndicizzato implements Serializable
{
    private long id;

    public OggettoIndicizzato(long id) {
        if(debug)System.out.println("OggettoIndicizzato.OggettoIndicizzato()");
        this.id = id;
    }

    public long getId() {
        if(debug)System.out.println("OggettoIndicizzato.getId()");
        return id;
    }
}
