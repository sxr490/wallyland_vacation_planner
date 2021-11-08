package com.ist412.wallyland_vacation_planner.control;

import com.ist412.wallyland_vacation_planner.account.*;
import com.ist412.wallyland_vacation_planner.login.Login;
import javax.swing.*;

/**
 * Controller class to handle user login at application start.
 * 
 * @author Jason C. Nucciarone
 * @version 1.0
 * @since 2021-11-7
 */
public class LoginController {
    private static LoginController controllerInstance = null;
    
    private Account currentUser = null;
    
    private LoginController() {}
    
    public static LoginController getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new LoginController();
        }
        
        return controllerInstance;
    }
    
    public void login(String email, String password, JLabel status) {
        Account acct = Login.login(email, password);
        
        if (acct != null) {
            currentUser = acct;
        } else {
            status.setText("Incorrect email or password.");
            status.setVisible(true);
        }
    }

    public Account getCurrentUser() {
        return currentUser;
    }
}
