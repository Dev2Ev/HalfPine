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
public abstract class ElencoIndicizzato
{
    long idCounter;

    public ElencoIndicizzato()
    {
        this.idCounter = 0;
    }
    public long getNewId()
    {
        long temp = idCounter;
        idCounter++;
        return temp;
    }
    
}
