package com.ist412.wallyland_vacation_planner.control;

import com.ist412.wallyland_vacation_planner.account.*;
import java.util.HashMap;

/**
 * Controller to handle creating user accounts in WallyLand.
 * 
 * @author Jason C. Nucciarone
 * @version 1.0
 * @since 2021-11-7
 */
public class SignUpController {
    private static SignUpController controllerInstance = null;
    
    private SignUpController() {}
    
    public static SignUpController getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new SignUpController();
        }
        
        return controllerInstance;
    }
    
    public void createAccount(String firstName, String lastName, String email, String userName, String password, String acctType) {
        HashMap<String, String> acctInfo = new HashMap<>();
        acctInfo.put("firstName", firstName);
        acctInfo.put("lastName", lastName);
        acctInfo.put("email", email);
        acctInfo.put("userName", email);
        acctInfo.put("password", password);
        
        Account acct = AccountFactory.newAccount(acctType, acctInfo);
        AccountList.push(acct);
    }
}
