package com.ist412.wallyland_vacation_planner.account;

import java.util.ArrayList;

/**
 * Class responsible for managing current users in the system. 
 * 
 * @author Jason C. Nucciarone
 * @version 1.0
 * @since 2021-11-7
 */
public class AccountList {
    private static ArrayList<Account> acctList = new ArrayList<>();
    
    public static void push(Account acct) {
        acctList.add(acct);
    }
    
    public static void pop(Account acct) {
        acctList.remove(acct);
    }

    public static ArrayList<Account> getAcctList() {
        return acctList;
    }

    public static void setAcctList(ArrayList<Account> acctList) {
        AccountList.acctList = acctList;
    }
}
