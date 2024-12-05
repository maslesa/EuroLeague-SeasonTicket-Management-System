/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import models.Fan;
import db.DBBroker;
import gui.login.SignupPage;
import java.util.List;
import models.Card;
import models.CardType;
import models.Club;
import models.Match;
import models.Season;
import models.SeasonCard;

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

    public List<Season> getAllSeasons() {
        return dbbroker.getAllSeasons();
    }

    public List<Club> getAllClubs() {
        return dbbroker.getAllClubs();
    }

    public List<CardType> getAllCardTypes() {
        return dbbroker.getAllCardTypes();
    }

    public Club fillVariablesClub(String inputUsername) {
        return dbbroker.fillVariablesClub(inputUsername);
    }

    public boolean insertNewCard(Card newCard) {
        return dbbroker.insertNewCard(newCard);
    }

    public List<Card> getAllCards(Club club) {
        return dbbroker.getAllCards(club);
    }

    public List<Card> getAllCardsNew(Club club) {
        return dbbroker.getAllCardsNew(club);
    }

    public List<Season> getPossibleSeasons(Club club) {
        return dbbroker.getPossibleSeasons(club);
    }

    public List<CardType> getPossibleCardTypes(Club club, Season season) {
        return dbbroker.getPossibleCardTypes(club, season);
    }

    public Card selectCardByParameters(int idKlub, int idSezona, int idCardType) {
        return dbbroker.selectCardByParameters(idKlub, idSezona, idCardType);
    }

    public boolean insertCards(Card card, Fan fan, int numOfCards) {
        return dbbroker.insertCards(card, fan, numOfCards);
    }

    public List<SeasonCard> getAllSeasonCards(Fan fan) {
        return dbbroker.getAllSeasonCards(fan);
    }

    public boolean updateCardVacances(Card card, int numOfCards) {
        return dbbroker.updateCardVacances(card, numOfCards);
    }

    public List<Fan> getAllFansForClub(Club club) {
        return dbbroker.getAllFansForClub(club);
    }

    public boolean updateClubDatas(String newUsernamem, String newEmailString, String newPhone, Club club) {
        return dbbroker.updateClubDatas(newUsernamem, newEmailString, newPhone, club);
    }

    public Club getClubWithNewDatas(Club club) {
        return dbbroker.getClubWithNewDatas(club);
    }

    public boolean updateCard(Club club, Card card) {
        return dbbroker.updateCard(club, card);
    }

    public boolean updateCard(Card card, double price, int vacances) {
        return dbbroker.updateCard(card, price, vacances);
    }

    public boolean insertNewMatch(Match newMatch) {
        return dbbroker.insertNewMatch(newMatch);
    }

    public List<Match> getAllMatches(Club club) {
        return dbbroker.getAllMatches(club);
    }

}
