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
public class ClienteIndicizzato
{
    String codice;
    String ragioneSociale;

    public ClienteIndicizzato(String codice, String ragioneSociale)
    {
        this.codice = codice;
        this.ragioneSociale = ragioneSociale;
    }

    @Override
    public String toString() {
        return ragioneSociale;
    }

    public String getCodice() {
        return codice;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }
    
}
