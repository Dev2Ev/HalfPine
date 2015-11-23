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
class ElencoPrototipiOrdini
{
    ArrayList<PrototipoOrdine> elenco;

    public ElencoPrototipiOrdini()
    {
        elenco = new ArrayList<PrototipoOrdine>();
    }
    public void test()
    {
        int tot = 5+(int)(Math.random()*5);
        System.out.println(tot+"ordini");
        for(int i=0; i<tot; i++)
        {
            PrototipoOrdine p = new PrototipoOrdine();
            p.test();
            elenco.add(p);
        }
    }
}
