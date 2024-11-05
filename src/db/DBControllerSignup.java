/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package db;

import classes.Fan;

/**
 *
 * @author Ljubomir
 */
public interface DBControllerSignup {
    
    void addNewNavijac(Fan novi);
    boolean userWithThatUsernameExists(String usernameInput);
}
