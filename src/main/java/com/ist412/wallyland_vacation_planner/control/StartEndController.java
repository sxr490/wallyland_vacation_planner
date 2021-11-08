package com.ist412.wallyland_vacation_planner.control;

import com.ist412.wallyland_vacation_planner.account.*;
import java.util.ArrayList;

/**
 * Class that controls the start-up and shutdown of WallyLand Vacation Planner.
 * 
 * @author Jason C. Nucciarone
 * @version 1.0
 * @since 2021-11-5
 */
public class StartEndController {
    private static StartEndController controllerInstance = null;
    
    private StartEndController() {}
    
    public static StartEndController getInstance() {
        if (controllerInstance == null) {
            controllerInstance = new StartEndController();
        }
        
        return controllerInstance;
    }
    
    public void loadAccounts() {
        ArrayList<Account> accts = AccountLoader.load();
        if (accts != null) {AccountList.setAcctList(accts);}
    }
    
    public void saveAccounts() {
        if (AccountList.getAcctList() != null) {
            AccountLoader.save(AccountList.getAcctList());
        }
    }
}
