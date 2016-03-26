/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import java.util.ArrayList;

/**
 *
 * @author DiegoCarlo
 */
public class Utilita {
    
    public static ArrayList<Integer> indiciUnivoci(int quantita, int min, int max)
    {
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
        int i = (int)(min + Math.random() * max);
        return i;
    }
}