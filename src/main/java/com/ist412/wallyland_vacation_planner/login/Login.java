package com.ist412.wallyland_vacation_planner.login;

import com.ist412.wallyland_vacation_planner.account.*;
import java.util.ArrayList;

/**
 * Model class to manage the login.
 * 
 * @author Jason C. Nucciarone
 * @version 1.0
 * @since 2021-11-7
 */
public class Login {
    public static Account login(String email, String password) {
        ArrayList<Account> accts = AccountList.getAcctList();
        for (Account acct: accts) {
            if (acct.getEmail().equals(email) && acct.getPassword().equals(password)) {
                return acct;
            }
        }
        
        return null;
    }
}
