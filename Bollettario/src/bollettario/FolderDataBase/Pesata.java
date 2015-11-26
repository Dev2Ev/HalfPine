/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import java.io.Serializable;

/**
 *
 * @author DiegoCarlo
 */
public class Pesata extends OggettoIndicizzato implements Serializable
{
    long idProdotto;
    long idOrdine;
    float quantita;
    StatoPesata stato;

    public Pesata
        (
                long id,
                long idProdotto,
                long idOrdine,
                float quantita,
                StatoPesata stato
        )
    {
        super(id);
        this.idProdotto = idProdotto;
        this.idOrdine = idOrdine;
        this.quantita = quantita;
        this.stato = stato;
    }
}
