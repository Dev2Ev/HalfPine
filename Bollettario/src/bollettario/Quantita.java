/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import java.io.Serializable;

/**
 *
 * @author DiegoCarlo
 */
public class Quantita implements Serializable{
    
    float peso;
    UnitaDiMisura unita;

    public Quantita(float peso, UnitaDiMisura unita) {
        this.peso = peso;
        this.unita = unita;
    }
    public Quantita(UnitaDiMisura unita)
    {
        this.peso = 0;
        this.unita = unita;
    }

    @Override
    public String toString() {
        if(unita == UnitaDiMisura.NUMERO)
        {
            return (int)(peso) + " " + "n°";
        }
        else
        {
            return ((float)((int)(peso *5* 100))/(float)100) + " " + "Kg";
        }
    }
    
}
