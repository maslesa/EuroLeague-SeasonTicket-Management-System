/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import models.Fan;
import db.DBBroker;
import gui.login.SignupPage;
import java.util.List;
import models.Account;
import models.CardType;
import models.Club;
import models.Season;

/**
 *
 * @author Ljubomir
 */
public class Controller {

    private static Controller instance;
    private DBBroker dbbroker;

    private Controller() {
        dbbroker = new DBBroker();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public boolean userExistsLogin(String inputUsername, String inputPassword) {
        return dbbroker.userExistsLogin(inputUsername, inputPassword);
    }

    public boolean ClubExistsLogin(String inputUsername, String inputPassword) {
        return dbbroker.ClubExistsLogin(inputUsername, inputPassword);
    }

    public Fan fillVariables(String inputUsername) {
        return dbbroker.fillVariables(inputUsername);
    }

    public boolean addNewNavijac(Fan fan) {
        return dbbroker.addNewNavijac(fan);
    }

    public List<String> getAllFansUsernames() {
        return dbbroker.getAllFansUsernames();
    }

    public void updatePassword(String newPassword, Fan fan) {
        dbbroker.updatePassword(newPassword, fan);
    }

    public void updateDatasInBase(String newName, String newSurname, String newUsername, String newEmail, String newPhone, Fan fan) {
        dbbroker.updateDatasInBase(newName, newSurname, newUsername, newEmail, newPhone, fan);
    }

    public List<Account> getAllRacuni(Fan fan) {
        return dbbroker.getAllRacuni(fan);
    }

    public List<Season> getAllSeasons() {
        return dbbroker.getAllSeasons();
    }

    public List<Club> getAllClubs() {
        return dbbroker.getAllClubs();
    }

    public List<CardType> getAllCardTypes() {
        return dbbroker.getAllCardTypes();
    }


}
