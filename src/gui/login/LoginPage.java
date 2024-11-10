/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.login;


import classes.Fan;
import gui.club.ClubHomePage;
import gui.fan.FanHomePage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import db.DBControllerLogin;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
/**
 *
 * @author Ljubomir
 */
public class LoginPage extends javax.swing.JFrame implements DBControllerLogin{
    
    Fan fan = new Fan("", "", "", "", LocalDate.MIN, "", "");
    
    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        initComponents();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public LoginPage(Fan fan){
        initComponents();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        this.fan = fan;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inpUsername = new javax.swing.JTextField();
        inpPassword = new javax.swing.JPasswordField();
        btnGoBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sport tickets shop | Login");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        loginBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Password:");

        inpUsername.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        inpUsername.setToolTipText("");
        inpUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpUsernameActionPerformed(evt);
            }
        });

        inpPassword.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btnGoBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGoBack.setText("<");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inpPassword))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inpUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(inpPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inpUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpUsernameActionPerformed

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        StartPage sp = new StartPage();
        sp.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        String inputUsername = inpUsername.getText();
        char[] pass = inpPassword.getPassword();
        String inputPassword = new String(pass);
        
        if(userExistsLogin(inputUsername, inputPassword)){
            fillVariables(inputUsername);
            FanHomePage hp = new FanHomePage(fan);
            dispose();
        }else if(ClubExistsLogin(inputUsername, inputPassword)){
            ClubHomePage chp = new ClubHomePage();
            dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Incorrect datas", "Error", JOptionPane.ERROR_MESSAGE);
            inpUsername.setText("");
            inpPassword.setText("");
        } 
    }//GEN-LAST:event_loginBtnActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JPasswordField inpPassword;
    private javax.swing.JTextField inpUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean userExistsLogin(String usernameInput, String passwordInput) {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosoft", "root", "root");
            System.out.println("Uspesno povezano sa bazom");
            
            PreparedStatement ps = con.prepareStatement("SELECT username, password FROM navijac");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                if (usernameInput.equals(username) && passwordInput.equals(password)) {
                    return true;
		}
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean ClubExistsLogin(String usernameInput, String passwordInput) {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosoft", "root", "root");
            System.out.println("Uspesno povezano sa bazom");
            
            PreparedStatement ps = con.prepareStatement("SELECT username, password FROM klub");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                if (usernameInput.equals(username) && passwordInput.equals(password)) {
                    return true;
		}
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public void fillVariables(String username){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosoft", "root", "root");
            System.out.println("Uspesno povezano sa bazom");
            
            String query = "SELECT * FROM navijac WHERE username = \"" + username + "\""; 
            System.out.println(query);
            
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
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
                System.out.println("id:" + fan.getIdNavijac() + " name:" + fan.getName() + "surname:" + fan.getSurname() + "username:" + username);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

