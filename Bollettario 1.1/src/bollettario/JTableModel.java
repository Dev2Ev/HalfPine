/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;
import static bollettario.Bollettario.debug;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DiegoCarlo
 */
public class JTableModel extends DefaultTableModel
{

    public JTableModel(Object[][] os, Object[] os1) {
        super(os, os1);
        if(debug)System.out.println("JTableModel.JTableModel()");
        
    }
    
    @Override
    public boolean isCellEditable(int riga, int colonna) {
        if(debug)System.out.println("JTableModel.isCellEditable()");
        if (colonna == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
