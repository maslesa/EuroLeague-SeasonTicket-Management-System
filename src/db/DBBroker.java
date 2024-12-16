/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import model.Fan;
import gui.login.LoginPage;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class DBBroker {

    public boolean userExistsLogin(String inputUsername, String inputPassword) {
        try {
            System.out.println("db.DBBroker.userExistsLogin()");

            String query = "SELECT username, password FROM navijac";

            Statement st = Konekcija.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                if (inputUsername.equals(username) && inputPassword.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean ClubExistsLogin(String inputUsername, String inputPassword) {

        try {
            System.out.println("db.DBBroker.ClubExistsLogin()");

            String query = "SELECT username, password FROM klub";

            Statement st = Konekcija.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                if (inputUsername.equals(username) && inputPassword.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Fan fillVariables(String inputUsername) {

        Fan fan = new Fan("", "", "", "", LocalDate.MIN, "", "");

        try {
            System.out.println("db.DBBroker.fillVariables()");

            String query = "SELECT * FROM navijac WHERE username = ?";

            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setString(1, inputUsername);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                fan.setIdNavijac(rs.getInt("idNavijac"));
                fan.setName(rs.getString("name"));
                fan.setSurname(rs.getString("surname"));
                fan.setUsername(rs.getString("username"));
                fan.setEmail(rs.getString("email"));
                Date birthdayDate = rs.getDate("birthday");
                LocalDate birthday = birthdayDate.toLocalDate();
                fan.setBirthday(birthday);
                fan.setPhone(rs.getString("phone"));
                fan.setPassword(rs.getString("password"));
                System.out.println("id:" + fan.getIdNavijac() + " name:" + fan.getName() + "surname:" + fan.getSurname() + "username:" + inputUsername);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fan;
    }

    public boolean addNewNavijac(Fan fan) {

        try {

            System.out.println("db.DBBroker.addNewNavijac()");

            String query = "INSERT INTO navijac (name, surname, username, email, birthday, phone, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);

            ps.setString(1, fan.getName());
            ps.setString(2, fan.getSurname());
            ps.setString(3, fan.getUsername());
            ps.setString(4, fan.getEmail());
            ps.setDate(5, java.sql.Date.valueOf(fan.getBirthday()));
            ps.setString(6, fan.getPhone());
            ps.setString(7, fan.getPassword());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "User added", "Successful", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "User not added", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }

        return false;

    }

    public List<String> getAllFansUsernames() {
        List<String> allUsernames = new ArrayList<>();
        try {
            String query = "SELECT username FROM navijac";

            Statement st = Konekcija.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");

                allUsernames.add(username);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Napunjena lista");
        return allUsernames;
    }

    public void updatePassword(String newPassword, Fan fan) {
        try {
            String query = "UPDATE navijac SET password = ? WHERE idNavijac = ?";

            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setInt(2, fan.getIdNavijac());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateDatasInBase(String newName, String newSurname, String newUsername, String newEmail, String newPhone, Fan fan) {
        try {
            String query = "UPDATE navijac SET name = ?, surname = ?, username = ?, email = ?, phone = ? WHERE idNavijac = ?";

            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);

            ps.setString(1, newName);
            ps.setString(2, newSurname);
            ps.setString(3, newUsername);
            ps.setString(4, newEmail);
            ps.setString(5, newPhone);
            ps.setInt(6, fan.getIdNavijac());

            int ra = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Season> getAllSeasons() {
        List<Season> sezone = new ArrayList<>();
        try {
            String query = "SELECT * FROM sezona";

            Statement st = Konekcija.getInstance().getCon().createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idsezona");
                String naziv = rs.getString("naziv");

                Season newSeason = new Season(id, naziv);

                sezone.add(newSeason);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sezone;
    }

    public List<Club> getAllClubs() {
        List<Club> clubs = new ArrayList<>();
        try {
            String query = "SELECT * FROM klub";

            Statement st = Konekcija.getInstance().getCon().createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idKlub");
                String username = rs.getString("username");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                Club newClub = new Club(id, username, password, fullName, email, phone);

                clubs.add(newClub);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clubs;
    }

    public List<CardType> getAllCardTypes() {
        List<CardType> cardTypes = new ArrayList<>();
        try {
            String query = "SELECT * FROM tipkarte";

            Statement st = Konekcija.getInstance().getCon().createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idTipKarte");
                String naziv = rs.getString("naziv");

                CardType newCardType = new CardType(id, naziv);

                cardTypes.add(newCardType);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cardTypes;
    }

    public Club fillVariablesClub(String inputUsername) {
        Club club = new Club(0, "", "", "", "", "");
        try {

            String query = "SELECT * FROM klub WHERE username = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setString(1, inputUsername);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                club.setIdKlub(rs.getInt("idKlub"));
                club.setUsername(rs.getString("username"));
                club.setFullName(rs.getString("fullName"));
                club.setSifra(rs.getString("password"));
                club.setEmail(rs.getString("email"));
                club.setPhone(rs.getString("phone"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return club;
    }

    public boolean insertNewCard(Card newCard) {
        try {
            String query = "INSERT INTO karta(cena, slobodnaMesta, idKlub, idSezona, idTipKarta) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setDouble(1, newCard.getPrice());
            ps.setInt(2, newCard.getVacances());
            ps.setInt(3, newCard.getIdClub());
            ps.setInt(4, newCard.getIdSeason());
            ps.setInt(5, newCard.getIdCardType());
            int ra = ps.executeUpdate();

            if (ra > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public List<Card> getAllCards(Club club, String sorter) {
        List<Card> cards = new ArrayList<>();
        try {
            String query = "SELECT k.idkarta, s.naziv, tk.naziv, k.cena, k.slobodnaMesta FROM karta k JOIN klub kl on (k.idKlub = kl.idKlub) JOIN sezona s on (k.idSezona = s.idsezona) join tipkarte tk on (k.idTipKarta = tk.idTipKarte) where k.idKlub = ? ORDER BY " + sorter + " ASC";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cardID = rs.getInt("k.idkarta");
                String seasonName = rs.getString("s.naziv");
                String cardTypeName = rs.getString("tk.naziv");
                double price = rs.getDouble("k.cena");
                int vacances = rs.getInt("k.slobodnaMesta");
                Card card = new Card(cardID, price, vacances, seasonName, cardTypeName);
                cards.add(card);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cards;

    }

    public List<Card> getAllCardsNew(Club club) {
        List<Card> cards = new ArrayList<>();
        try {
            String query = "SELECT * FROM karta WHERE idKlub = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cardID = rs.getInt("idkarta");
                double price = rs.getDouble("cena");
                int vacances = rs.getInt("slobodnaMesta");
                int idClub = rs.getInt("idKlub");
                int idSeason = rs.getInt("idSezona");
                int idCardType = rs.getInt("idTipKarta");
                Card card = new Card(cardID, price, vacances, idSeason, idClub, idCardType);
                cards.add(card);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cards;
    }

    public List<Season> getPossibleSeasons(Club club) {
        List<Season> seasons = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT s.idsezona, s.naziv FROM sezona s JOIN karta k ON (s.idsezona = k.idSezona) WHERE k.idKlub = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSeason = rs.getInt("s.idsezona");
                String name = rs.getString("s.naziv");
                Season s = new Season(idSeason, name);
                seasons.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seasons;
    }

    public List<CardType> getPossibleCardTypes(Club club, Season season) {
        List<CardType> cardtypes = new ArrayList<>();
        try {
            String query = "SELECT DISTINCT tk.idTipKarte, tk.naziv FROM tipkarte tk JOIN karta k ON (tk.idTipKarte = k.idTipKarta) JOIN sezona s ON (k.idSezona = s.idsezona) WHERE k.idKlub = ? AND k.idSezona = ? AND k.slobodnaMesta != 0";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ps.setInt(2, season.getIdSezona());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCardType = rs.getInt("tk.idTipKarte");
                String nameCardType = rs.getString("tk.naziv");
                CardType cardtype = new CardType(idCardType, nameCardType);
                cardtypes.add(cardtype);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cardtypes;
    }

    public Card selectCardByParameters(int idKlub, int idSezona, int idCardType) {
        try {
            String query = "SELECT k.idkarta, k.cena, k.slobodnaMesta, kl.fullName, s.naziv, tk.naziv FROM karta k JOIN klub kl ON (k.idKlub = kl.idKlub) JOIN sezona s ON (k.idSezona = s.idsezona) JOIN  tipkarte tk ON (k.idTipKarta = tk.idTipKarte) WHERE k.idKlub = ? AND k.idSezona = ? AND k.idTipKarta = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, idKlub);
            ps.setInt(2, idSezona);
            ps.setInt(3, idCardType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idCard = rs.getInt("k.idkarta");
                double price = rs.getDouble("k.cena");
                int vacances = rs.getInt("k.slobodnaMesta");
                String clubName = rs.getString("kl.fullName");
                String seasonName = rs.getString("s.naziv");
                String cardTypeName = rs.getString("tk.naziv");

                Card card = new Card(idCard, price, vacances, clubName, seasonName, cardTypeName);

                return card;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean insertCards(Card card, Fan fan, int numOfCards) {

        try {
            String query = "INSERT INTO sezonskakarta(idKarta, idNavijac) values (?, ?)";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, card.getIdCard());
            ps.setInt(2, fan.getIdNavijac());
            int ra = 0;

            for (int i = 0; i < numOfCards; i++) {
                ra += ps.executeUpdate();
            }

            if (ra > 0) {
                return true;
            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public List<SeasonCard> getAllSeasonCards(Fan fan) {
        List<SeasonCard> seasonCards = new ArrayList<>();
        try {
            String query = "SELECT sk.idSezonskaKarta, kl.fullName, s.naziv, tk.naziv, sk.qrCode FROM sezonskaKarta sk JOIN karta k ON (sk.idKarta = k.idkarta) JOIN klub kl ON (k.idKlub = kl.idKlub) JOIN sezona s ON (k.idSezona = s.idsezona) JOIN tipkarte tk ON (k.idTipKarta = tk.idTipKarte) WHERE sk.idNavijac = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, fan.getIdNavijac());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idSeasonCard = rs.getInt("sk.idSezonskaKarta");
                String clubName = rs.getString("kl.fullName");
                String seasonName = rs.getString("s.naziv");
                String cardType = rs.getString("tk.naziv");
                String qrCode = rs.getString("sk.qrCode");

                SeasonCard seasonCard = new SeasonCard(idSeasonCard, qrCode, clubName, seasonName, cardType);

                seasonCards.add(seasonCard);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return seasonCards;
    }

    public boolean updateCardVacances(Card card, int numOfCards) {

        try {
            int newVacances = card.getVacances() - numOfCards;

            String query = "UPDATE karta SET slobodnaMesta = ? WHERE idKarta = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, newVacances);
            ps.setInt(2, card.getIdCard());
            int ra = ps.executeUpdate();
            if (ra > 0) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public List<Fan> getAllFansForClub(Club club) {
        List<Fan> fans = new ArrayList<>();
        try {
            String query = "SELECT n.idNavijac, n.name, n.surname, n.username, n.email, n.phone, s.naziv, tk.naziv FROM navijac n JOIN sezonskakarta sk ON (n.idNavijac = sk.idNavijac) JOIN karta k ON (sk.idKarta = k.idkarta) JOIN sezona s ON (k.idSezona = s.idsezona) JOIN tipkarte tk ON (k.idTipKarta = tk.idTipKarte) WHERE k.idKlub = ? ORDER BY s.naziv";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idFan = rs.getInt("n.idNavijac");
                String nameFan = rs.getString("n.name");
                String surnameFan = rs.getString("n.surname");
                String usernameFan = rs.getString("n.username");
                String emailFan = rs.getString("n.email");
                String phoneFan = rs.getString("n.phone");
                String nameSeason = rs.getString("s.naziv");
                String nameCardType = rs.getString("tk.naziv");
                Fan fan = new Fan(idFan, nameFan, surnameFan, usernameFan, emailFan, phoneFan, nameSeason, nameCardType);
                fans.add(fan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fans;

    }

    public boolean updateClubDatas(String newUsernamem, String newEmailString, String newPhone, Club club) {
        try {
            String query = "UPDATE klub SET username = ?, email = ?, phone = ? WHERE idKlub = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setString(1, newUsernamem);
            ps.setString(2, newEmailString);
            ps.setString(3, newPhone);
            ps.setInt(4, club.getIdKlub());
            int ra = ps.executeUpdate();
            if (ra > 0) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Club getClubWithNewDatas(Club club) {
        try {
            String query = "SELECT * FROM klub WHERE idKlub = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idKlub");
                String username = rs.getString("username");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                Club newClub = new Club(id, username, password, fullName, email, phone);

                return newClub;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public boolean updateCard(Club club, Card card) {
        try {
            String query = "UPDATE karta SET cena = ?, slobodnaMesta = ? WHERE idKlub = ? AND idSezona = ? AND idTipKarta = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setDouble(1, card.getPrice());
            ps.setInt(2, card.getVacances());
            ps.setInt(3, club.getIdKlub());
            ps.setInt(4, card.getIdSeason());
            ps.setInt(5, card.getIdCardType());

            int ra = ps.executeUpdate();
            if (ra > 0) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateCard(Card card, double price, int vacances) {
        try {
            String query = "UPDATE karta SET cena = ?, slobodnaMesta = ? WHERE idkarta = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setDouble(1, price);
            ps.setInt(2, vacances);
            ps.setInt(3, card.getIdCard());
            int ra = ps.executeUpdate();
            if (ra > 0) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean insertNewMatch(Match newMatch) {
        try {
            String query = "INSERT INTO utakmica (fullName, dateTime, idDomacin, idGost, idSezona) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setString(1, newMatch.getFullName());
            Timestamp dateForInput = Timestamp.valueOf(newMatch.getDateTime());
            ps.setTimestamp(2, dateForInput);
            ps.setInt(3, newMatch.getIdHost());
            ps.setInt(4, newMatch.getIdGuest());
            ps.setInt(5, newMatch.getIdSeason());
            int ra = ps.executeUpdate();
            if (ra > 0) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Match> getAllMatches(Club club) {
        List<Match> matches = new ArrayList<>();
        try {
            String query = "SELECT u.idUtakmica, u.fullName, u.dateTime, kd.fullName, kg.fullName, s.naziv FROM utakmica u JOIN klub kd ON (u.idDomacin = kd.idKlub) JOIN klub kg ON (u.idGost = kg.idKlub) JOIN sezona s ON (u.idSezona = s.idsezona) WHERE u.idDomacin = ? OR u.idGost = ? ORDER BY u.dateTime";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ps.setInt(2, club.getIdKlub());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idMatch = rs.getInt("u.idUtakmica");
                String fullName = rs.getString("u.fullName");
                Timestamp datets = rs.getTimestamp("u.dateTime");
                LocalDateTime date = datets.toLocalDateTime();
                String hostName = rs.getString("kd.fullName");
                String guestName = rs.getString("kg.fullName");
                String seasonName = rs.getString("s.naziv");
                Match newMatch = new Match(idMatch, fullName, date, hostName, guestName, seasonName);
                matches.add(newMatch);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matches;
    }

    public String getQRCodeString(SeasonCard selectedCard) {
        
        try {
            String query = "SELECT u.idDomacin, u.idSezona, u.idUtakmica FROM utakmica u WHERE u.idSezona IN (SELECT k.idSezona FROM karta k JOIN sezonskaKarta sk ON (k.idkarta = sk.idKarta) WHERE sk.idSezonskaKarta = ?) AND u.idDomacin IN (SELECT k.idKlub FROM karta k JOIN sezonskakarta sk ON (k.idkarta = sk.idKarta) WHERE sk.idSezonskaKarta = ?) AND u.dateTime in (SELECT MIN(dateTime) FROM utakmica u WHERE u.idDomacin IN (SELECT k.idklub FROM karta k JOIN sezonskakarta sk ON (k.idkarta = sk.idKarta) WHERE sk.idSezonskaKarta = ?) AND u.dateTime > NOW())";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, selectedCard.getIdSeasonCard());
            ps.setInt(2, selectedCard.getIdSeasonCard());
            ps.setInt(3, selectedCard.getIdSeasonCard());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String idDomacin = String.valueOf(rs.getInt("idDomacin"));
                String idSezona = String.valueOf(rs.getInt("idSezona"));
                String idUtakmica = String.valueOf(rs.getInt("idUtakmica"));
                
                String qrcode = String.valueOf(selectedCard.getIdSeasonCard())+";"+idDomacin+";"+idSezona+";"+idUtakmica;
                return qrcode;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public LocalDateTime getDateTimeOfLatestMatch(SeasonCard selectedCard) {
        
        try {
            String query = "SELECT u.dateTime FROM utakmica u WHERE u.idSezona IN (SELECT k.idSezona FROM karta k JOIN sezonskaKarta sk ON (k.idkarta = sk.idKarta) WHERE sk.idSezonskaKarta = ?) AND u.idDomacin IN (SELECT k.idKlub FROM karta k JOIN sezonskakarta sk ON (k.idkarta = sk.idKarta) WHERE sk.idSezonskaKarta = ?) AND u.dateTime in (SELECT MIN(dateTime) FROM utakmica u WHERE u.idDomacin IN (SELECT k.idklub FROM karta k JOIN sezonskakarta sk ON (k.idkarta = sk.idKarta) WHERE sk.idSezonskaKarta = ?) AND u.dateTime > NOW())";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, selectedCard.getIdSeasonCard());
            ps.setInt(2, selectedCard.getIdSeasonCard());
            ps.setInt(3, selectedCard.getIdSeasonCard());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Timestamp datets = rs.getTimestamp("u.dateTime");
                LocalDateTime date = datets.toLocalDateTime();
                return date;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setQRCode(String qrCodeString, SeasonCard selectedCard) {
        try {
            String query = "UPDATE sezonskakarta sk JOIN karta k ON sk.idKarta = k.idKarta SET sk.qrCode = ?, sk.idUtakmica = ? WHERE sk.idSezonskaKarta = ? AND (k.idKlub, k.idSezona) IN (SELECT t.idKlub, t.idSezona FROM (SELECT k.idKlub, k.idSezona FROM karta k JOIN sezonskakarta sk ON k.idKarta = sk.idKarta WHERE sk.idSezonskaKarta = ?) AS t)";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setString(1, qrCodeString);
            String[] codes = qrCodeString.split(";");
            ps.setInt(2, Integer.valueOf(codes[3]));
            ps.setInt(3, selectedCard.getIdSeasonCard());
            ps.setInt(4, selectedCard.getIdSeasonCard());
            int ra = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Fan getNewFan() {
        Fan fan = null;
        try {
            String query = "SELECT * FROM navijac WHERE idNavijac IN (SELECT MAX(idNavijac) FROM navijac)";
            Statement st = Konekcija.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                int idFan = rs.getInt("idNavijac");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String username = rs.getString("username");
                String email = rs.getString("email");
                Date birthdayDB = rs.getDate("birthday");
                LocalDate birthday = birthdayDB.toLocalDate();
                String phone = rs.getString("phone");
                String password = rs.getString("password");
                
                fan = new Fan(idFan, name, surname, username, email, birthday, phone, password);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fan;
    }

    public String getArenaName(int idHost) {

        try {
            String query = "SELECT naziv FROM hala WHERE idKlub = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, idHost);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String naziv = rs.getString("naziv");
                return naziv;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "N/A";
        
    }

    public int getIdHost(Match match) {
        
        try {
            String query = "SELECT idDomacin FROM utakmica WHERE idUtakmica = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, match.getIdMatch());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("idDomacin");
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
        
        
    }

    public int getNumberOfCardTypes() {
        int number = 0;
        try {
            String query = "SELECT COUNT(*) FROM tipkarte";
            Statement st = Konekcija.getInstance().getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                number = rs.getInt("COUNT(*)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return number;
    }

    public boolean getCorrectSeason(Club club, Season season, int numOfCardTypes) {
        
        Season s;
        int rows = 0;
        
        try {
            String query = "SELECT COUNT(*) FROM karta WHERE idKlub = ? AND idSezona = ?";
            PreparedStatement ps = Konekcija.getInstance().getCon().prepareStatement(query);
            ps.setInt(1, club.getIdKlub());
            ps.setInt(2, season.getIdSezona());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                rows = rs.getInt("COUNT(*)");
            }
            if(rows == numOfCardTypes){
                return true;
            }
            
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

   

}
