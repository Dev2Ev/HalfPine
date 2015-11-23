/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

/**
 *
 * @author DiegoCarlo
 */
public class Ora {
    int ora;
    int minuti;

    public Ora(int ora, int minuti) {
        if(ora >= 0 && ora <= 24)
        {
            this.ora = ora;
        }
        if(minuti >= 0 && minuti <= 60)
        this.minuti = minuti;
    }

    @Override
    public String toString() {
        String o = "";
        String m = "";
        if(ora <= 9)
        {
            o += "0";
        }
        if(minuti <= 9)
        {
            m += "0";
        }
        
        return o+ora + ":" + m+minuti;
    }
}
