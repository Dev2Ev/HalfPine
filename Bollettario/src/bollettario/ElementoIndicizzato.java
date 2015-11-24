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
public class ElementoIndicizzato
{
    String codice;
    String contenuto;

    public ElementoIndicizzato(String codice, String ragioneSociale)
    {
        this.codice = codice;
        this.contenuto = ragioneSociale;
    }

    @Override
    public String toString() {
        return contenuto;
    }

    public String getCodice() {
        return codice;
    }
    public String getContenuto() {
        return contenuto;
    } 
}
