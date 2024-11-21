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
    String naziv;
    String sifra;
    String email;

    public Club(String naziv, String sifra, String email) {
        this.naziv = naziv;
        this.sifra = sifra;
        this.email = email;
    }

    public int getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(int idKlub) {
        this.idKlub = idKlub;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
