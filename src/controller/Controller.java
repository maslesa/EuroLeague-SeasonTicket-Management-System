/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Fan;
import db.DBBroker;
import gui.login.SignupPage;
import java.time.LocalDateTime;
import java.util.List;
import model.Card;
import model.CardType;
import model.Club;
import model.Match;
import model.Season;
import model.SeasonCard;

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

    public List<Card> getAllCards(Club club, String sorter) {
        return dbbroker.getAllCards(club, sorter);
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

    public String getQRCodeString(SeasonCard selectedCard) {
        return dbbroker.getQRCodeString(selectedCard);
    }

    public LocalDateTime getDateTimeOfLatestMatch(SeasonCard selectedCard) {
        return dbbroker.getDateTimeOfLatestMatch(selectedCard);
    }

    public void setQRCode(String qrCodeString, SeasonCard selectedCard) {
        dbbroker.setQRCode(qrCodeString, selectedCard);
    }

    public Fan getNewFan() {
        return dbbroker.getNewFan();
    }

    public String getArenaName(int idHost) {
        return dbbroker.getArenaName(idHost);
    }

    public int getIdHost(Match match) {
        return dbbroker.getIdHost(match);
    }

    public int getNumberOfCardTypes() {
        return dbbroker.getNumberOfCardTypes();
    }

    public boolean getCorrectSeason(Club club, Season season, int numOfCardTypes) {
        return dbbroker.getCorrectSeason(club, season, numOfCardTypes);
    }

    public boolean getAllSeasonsWithZeroCardDefined(Club club, Season season) {
        return dbbroker.getAllSeasonsWithZeroCardDefined(club, season);
    }

    public boolean deleteSelectedSeasonTicket(Card selectedCard) {
        return dbbroker.deleteSelectedSeasonTicket(selectedCard);
    }

    public List<Card> getAllCardsBySeason(Club club, Season oldSeason) {
        return dbbroker.getAllCardsBySeason(club, oldSeason);
    }

    public boolean setValuesForNewSeason(Season selectedSeason, List<Card> cards, Club club) {
        return dbbroker.setValuesForNewSeason(selectedSeason, cards, club);
    }

    public boolean deleteSelectedMatch(Match selectedMatch) {
        return dbbroker.deleteSelectedMatch(selectedMatch);
    }

    public boolean updateMatch(Match match, LocalDateTime newDate) {
        return dbbroker.updateMatch(match, newDate);
    }


}
