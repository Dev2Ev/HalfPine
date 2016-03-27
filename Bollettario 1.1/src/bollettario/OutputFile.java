/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

/**
 * Classe di scrittura del file
 * @author DiegoCarlo
 */

import static bollettario.Bollettario.debug;
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
        if(debug)System.out.println("OutputFile.scrivi()");
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

