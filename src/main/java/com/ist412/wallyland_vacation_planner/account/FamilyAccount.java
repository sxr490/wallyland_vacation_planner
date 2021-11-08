package com.ist412.wallyland_vacation_planner.account;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Account class for the head of a family unit.
 * 
 * @author Jason C. Nucciarone
 * @version 1.1
 * @since 2021-11-3
 */
public class FamilyAccount implements Account, Serializable {
    private int accountID;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String accountType = "family";
    private String password;
    private HashMap<String, Object> accountInfo = new HashMap<>();

    public FamilyAccount(int accountID, String firstName, String lastName, String email, String userName, String password) {
        this.accountID = accountID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
    
    @Override
    public int getAccountID() {
        return accountID;
    }

    @Override
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String getUserName() {
        return userName;
    }
    
    @Override
    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    @Override
    public String getAccountType() {
        return accountType;
    }

    @Override
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public HashMap<String, Object> getAccountInfo() {
        return accountInfo;
    }
    
    @Override 
    public Object getAccountInfoByKey(String key) {
        return new Object();
    }
    
    @Override
    public void pushAccountInfo(String newKey, Object newValue){  
    }
    
    @Override
    public void popAccountInfo(String oldKey) {
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}