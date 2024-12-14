/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.club;

import javax.swing.table.AbstractTableModel;
import java.util.*;
import models.Card;

/**
 *
 * @author Ljubomir
 */
public class TableModelAllSeasonTickets extends AbstractTableModel {

    String[] columns = {"Card ID", "Season", "Card Type", "Price", "Vacances"};
    List<Card> cards = new ArrayList<>();

    public TableModelAllSeasonTickets(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public int getRowCount() {
        return cards.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Card card = cards.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return String.valueOf(card.getIdCard());
            case 1:
                return card.getSeasonName();
            case 2:
                return card.getCardTypeName();
            case 3:
                return String.valueOf(card.getPrice());
            case 4:
                return String.valueOf(card.getVacances());
            default:
                return "N/A";
        }
        
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    Card getCard(int rowIndex) {
        return cards.get(rowIndex);
    }

    void refreshDatas() {
        fireTableDataChanged();
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    
    
    

}
