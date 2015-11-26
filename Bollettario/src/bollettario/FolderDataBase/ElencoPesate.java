/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author DiegoCarlo
 */
public class ElencoPesate extends ElencoIndicizzato implements Serializable
{

    public ElencoPesate()
    {
        super(new ArrayList<Pesata>());
    }

    public void add(Calendar dataRichiesta, long idProdotto, long idOrdine, float quantita, StatoPesata stato)
    {
        Pesata p = new Pesata
            (
                    getNewId(), 
                    dataRichiesta,
                    idProdotto, 
                    idOrdine, 
                    quantita, 
                    stato);
    }
    void test()
    {
        int tot = 2+(int)(Math.random()*8);
        System.out.println(tot+"pesata");
        for(int i=0; i<tot; i++)
        {
            long idUnitaDiMisura = 0;
            double random = Math.random();
            double quantita = 1+(int)(random*20);
            if(0.5 > Math.random())
            {
                idUnitaDiMisura = 1;
                quantita = ((int)(random*10000))/1000;
            }
            
                    
            add(null); 
        }
    }
    
     
}
