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
        //this.nome = adattaNome(nome);
        this.unitaDiMisura = unitaDiMisura;
    }

    private String adattaNome(String nome)
    {
        int max = 12;
        if(nome.length() < 12)
        {
            max = nome.length();
        }
        return nome.substring(0, max);
    }
    @Override
    public String toString()
    {
        String s = getId() +" "+ nome +" "+ unitaDiMisura;
        return s;
    }
    
}
