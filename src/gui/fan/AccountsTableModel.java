/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.fan;

import javax.swing.table.AbstractTableModel;
import java.util.*;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import models.Account;

/**
 *
 * @author Ljubomir
 */
public class AccountsTableModel extends AbstractTableModel {

    List<Account> accounts = new ArrayList<>();

    final String[] kolone = {"Account Number", "Balance"};

    public AccountsTableModel(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public int getRowCount() {
        return accounts.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Account acc = accounts.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return makeBrojRacuna(acc.getBrojRacuna());
            case 1:
                return acc.getStanje();
            default:
                return "N/A";
        }

    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    private String makeBrojRacuna(String brojRacuna) {
        char[] novi = brojRacuna.toCharArray();

        for (int i = 0; i < brojRacuna.length(); i++) {
            if (i < brojRacuna.length() - 4 && i != 4 && i != 9 && i != 14) {
                novi[i] = '*';
            }
        }
        return new String(novi);
    }

}
