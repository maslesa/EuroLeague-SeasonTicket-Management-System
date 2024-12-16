/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Ljubomir
 */
public class SeasonCard {
    
    int idSeasonCard;
    int idCard;
    String qrCode;
    int arrivalTime;
    int idFan;
    
    //pomocne
    String clubName;
    String seasonName;
    String cardTypeName;

    public SeasonCard(int idSeasonCard, String qrCode, String clubName, String seasonName, String cardTypeName) {
        this.idSeasonCard = idSeasonCard;
        this.qrCode = qrCode;
        this.clubName = clubName;
        this.seasonName = seasonName;
        this.cardTypeName = cardTypeName;
    }
    
    

    public SeasonCard(int idCard, String qrCode, int arrivalTime, int idFan) {
        this.idCard = idCard;
        this.qrCode = qrCode;
        this.idFan = idFan;
        this.arrivalTime = arrivalTime;
    }

    public int getIdSeasonCard() {
        return idSeasonCard;
    }

    public void setIdSeasonCard(int idSeasonCard) {
        this.idSeasonCard = idSeasonCard;
    }

    public int getidCard() {
        return idCard;
    }

    public void setidCard(int idKarta) {
        this.idCard = idKarta;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getIdFan() {
        return idFan;
    }

    public void setIdFan(int idFan) {
        this.idFan = idFan;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }
    
    
    
}
