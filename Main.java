package com.sayantandas;

import java.util.Scanner;

public class Main {
    /**
     * You job is to create a simple banking application.
     * There should be a Bank class.
     * It should have an arraylist of Branches.
     * Each Branch should have an arraylist of Customers.
     * The Customer class should have an arraylist of Doubles (transactions)
     * Customer:
     * Name, and the ArrayList of doubles.
     * Branch:
     * Need to be able to add a new customer and initial transaction amount.
     * Also needs to add additional transactions for that customer/branch
     * Bank:
     * Add a new branch
     * Add a customer to that branch with initial transaction
     * Add a transaction for an existing customer for that branch
     * Show a list of customers for a particular branch and optionally a list of their transactions
     * Demonstration autoboxing and unboxing in your code
     * Hint: Transactions
     * Add data validation. e.g. check if exists, or does not exist, etc.
     * Think about where you are adding the code to perform certain actions.
     */

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank;

    public static void main(String[] args) {

        boolean quit = false;
        startApplication();
        printActions();
        while (!quit) {
            System.out.println("\nEnter Action : (6 to show the available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) { 
                
                case 0 :
                    System.out.println("\nShutting Down...");
                    quit = true;
                    break;
                    
                case 1 :
                    bankname();
                    break;

                case 2 :
                    branchname();
                    break;

                case 3 :
                    customername();
                    break;

                case 4 :
                    customertransactions();
                    break;

                case 5 :
                    listcustomers();
                    break;
                    
                case 6 :
                    printActions();
                    break;

                default :
                    System.out.println("\nInvalid Option.");
                    break;
            }
        }
    }

    private static void listcustomers() {

        System.out.println("\nEnter the Branch's Name - ");
        String branchName = scanner.nextLine();
        System.out.println("\nEnter 'true' if you want to print the list of customer's transactions too & 'false' if you do not want to print the list of customer's transactions  - ");
        boolean transactionprint = scanner.nextBoolean();
        bank.listCustomers(branchName,transactionprint);

    }


    private static void customertransactions() {

        System.out.println("\nEnter the Branch's Name - ");
        String branchName = scanner.nextLine();
        System.out.println("\nEnter the Customer's Name - ");
        String customerName = scanner.nextLine();
        System.out.println("\nEnter the Transaction Amount - ");
        double amount = scanner.nextDouble();
        bank.addCustomerTransactions(branchName,customerName,amount);

    }

    private static void customername() {

        System.out.println("\nEnter the Branch's Name - ");
        String branchName = scanner.nextLine();
        System.out.println("\nEnter the Customer's Name - ");
        String customerName = scanner.nextLine();
        System.out.println("\nEnter the Initial Opening Amount - ");
        double amount = scanner.nextDouble();
        bank.addCustomer(branchName,customerName,amount);
    }

    private static void branchname() {

        System.out.println("\nEnter the Branch's Name - ");
        String branchName = scanner.nextLine();
        bank.addBranch(branchName);
        System.out.println("Branch - "+branchName+" , is now Registered to be Used.");

    }

    private static void bankname() {

        System.out.println("\nEnter the Bank's Name - ");
        String bankName = scanner.nextLine();
        bank=new Bank(bankName);
        System.out.println("Bank - "+bankName+" , is now Registered to be Used.");

    }

    private static void startApplication(){

        System.out.println("Starting the Application...");

    }

    private static void printActions(){

        System.out.println("\nAvailable Actions : \nPress - \n");
        System.out.println("0. To ShutDown.");
        System.out.println("1. To Add the Bank Name.");
        System.out.println("2. To Add the Bank's Branch.");
        System.out.println("3. To Add a Customer to the Bank's Branch.");
        System.out.println("4. To Add a Customer's Transactions asssociated with the Bank's Branch.");
        System.out.println("5. To Print the List of Customers of a Bank's Branch with or without their transactions.");
        System.out.println("6. To Print the List of available Actions.");
        System.out.println("\n Enter Your Choice Below - ");

    }
}
