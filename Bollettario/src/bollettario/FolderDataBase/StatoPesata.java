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
public enum StatoPesata implements Serializable
{
    INATTIVA, // quando non è ancora stata attivata o è stata disattivata
    ESAURITA, // quando è stata pesata
    FOCUS_ATTIVA, // in attesa di conferma del peso
    ATTIVA // in attesa di essere stampata
}
