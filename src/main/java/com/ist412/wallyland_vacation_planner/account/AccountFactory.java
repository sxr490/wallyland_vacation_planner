package com.ist412.wallyland_vacation_planner.account;

import java.util.HashMap;
import java.util.Random;

/**
 * Factory class to create new type of Account based on inputted information
 * by the user when they go to create their new account. 
 * 
 * @author Jason C. Nucciarone
 * @version 1.1
 * @since 2021-10-24
 */
public class AccountFactory {
    private static int accountCounter = 0;
    
    public static Account newAccount(String accountType, HashMap<String, String> accountSettings) {
        if (accountType == null) {
            return null;
        } else {
            accountCounter += 1;
            switch (accountType) {
                case "personal":
                    return new PersonalAccount(
                        accountCounter,
                        accountSettings.get("firstName"),
                        accountSettings.get("lastName"),
                        accountSettings.get("email"),
                        accountSettings.get("userName"),
                        accountSettings.get("password")
                    );
                
                case "corporate":
                    return new CorporateAccount(
                        accountCounter,
                        accountSettings.get("firstName"),
                        accountSettings.get("lastName"),
                        accountSettings.get("email"),
                        accountSettings.get("userName"),
                        accountSettings.get("password")
                    );
                    
                case "family":
                    return new FamilyAccount(
                        accountCounter,
                        accountSettings.get("firstName"),
                        accountSettings.get("lastName"),
                        accountSettings.get("email"),
                        accountSettings.get("userName"),
                        accountSettings.get("password")
                    );
                    
                default:
                    return null;
            }
        }
    }

    public static void setAccountCounter(int accountCounter) {
        AccountFactory.accountCounter = accountCounter;
    }
}
