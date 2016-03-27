package bollettario;

import bollettario.FolderDataBase.DataBase;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * Classe contenente il main del programma e relative costanti
 * @author DiegoCarlo
 */
public class Bollettario
{
    public static Interfaccia interfaccia;
    public static DataBase dataBase;
    public static String nomeDB = "DataBaseGF";
    public static String estensione = ".dbn";
    public static boolean debug = true;
    /**
     * main
     * @param args 
     */
    public static void main(String[] args)
    {
        if(debug)System.out.println("Bollettario.main()");
        caricaStile();
        dataBase = new DataBase();
        carica();
        //dataBase.test();
        salva();
        System.out.print(dataBase.toString());
        interfaccia = new Interfaccia();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                interfaccia.setVisible(true);
            }
        });
    }
    static private void caricaStile()
    {
        if(debug)System.out.println("Bollettario.caricaStile()");
        try
        {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } 
        catch(UnsupportedLookAndFeelException e) {
        // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
    }
    /**
    *   funzione di salvataggio del singolo file DataBase
    */
    public static void salva()
    {
        if(debug)System.out.println("Bollettario.salva()");
        OutputFile.scrivi(nomeDB+estensione, dataBase);
    }
    /**
     *  funzione di caricamento del singolo file DataBase
     */
    public static void carica()
    {
        if(debug)System.out.println("Bollettario.carica()");
        try
        {
            dataBase = (DataBase)InputFile.leggi(nomeDB+estensione);
            if(dataBase == null)
            {
                dataBase = new DataBase();
                dataBase.test();
            }   
        }
        catch(ClassNotFoundException c)
        {
            System.out.println("Errore nel caricamento dei file" + "\n" + c.toString());
        }
    }
    
}
