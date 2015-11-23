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
public class Ordine {
    ArrayList<Pesata> listaPesate;

    public Ordine() {
        listaPesate = new ArrayList<Pesata>();
    }
    public int size()
    {
        return listaPesate.size();
    }

    
}
