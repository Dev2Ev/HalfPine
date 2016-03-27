/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario.FolderDataBase;

import static bollettario.Bollettario.debug;
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
        if(debug)System.out.println("Prodotto.Prodotto()");
        this.nome = nome;
        //this.nome = adattaNome(nome);
        this.unitaDiMisura = unitaDiMisura;
    }

    private String adattaNome(String nome)
    {
        if(debug)System.out.println("Prodotto.adattaNome()");
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
        if(debug)System.out.println("Prodotto.toString()");
        String s = getId() +" "+ nome +" "+ unitaDiMisura;
        return s;
    }
    
}
