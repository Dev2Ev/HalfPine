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
    public String nome;
    public UnitaDiMisura unitaDiMisura;

    public Prodotto(long id, String nome, UnitaDiMisura unitaDiMisura)
    {
        super(id);
        this.nome = nome;
        this.unitaDiMisura = unitaDiMisura;
    }
}
