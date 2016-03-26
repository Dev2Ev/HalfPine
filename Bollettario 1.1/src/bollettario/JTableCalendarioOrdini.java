/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;
import javax.swing.JTable;
/**
 *
 * @author DiegoCarlo
 */
public class JTableCalendarioOrdini extends JTable{

    @Override
    public boolean isCellEditable(int row, int column)
    {
        if (column == 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
}
