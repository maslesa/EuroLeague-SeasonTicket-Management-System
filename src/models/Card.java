/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Ljubomir
 */
public class Card {

    int idCard;
    double price;
    int vacances;
    int idSeason;
    int idClub;
    int idCardType;
    
    //pomocne
    String seasonName;
    String cardTypeName;

    public Card(int idCard, double price, int vacances, String seasonName, String cardTypeName) {
        this.idCard = idCard;
        this.price = price;
        this.vacances = vacances;
        this.seasonName = seasonName;
        this.cardTypeName = cardTypeName;
    }
    

    public Card(double price, int vacances, int idSeason, int idClub, int idCardType) {
        this.price = price;
        this.vacances = vacances;
        this.idSeason = idSeason;
        this.idClub = idClub;
        this.idCardType = idCardType;
    }

    public Card(int idCard, double price, int vacances, int idSeason, int idClub, int idCardType) {
        this.idCard = idCard;
        this.price = price;
        this.vacances = vacances;
        this.idSeason = idSeason;
        this.idClub = idClub;
        this.idCardType = idCardType;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVacances() {
        return vacances;
    }

    public void setVacances(int vacances) {
        this.vacances = vacances;
    }

    public int getIdSeason() {
        return idSeason;
    }

    public void setIdSeason(int idSeason) {
        this.idSeason = idSeason;
    }

    public int getIdClub() {
        return idClub;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public int getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(int idCardType) {
        this.idCardType = idCardType;
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
