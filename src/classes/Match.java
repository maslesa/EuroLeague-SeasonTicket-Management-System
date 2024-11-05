/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDateTime;

/**
 *
 * @author Ljubomir
 */
public class Match {
    
    int idUtakmica;
    String naziv;
    String mesto;
    LocalDateTime datum;

    public Match(String naziv, String mesto, LocalDateTime datum) {
        this.naziv = naziv;
        this.mesto = mesto;
        this.datum = datum;
    }

    public int getIdUtakmica() {
        return idUtakmica;
    }

    public void setIdUtakmica(int idUtakmica) {
        this.idUtakmica = idUtakmica;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }
    
    
    
}
