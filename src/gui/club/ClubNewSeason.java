/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.club;

import controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Club;
import model.Season;
import java.util.List;
import javax.swing.JOptionPane;
import model.Card;

/**
 *
 * @author Ljubomir
 */
public class ClubNewSeason extends javax.swing.JFrame {

    //ODRADITI CELU FORMU
    Club club;
    List<Season> possibleSeasons;
    List<Season> possibleSeasonsForDefine;
    List<Season> seasonsForDefine;
    List<Season> allSeasons;
    Controller k = Controller.getInstance();
    int numOfCardTypes = 0;
    String currentSeason;

    List<Card> cards;

    /**
     * Creates new form ClubNewSeason
     */
    public ClubNewSeason(Club club) {
        initComponents();
        this.club = club;
        cards = new ArrayList<>();
        currentSeason = makeCurrentSeason();
        allSeasons = new ArrayList<>();
        allSeasons = k.getAllSeasons();
        possibleSeasons = new ArrayList<>();
        possibleSeasonsForDefine = new ArrayList<>();
        seasonsForDefine = new ArrayList<>();
        numOfCardTypes = k.getNumberOfCardTypes();
        possibleSeasons = k.getPossibleSeasons(club);
        for (int i = 0; i < possibleSeasons.size(); i++) {
            if (k.getCorrectSeason(club, possibleSeasons.get(i), numOfCardTypes)) {
                possibleSeasonsForDefine.add(possibleSeasons.get(i));
            }
        }
        for (Season s : possibleSeasonsForDefine) {
            jcbOldSeason.addItem(s);
        }
        for (int i = 0; i < allSeasons.size(); i++) {
            if (k.getAllSeasonsWithZeroCardDefined(club, allSeasons.get(i))) {
                if (!checkSeasons(allSeasons.get(i).getName(), currentSeason)) {
                    seasonsForDefine.add(allSeasons.get(i));
                }
            }
        }
        for (Season s : seasonsForDefine) {
            jcbNewSeason.addItem(s);
        }
        System.out.println(numOfCardTypes);
        TableModelDefineNewSeason tmdns = new TableModelDefineNewSeason(cards);
        jTableNewCards.setModel(tmdns);
        addListeners();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeMessage = new javax.swing.JTextField();
        btnGoBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbNewSeason = new javax.swing.JComboBox<>();
        jcbOldSeason = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jtxtSelectedSeason = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNewCards = new javax.swing.JTable();
        jbtnDefineNewSeason = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sport tickets shop | Define new season");
        setResizable(false);

        welcomeMessage.setEditable(false);
        welcomeMessage.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        welcomeMessage.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        welcomeMessage.setText("Define new season");
        welcomeMessage.setBorder(null);
        welcomeMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcomeMessageActionPerformed(evt);
            }
        });

        btnGoBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGoBack.setText("<");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Define season:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("like:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Season:");

        jtxtSelectedSeason.setEditable(false);
        jtxtSelectedSeason.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtSelectedSeason.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtSelectedSeason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtSelectedSeasonActionPerformed(evt);
            }
        });

        jTableNewCards.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableNewCards);

        jbtnDefineNewSeason.setText("Define new season");
        jbtnDefineNewSeason.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDefineNewSeasonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtSelectedSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(welcomeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbNewSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbOldSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtnDefineNewSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(welcomeMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbNewSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jcbOldSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtSelectedSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jbtnDefineNewSeason, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void welcomeMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcomeMessageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_welcomeMessageActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        ClubHomePage chp = new ClubHomePage(club);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void jtxtSelectedSeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSelectedSeasonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSelectedSeasonActionPerformed

    private void jbtnDefineNewSeasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDefineNewSeasonActionPerformed
        Season oldSeason = (Season) jcbOldSeason.getSelectedItem();
        Season selectedSeason = (Season) jcbNewSeason.getSelectedItem();
        cards = k.getAllCardsBySeason(club, oldSeason);
        if (oldSeason != null && selectedSeason != null) {
            if (k.setValuesForNewSeason(selectedSeason, cards, club)) {
                JOptionPane.showMessageDialog(rootPane, "New season is defined!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                ClubHomePage chp = new ClubHomePage(club);
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "You have to select all parameters", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnDefineNewSeasonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNewCards;
    private javax.swing.JButton jbtnDefineNewSeason;
    private javax.swing.JComboBox<Season> jcbNewSeason;
    private javax.swing.JComboBox<Season> jcbOldSeason;
    private javax.swing.JTextField jtxtSelectedSeason;
    private javax.swing.JTextField welcomeMessage;
    // End of variables declaration//GEN-END:variables

    private String makeCurrentSeason() {
        int currentYear = LocalDateTime.now().getYear();
        int currentMonth = LocalDateTime.now().getMonthValue();

        String season;

        if (currentMonth >= 9 && currentMonth <= 12) {
            season = String.valueOf(currentYear) + "/" + String.valueOf(currentYear + 1).substring(2);
            return season;
        } else if (currentMonth >= 1 && currentMonth <= 8) {
            season = String.valueOf(currentYear - 1) + "/" + String.valueOf(currentYear).substring(2);
            return season;
        }

        return null;
    }

    private boolean checkSeasons(String currentSeason, String seasonName) {
        String seasonCurr = currentSeason.substring(0, 4);
        String cardSeason = seasonName.substring(0, 4);
        int current = Integer.parseInt(seasonCurr);
        int card = Integer.parseInt(cardSeason);

        if (card <= current) {
            return false;
        }
        return true;
    }

    private void addListeners() {
        jcbNewSeason.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Season selectedSeason = (Season) jcbNewSeason.getSelectedItem();

                jtxtSelectedSeason.setText(selectedSeason.getName());
            }
        });

        jcbOldSeason.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Season oldSeason = (Season) jcbOldSeason.getSelectedItem();

                if (oldSeason != null) {
                    cards = k.getAllCardsBySeason(club, oldSeason);
                    refreshTable();
                }

            }

            private void refreshTable() {
                TableModelDefineNewSeason tmdns = (TableModelDefineNewSeason) jTableNewCards.getModel();
                tmdns.setCards(cards);
                tmdns.refreshDatas();
            }
        });
    }
}
