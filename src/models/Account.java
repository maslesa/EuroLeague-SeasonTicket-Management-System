/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Ljubomir
 */
public class Account {
    
    int idRacun;
    String brojRacuna;
    String datumIsteka;
    String cvv;
    double stanje;

    public Account(int idRacun, String brojRacuna, String datumIsteka, String cvv, double stanje) {
        this.idRacun = idRacun;
        this.brojRacuna = brojRacuna;
        this.datumIsteka = datumIsteka;
        this.cvv = cvv;
        this.stanje = stanje;
    }

    public int getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(int idRacun) {
        this.idRacun = idRacun;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public String getDatumIsteka() {
        return datumIsteka;
    }

    public void setDatumIsteka(String datumIsteka) {
        this.datumIsteka = datumIsteka;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getStanje() {
        return stanje;
    }

    public void setStanje(double stanje) {
        this.stanje = stanje;
    }
    
    
    
}
