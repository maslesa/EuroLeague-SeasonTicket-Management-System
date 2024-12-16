/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.club;

import javax.swing.table.AbstractTableModel;
import model.Card;
import java.util.*;

/**
 *
 * @author Ljubomir
 */
public class TableModelDefineNewSeason extends AbstractTableModel {

    List<Card> cards = new ArrayList<>();
    String[] columns = {"Card Type", "Price", "Vacances"};

    public TableModelDefineNewSeason(List<Card> cards) {
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
                return card.getCardTypeName();
            case 1:
                return String.valueOf(card.getPrice());
            case 2:
                return String.valueOf(card.getVacances());
            default:
                return "N/A";
        }

    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    void refreshDatas() {
        fireTableDataChanged();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
