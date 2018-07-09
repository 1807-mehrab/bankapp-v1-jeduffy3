/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revature.account;

import java.util.Scanner;

/**
 *
 * @author James
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean keepGoing = false;
        
        System.out.println("Please enter the checking balance:");
        String checkingBalanceString = sc.nextLine().trim();
        double checkingBalance = Double.parseDouble(checkingBalanceString);
        Account checkingAccount1 = new CheckingAccount(checkingBalance);

        System.out.println("\nPlease enter the savings balance:");
        String savingsBalanceString = sc.nextLine().trim();
        double savingsBalance = Double.parseDouble(savingsBalanceString);
        Account savingsAccount1 = new SavingsAccount(savingsBalance);
        
        do {
            System.out.println("\nPlease select a number associated with an account:");
            System.out.println("\t1 = Checking Account");
            System.out.println("\t2 = Savings Account");
            String accountSelectionString = sc.nextLine().trim();
            int accountSelection = Integer.parseInt(accountSelectionString);

            switch (accountSelection) {
                case 1:
                    System.out.println("\nThe starting checking balance is $"
                            + checkingAccount1.getBalance());
                    System.out.println("\nPlease select a number associated with a transaction:");
                    System.out.println("\t1 = Deposit");
                    System.out.println("\t2 = Withdraw");
                    System.out.println("\t3 = Transfer");
                    String transactionSelectionString = sc.nextLine().trim();
                    int transactionSelection = Integer.parseInt(transactionSelectionString);
                    switch (transactionSelection) {
                        case 1:
                            System.out.println("\nPlease enter the amount you wish to deposit:");
                            String checkingDepositString = sc.nextLine().trim();
                            double checkingDeposit = Double.parseDouble(checkingDepositString);
                            checkingAccount1.deposit(checkingDeposit);
                            System.out.println("\nAfter a deposit of $"
                                    + checkingDeposit
                                    + ", the checking balance is $"
                                    + checkingAccount1.getBalance());
                            break;
                        case 2:
                            System.out.println("\nPlease enter the amount you wish to withdraw:");
                            String checkingWithdrawString = sc.nextLine().trim();
                            double checkingWithdraw = Double.parseDouble(checkingWithdrawString);
                            checkingAccount1.withdraw(checkingWithdraw);
                            System.out.println("\nAfter a withdraw of $"
                                    + checkingWithdraw
                                    + ", the checking balance is $"
                                    + checkingAccount1.getBalance());
                            break;
                        case 3:
                            System.out.println("\nPlease enter the amount you wish to transfer:");
                            String checkingTransferString = sc.nextLine().trim();
                            double checkingTransfer = Double.parseDouble(checkingTransferString);
                            checkingAccount1.transfer(savingsAccount1, checkingTransfer);
                            System.out.println("\nAfter a withdraw of $"
                                    + checkingTransfer
                                    + ", the checking balance is $"
                                    + checkingAccount1.getBalance()
                                    + " and the savings balance is $"
                                    + savingsAccount1.getBalance());
                            break;
                        default:
                            System.out.println("\nPlease enter a number from the above selections");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\nThe starting savings balance is $"
                            + savingsAccount1.getBalance());
                    System.out.println("\nPlease select a number associated with a transaction:");
                    System.out.println("\t1 = Deposit");
                    System.out.println("\t2 = Withdraw");
                    System.out.println("\t3 = Transfer");
                    String transSelectionString = sc.nextLine().trim();
                    int transSelection = Integer.parseInt(transSelectionString);
                    switch (transSelection) {
                        case 1:
                            System.out.println("\nPlease enter the amount you wish to deposit:");
                            String savingsDepositString = sc.nextLine().trim();
                            double savingsDeposit = Double.parseDouble(savingsDepositString);
                            savingsAccount1.deposit(savingsDeposit);
                            System.out.println("\nAfter a deposit of $"
                                    + savingsDeposit
                                    + ", the savings balance is $"
                                    + savingsAccount1.getBalance());
                            break;
                        case 2:
                            System.out.println("\nPlease enter the amount you wish to withdraw:");
                            String savingsWithdrawString = sc.nextLine().trim();
                            double savingsWithdraw = Double.parseDouble(savingsWithdrawString);
                            savingsAccount1.withdraw(savingsWithdraw);
                            System.out.println("\nAfter a withdraw of $"
                                    + savingsWithdraw
                                    + ", the savings balance is $"
                                    + savingsAccount1.getBalance());
                            break;
                        case 3:
                            System.out.println("\nPlease enter the amount you wish to transfer:");
                            String savingsTransferString = sc.nextLine().trim();
                            double savingsTransfer = Double.parseDouble(savingsTransferString);
                            savingsAccount1.transfer(checkingAccount1, savingsTransfer);
                            System.out.println("\nAfter a transfer of $"
                                    + savingsTransfer
                                    + ", the savings balance is $"
                                    + savingsAccount1.getBalance()
                                    + " and the checking balance is $"
                                    + checkingAccount1.getBalance());
                            break;
                        default:
                            System.out.println("\nPlease enter a number from the above selections");
                            break;
                    }
                    break;
                default:
                    System.out.println("\nPlease enter a number from the above selections");
                    break;
            }
            System.out.println("\nDo you wish to continue?");
            System.out.println("1 = Yes");
            System.out.println("2 = No");
            String inputString = sc.nextLine().trim();
            int input = Integer.parseInt(inputString);
            switch (input) {
                case 1:
                    keepGoing = true;
                    break;
                case 2:
                    keepGoing = false;
                    break;
                default:
                    System.out.println("\nPlease enter a number from the above selections");
                    break;
            }
        } while (keepGoing);
    }
}
