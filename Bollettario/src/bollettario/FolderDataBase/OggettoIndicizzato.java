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
public class OggettoIndicizzato implements Serializable
{
    private long id;

    public OggettoIndicizzato(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
