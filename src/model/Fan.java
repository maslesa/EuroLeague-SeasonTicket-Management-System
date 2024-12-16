/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Ljubomir
 */
public class Fan {

    int idNavijac;
    String name;
    String surname;
    String username;
    String email;
    LocalDate birthday;
    String phone;
    String password;

    //pomocne
    String seasonName;
    String cardTypeName;

    public Fan(int idNavijac, String name, String surname, String username, String email, LocalDate birthday, String phone, String password) {
        this.idNavijac = idNavijac;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.birthday = birthday;
        this.phone = phone;
        this.password = password;
    }
    
    

    public Fan(int idNavijac, String name, String surname, String username, String email, String phone, String seasonName, String cardTypeName) {
        this.idNavijac = idNavijac;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.seasonName = seasonName;
        this.cardTypeName = cardTypeName;
    }

    public Fan(String name, String surname, String username, String email, LocalDate birthday, String phone, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.birthday = birthday;
        this.phone = phone;
        this.password = password;
    }

    public int getIdNavijac() {
        return idNavijac;
    }

    public void setIdNavijac(int idNavijac) {
        this.idNavijac = idNavijac;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return name + " " + surname;
    }

}
