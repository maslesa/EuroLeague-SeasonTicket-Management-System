/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.club;

import javax.swing.table.AbstractTableModel;
import java.util.*;
import model.Fan;


/**
 *
 * @author Ljubomir
 */
public class TableModelAllFans extends AbstractTableModel{
    
    List<Fan> fans = new ArrayList<>();
    String[] columns = {"Fan name", "Email", "Phone", "Season", "Card type"};

    public TableModelAllFans(List<Fan> fans) {
        this.fans = fans;
    }
    
    @Override
    public int getRowCount() {
        return fans.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fan fan = fans.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return fan.getName() + " " + fan.getSurname();
            case 1:
                return fan.getEmail();
            case 2:
                return fan.getPhone();
            case 3:
                return fan.getSeasonName();
            case 4:
                return fan.getCardTypeName();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    
    
}
