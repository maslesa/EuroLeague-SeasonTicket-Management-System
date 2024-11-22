/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Ljubomir
 */
public class Club {
    
    int idKlub;
    String username;
    String sifra;
    String fullName;

    public Club(int idKlub, String naziv, String sifra, String email) {
        this.idKlub = idKlub;
        this.username = naziv;
        this.sifra = sifra;
        this.fullName = email;
    }
    
    

    public Club(String naziv, String sifra, String email) {
        this.username = naziv;
        this.sifra = sifra;
        this.fullName = email;
    }

    public int getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(int idKlub) {
        this.idKlub = idKlub;
    }

    public String getNaziv() {
        return username;
    }

    public void setNaziv(String naziv) {
        this.username = naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
    
    
    
}
