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
public class PrototipoProdotto implements Serializable
{
    String idProdotto;
    Quantita quantita;

    public PrototipoProdotto(String idProdotto, Quantita quantita) {
        this.idProdotto = idProdotto;
        this.quantita = quantita;
    }
}
