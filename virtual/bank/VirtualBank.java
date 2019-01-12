/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtual.bank;
import BankUser.Account;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random; // this is to create account number randomly for the user
/**
 *
 * @author Joel Mekonnen
 */
public class VirtualBank {

    /**
     * @param args the command line arguments
     */
     public static List<Account> A1 = new ArrayList<Account>(); // lets say the maximum account to create is a 100
     // Declare Scanners to be used in the following code, this are global scanner to be used anywhere in the code
     static Scanner Scan = new Scanner(System.in);
     static Scanner numScan = new Scanner(System.in);
    public static void main(String[] args) {
        // Welcome message in a loop
        boolean continity = true; // if this is set to false the application ends execution
        int i = 0;
        
        while(continity)
        {
            System.out.println("#--------------------------------------------");
            System.out.println("| Hello user welcome to our Virtual bank.......");
            System.out.println("| [C]reate new User............");
            System.out.println("| [L]ogin...........");
            System.out.println("| [E]xit............");
            System.out.println("#------------------------------------------------");
            System.out.print("Choice:");
            char choice = Scan.nextLine().charAt(0);
            // if user the inputs the following
            switch(choice)
            {
                case 'C':
                {
                   createAccount(i);
                   i++;
                   break;
                }
                case 'L':
                {
                    login();
                    break;
                }
                case 'E':
                {
                    continity =  false;
                    break;
                }
            }
        }  
    }
    public static void createAccount(int i)
    {
         Scanner Scan = new Scanner(System.in);
         Scanner numScan = new Scanner(System.in);
         Random rand = new Random();
         System.out.println("Ok lets create a new bank user.....");
         System.out.print("Insert user name:");
         String userName = Scan.nextLine();
         // this is to generate a random account number
         int r1 = rand.nextInt(800) + 100;
         int r2 = rand.nextInt(800) + 100;
         int r3 = rand.nextInt(800) + 100;
         // this is the new account generated
         String newAccount = "ETHB" + Integer.toString(r1) + Integer.toString(r2) + Integer.toString(r3); 
         System.out.println("your account number is:" + newAccount);
         System.out.println("please insert the initial balance:");
         int initBalance = numScan.nextInt();
         A1.add(new Account(userName, newAccount, initBalance)); 
         System.out.println("account Created successfuly.....");
        
    }
    public static void login()
    {
        System.out.println("please insert your account number:");
        String accountNum = Scan.nextLine();
        Account selectedAccount = new Account(); // this is to hold the account the user selects if it is found in the list
        boolean isFound = false;
        for(int i = 0; i < A1.size(); i++)
        {
            
            if(A1.get(i).getAccountNumber().equals(accountNum))
            {
                selectedAccount = A1.get(i);
                isFound = true;
            }
            else {
                isFound = false;
            }
        }
        if(isFound)
        {
            boolean continity = true;
            while(continity)
            {
            System.out.println("#---------------------------------------------------------------");
            System.out.println("| Hello " + selectedAccount.getAccountHolder() + " welcome......");
            System.out.println("| [S]how Status.........");
            System.out.println("| [D]eposit Money.......");
            System.out.println("| [W]ithdraw money......");
            System.out.println("| [T]ransfer money......");
            System.out.println("| [E]xit..............");
            System.out.println("#------------------------------------------------");
            System.out.print("Choose:");
            char choice = Scan.nextLine().charAt(0);
            switch(choice)
            {
                case 'S':
                {
                    System.out.println("#-------------------------------------------");
                    System.out.println("| User:" + selectedAccount.getAccountHolder());
                    System.out.println("| Account Number:" + selectedAccount.getAccountNumber());
                    System.out.println("| Balance:" + selectedAccount.getBalance());
                    System.out.println("#-------------------------------------------");
                    break;
                }
                case 'D':{
                    System.out.println("please insert deposit ammount:");
                    int deptAmmount = numScan.nextInt();
                    selectedAccount.deposit(deptAmmount);
                    break;
                }
                case 'W':
                {
                    System.out.print("Please insert ammount to withdraw:");
                    int withdrawAmmount = numScan.nextInt();
                    if(selectedAccount.withdraw(withdrawAmmount))
                    {
                        System.out.println("succesfully withdrawn money.......");
                    }          
                    break;
                }
                case 'T':
                {
                    break;
                }
                case 'E':
                {
                    continity = false;
                    break;
                }
            }
        }
        }
        else {
            System.out.println("Wrong account number inserted please try again......");
        }
    }
}
