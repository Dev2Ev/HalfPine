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
public class Prodotto extends OggettoIndicizzato implements Serializable
{
    String nome;
    long idUnitaDiMisura;

    public Prodotto(long id, String nome, long idUnitaDiMisura)
    {
        super(id);
        this.nome = nome;
        this.idUnitaDiMisura = idUnitaDiMisura;
    }
}
