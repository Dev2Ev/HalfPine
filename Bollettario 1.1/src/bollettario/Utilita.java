/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import static bollettario.Bollettario.debug;
import java.util.ArrayList;

/**
 *
 * @author DiegoCarlo
 */
public class Utilita {
    
    public static ArrayList<Integer> indiciUnivoci(int quantita, int min, int max)
    {
        if(debug)System.out.println("Utilita.indiciUnivoci()");
        ArrayList<Integer> numeri = new ArrayList<Integer>();
        while(numeri.size() <= quantita && numeri.size() < max)
        {
            int rnd = getRandom(min, max);
            boolean nuovo = true;
            for(int i=0; i<numeri.size(); i++)
            {
                if(numeri.get(i) == rnd)
                {
                    nuovo = false;
                    break;
                }
            }
            if(nuovo)
            {
                numeri.add(rnd);
            }
        }
        
        return numeri;
    }
    
    public static int getRandom(int min, int max)
    {
        if(debug)System.out.println("Utilita.getRandom()");
        int i = (int)(min + Math.random() * max);
        return i;
    }
}