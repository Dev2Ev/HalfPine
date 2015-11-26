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
public class ElencoUnitaDiMisura extends ElencoIndicizzato implements Serializable
{
    public ElencoUnitaDiMisura()
    {
        super(new ArrayList<UnitaDiMisura>());
        idCounter = 0;
    }
    
    public void add(String sigla, String descrizione)
    {
        UnitaDiMisura unitaDiMisura = new UnitaDiMisura(getNewId(), sigla, descrizione);
        elenco.add(unitaDiMisura);
    }
    public void test()
    {
        add("Kg", "Kilogrammi");
        add("n°", "Quantità");
    }
    public UnitaDiMisura get(long id)
    {
        for(int i=0; i<elenco.size(); i++)
        {
            UnitaDiMisura u = (UnitaDiMisura)elenco.get(i);
            if(u.getId() == id)
            {
                return u;
            }
        }
        return null;
    }
    
    public String getSigla(long id)
    {
        for(int i=0; i<elenco.size(); i++)
        {
            UnitaDiMisura u = (UnitaDiMisura)elenco.get(i);
            if(u.getId() == id)
            {
                return u.sigla;
            }
        }
        return null;
    }
    public String getDescrizione(long id)
    {
        for(int i=0; i<elenco.size(); i++)
        {
            UnitaDiMisura u = (UnitaDiMisura)elenco.get(i);
            if(u.getId() == id)
            {
                return u.descrizione;
            }
        }
        return null;
    }
}
