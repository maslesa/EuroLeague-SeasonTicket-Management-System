/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.fan;

import javax.swing.table.AbstractTableModel;
import model.SeasonCard;
import java.util.*;
import javax.swing.JTable;

/**
 *
 * @author Ljubomir
 */
public class TableModelSeasonCards extends AbstractTableModel {
    
    List<SeasonCard> seasonCards = new ArrayList<>();
    String[] columns = {"Season Card ID", "Club", "Season", "Card Type"};
    
    public TableModelSeasonCards(List<SeasonCard> seasonCards) {
        this.seasonCards = seasonCards;
    }
    

    @Override
    public int getRowCount() {
        return seasonCards.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SeasonCard sc = seasonCards.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return String.valueOf(sc.getIdSeasonCard());
            case 1:
                return sc.getClubName();
            case 2:
                return sc.getSeasonName();
            case 3:
                return sc.getCardTypeName();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public SeasonCard getSeasonCard(int rowIndex) {
        return seasonCards.get(rowIndex);
    }
    
    
    
}
