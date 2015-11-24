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
public class Prodotto implements Serializable
{
    String idProdotto;
    Quantita quantita;

    public Prodotto(String idProdotto, Quantita quantita) {
        this.idProdotto = idProdotto;
        this.quantita = quantita;
    }
}
