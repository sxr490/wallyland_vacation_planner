package com.ist412.wallyland_vacation_planner.account;

import java.util.HashMap;

/**
 * Interface to provide common interaction with all the Account classes.
 * 
 * @author Jason C. Nucciarone
 * @version 1.0
 * @since 2021-10-24
 */
public interface Account {
    // Getter methods for retrieving information
    int getAccountID();
    
    String getFirstName();
    
    String getLastName();
    
    String getEmail();
    
    String getUserName();
    
    String getAccountType();
    
    HashMap<String, Object> getAccountInfo();
    
    Object getAccountInfoByKey(String key);
    
    String getPassword();
    
    // Setter methods for defaulting to new information
    void setAccountID(int newID);
    
    void setFirstName(String newFirstName);
    
    void setLastName(String newLastName);
    
    void setEmail(String newEmail);
    
    void setUserName(String newUserName);
    
    void setAccountType(String newType);
    
    void setPassword(String newPassword);
    
    void pushAccountInfo(String newKey, Object newValue);
    
    void popAccountInfo(String oldKey);
}
