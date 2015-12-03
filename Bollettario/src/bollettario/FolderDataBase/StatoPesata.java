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
    NUOVA, // quando non è ancora stata attivata o è stata disattivata
    VALIDA, // quando è stata pesata
    STAMPATA  
}
