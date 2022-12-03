package com.sm2048.Accounts;

import java.util.ArrayList;
import java.util.Scanner;

/**
*I
*/
public class Account implements Comparable<Account> {
    private long score = 0;
    private String userName ;

    /**
    *Creates a ArrayList to store accounts
    */
    public static ArrayList<Account> accounts = new ArrayList<>();

    /**
     *Creates a ArrayList to
     */
    public Account(String userName){
        this.userName=userName;
    }

    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    /**
    *
    *This method is used for modify score by adding
    *
    *@param score this, is used to access the private score in this class
    */
    public void addToScore(long score) {
        this.score += score;
    }

    private long getScore() {
        return score;
    }

    public String getUserName() {
        return userName;
    }

    static Account accountHaveBeenExist(String userName){
        for(Account account : accounts){
            if(account.getUserName().equals(userName)){
                return account;
            }
        }
        return null;

    }

    static Account makeNewAccount(String userName){
        Account account = new Account(userName);
        accounts.add(account);
        return account;
    }

}
