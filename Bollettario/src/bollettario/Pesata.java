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
public class Pesata {
    
    long data;
    int idProdotto;
    Quantita quantita;
    boolean valida;
    Ora oraDiConsegna;

    public Pesata(long data, int idProdotto, Quantita quantita) {
        this.data = data;
        this.idProdotto = idProdotto;
        this.quantita = quantita;
    }
    
    
}
