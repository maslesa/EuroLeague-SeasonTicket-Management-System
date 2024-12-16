/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Ljubomir
 */
public class Season {
    
    int idSezona;
    String name;

    public Season(int idSezona, String name) {
        this.idSezona = idSezona;
        this.name = name;
    }

    public int getIdSezona() {
        return idSezona;
    }

    public void setIdSezona(int idSezona) {
        this.idSezona = idSezona;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
