/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankUser;

/**
 *
 * @author Joel Mekonnen
 */
public class Account {
    private String accountHolder; // this is the name of the account holder
    private String accountNumber; // this is the account of number
    private int balance; // this is the balance of the user
    private static int totalBalance = 0;
    public Account(String accountHolder, String accountNumber, int balance)
    {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance; // the balance of the user
        // total balance that is in the bank
        totalBalance += balance;
    }
    // the default constructor in case we need it
    public Account()
    {
        
    }
    // lets Create the getters Methods to Get the properties
    public String getAccountHolder() {
        return accountHolder;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
    // lets Create the Setter meethods to set the properies
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    /*
        the next method is used to deposit balance into the account 
    */
    public int deposit(int depositAmount)
    {
        this.balance += depositAmount;
        return this.balance;
    }
    /*
          the next method is going to transfer Money from one account to another
    */
    public int transfer(String accountNumber, int transferAmmount)
    {
        this.balance -= transferAmmount;
        return this.balance;
    }
    public static int getTotalBalance()
    {
        return totalBalance;
    }
    public boolean withdraw(int ammount)
    {
        if(this.balance > ammount)
        {
            this.balance -= ammount;
            return true;
        }
        else {
            System.out.println("Insufficient ammount........");
            return false;
        }
        }
            
  }

