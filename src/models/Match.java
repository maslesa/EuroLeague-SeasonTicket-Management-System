/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDateTime;

/**
 *
 * @author Ljubomir
 */
public class Match {
 
    int idMatch;
    String fullName;
    LocalDateTime dateTime;
    int idHost;
    int idGuest;
    int idSeason;

    public Match(int idMatch, String fullName, LocalDateTime dateTime, int idHost, int idGuest, int idSeason) {
        this.idMatch = idMatch;
        this.fullName = fullName;
        this.dateTime = dateTime;
        this.idHost = idHost;
        this.idGuest = idGuest;
        this.idSeason = idSeason;
    }

    public Match(String fullName, LocalDateTime dateTime, int idHost, int idGuest, int idSeason) {
        this.fullName = fullName;
        this.dateTime = dateTime;
        this.idHost = idHost;
        this.idGuest = idGuest;
        this.idSeason = idSeason;
    }
    
    

    public int getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getIdHost() {
        return idHost;
    }

    public void setIdHost(int idHost) {
        this.idHost = idHost;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public void setIdGuest(int idGuest) {
        this.idGuest = idGuest;
    }

    public int getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(int idSeason) {
        this.idSeason = idSeason;
    }
    
    
    
    
}
