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

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputFile
{

    public static void scrivi(String nomeFile, Object oggetto)
    {
        File f = new File(nomeFile);
        ObjectOutputStream archivio = null;
        try
        {
            archivio = new ObjectOutputStream(
                            new BufferedOutputStream(
                                            new FileOutputStream(f)));

            archivio.writeObject(oggetto);
        }
        catch(Exception c)
        {
            c.printStackTrace();
        }
        finally
        {
            if(archivio != null)
            {
                try
                {
                    archivio.close();
                }
                catch(Exception c)
                {
                    c.printStackTrace();
                }
            }
        }
    }
}

