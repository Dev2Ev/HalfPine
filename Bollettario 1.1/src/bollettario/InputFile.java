/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Classe adibita alla lettura del file
 * @author DiegoCarlo
 */
public class InputFile
{
	public static Object leggi(String nomeFile) throws ClassNotFoundException
	{
		File f = new File(nomeFile);
		ObjectInputStream sorgente = null;

		Object oggetto = null;
		try
		{
			sorgente = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(f)));
			oggetto = sorgente.readObject();
		}
		catch(IOException c)
		{
			c.printStackTrace();
                        oggetto = null;
		}
                catch(Exception c)
                {
                    
                }
                
		finally
		{
			if(sorgente != null)
			{
				try
				{
					sorgente.close();
				}
				catch(Exception c)
				{
					c.printStackTrace();
				}
			}
		}

		return oggetto;
	}
}
