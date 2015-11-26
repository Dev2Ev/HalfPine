/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoIndicizzato implements Serializable
{
    protected long idCounter;
    protected ArrayList elenco;

    public ElencoIndicizzato(ArrayList elenco)
    {
        this.idCounter = 0;
        this.elenco = elenco;
    }
    
    protected long getNewId()
    {
        long temp = idCounter;
        idCounter++;
        return temp;
    }
    
    public int size()
    {
        return elenco.size();
    }
    
    public Object get(int i)
    {
        if(i >= 0 && i < size())
        {
            return elenco.get(i);
        }
        return null;
    }
}
