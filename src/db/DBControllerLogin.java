/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package db;

/**
 *
 * @author Ljubomir
 */
public interface DBControllerLogin {
    
    boolean userExistsLogin(String usernameInput, String passwordInput);
    boolean ClubExistsLogin(String usernameInput, String passwordInput);
    
}
