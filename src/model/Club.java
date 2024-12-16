/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ljubomir
 */
public class Club {

    int idKlub;
    String username;
    String sifra;
    String fullName;
    String email;
    String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Club(int idKlub, String naziv, String sifra, String fullName, String email, String phone) {
        this.idKlub = idKlub;
        this.username = naziv;
        this.sifra = sifra;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        
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
