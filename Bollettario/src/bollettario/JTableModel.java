/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DiegoCarlo
 */
public class JTableModel extends DefaultTableModel
{

    public JTableModel(Object[][] os, Object[] os1) {
        super(os, os1);
    }
    
    @Override
    public boolean isCellEditable(int riga, int colonna) {
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
