/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sierracablesstores_kurunegala;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dulaj Ayeshan
 */
public class ItemDetails extends AbstractTableModel {
    
    private static final String[] COLUMN_NAMES = {"No","Name","Quantity"};
    private static ArrayList<Item> list;
    
        ItemDetails(ArrayList<Item> stList){
        list = stList;
    }
    
    public boolean isCellEditable(int row, int col) {
        if (col== 2) { //columnIndex: the column you want to make it editable
            return true;
        } else {
            return false;
        }
    }
        
        
        
    @Override
    public int getRowCount() {
        
        return list.size();
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];
        
    }
    
    
    @Override
    public int getColumnCount() {
        
        return COLUMN_NAMES.length;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getItemId();
            case 1:
                return list.get(rowIndex).getName();
//            case 3:
//                return null;
           default:
                return "error";
                        }

    }
}
