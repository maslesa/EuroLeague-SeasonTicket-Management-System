/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ljubomir
 */
public class Konekcija {

    private static Konekcija instance;
    Connection con = null;

    private Konekcija() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosoft", "root", "root");
            System.out.println("Povezano sa bazom");
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konekcija getInstance() {
        if (instance == null) {
            instance = new Konekcija();
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }

}
