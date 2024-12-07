/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.club;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Match;

/**
 *
 * @author Ljubomir
 */
public class TableModelAllMatches extends AbstractTableModel {

    List<Match> matches = new ArrayList<>();
    String[] columns = {"Match", "Date and time", "Host", "Guest", "Season", "Game over"};
    
    public TableModelAllMatches(List<Match> matches ) {
        this.matches = matches;
    }
    
    
    @Override
    public int getRowCount() {
        return matches.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Match match = matches.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return match.getFullName();
            case 1:
                return match.getDateTime().toString();
            case 2:
                return match.getHostName();
            case 3:
                return match.getGuestName();
            case 4:
                return match.getSeasonName();
            case 5:
                Duration duration = Duration.between(LocalDateTime.now(), match.getDateTime());
                if(duration.toHours() <= 3 && duration.isNegative()){
                    return true;
                }
                return false;
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 5){
            return Boolean.class;
        }
        return String.class;
    }

    Match getMatch(int rowIndex) {
        return matches.get(rowIndex);
    }
    
    
    
}
