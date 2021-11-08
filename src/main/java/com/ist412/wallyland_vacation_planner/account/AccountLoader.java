package com.ist412.wallyland_vacation_planner.account;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * Class responsible for loading and saving user accounts.
 * 
 * @author Jason C. Nucciarone
 * @version 1.0
 * @since 2021-11-7
 */
public class AccountLoader {
    public static void save(ArrayList<Account> accts) {
        for (Account acct : accts) {
            try {
                String fileName = "assets/accounts/" + acct.getAccountID() + ".ser";
                File file = new File(fileName);
                if (file.isFile()) {file.delete();}
                file.createNewFile();
                FileOutputStream fout = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fout);
                out.writeObject(acct);
                out.close();
                fout.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static ArrayList<Account> load() {
        try {
            Path dir = Paths.get("assets/accounts");
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.ser");
            ArrayList<Account> acctList = new ArrayList<>();
            
            for (Path path : stream) {
                FileInputStream fin = new FileInputStream(path.toString());
                ObjectInputStream in = new ObjectInputStream(fin);
                acctList.add((Account) in.readObject());
                in.close();
                fin.close();
                path.toFile().delete();
            }
            
            return acctList;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
