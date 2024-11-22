/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Ljubomir
 */
public class CardType {
    
    int idCardType;
    String name;
    double popust;

    public CardType(int idCardType, String name, double popust) {
        this.idCardType = idCardType;
        this.name = name;
        this.popust = popust;
    }

    public int getIdCardType() {
        return idCardType;
    }

    public void setIdCardType(int idCardType) {
        this.idCardType = idCardType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopust() {
        return popust;
    }

    public void setPopust(double popust) {
        this.popust = popust;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
