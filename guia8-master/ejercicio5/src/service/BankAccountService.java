package service;
import entity.BankAccount;
import java.util.Scanner;

public class BankAccountService {

    public BankAccount createBankAccount(){
        BankAccount ba = new BankAccount();
        Scanner read = new Scanner(System.in);

        System.out.println("in [int]: Account Number");
        ba.setAccountNumber(Integer.parseInt(read.nextLine()));

        System.out.println("in [int]: Client ID");
        ba.setClientID(Integer.parseInt(read.nextLine()));

        System.out.println("in [String]: Client Name");
        String name = read.nextLine();
        ba.setClientName(name);

        ba.setCurrentBalance(0);
        return ba;
    }
    public void balanceOperation (BankAccount ba){
        Scanner read = new Scanner(System.in);
        int opt;
        boolean exit = false;

        while (!exit){
            logo();
            System.out.println("1 - Deposit");
            System.out.println("2 - Pay for service");
            System.out.println("3 - Quick extraction");
            System.out.println("4 - Check balance");
            System.out.println("5 - View personal details");
            System.out.println("0 - exit");
            opt = Integer.parseInt(read.nextLine());

            switch (opt) {
                case 1 -> depositMoney(ba);
                case 2 -> payServices(ba);
                case 3 -> quickExtraction(ba);
                case 4 -> showBankAccountBalance(ba);
                case 5 -> showBankAccountDetails(ba);
                case 0 -> exit = true;
                default -> System.out.println("Incorrect option. Please, try again.");
            }

        }
    }
    private void showBankAccountDetails(BankAccount ba){
        logo();
        System.out.println("Client's name: " + ba.getClientName());
        System.out.println("--------------------------");
        System.out.println("Client's ID: " + ba.getClientID());
        System.out.println("--------------------------");
        System.out.println("Bank Account's number: " + ba.getAccountNumber());
        System.out.println("==========================");
        keyContinue();
    }
    private void showBankAccountBalance(BankAccount ba){
        logo();
        System.out.println("==Total Money in Account==");
        System.out.println("==========================");
        System.out.println("==== $" + ba.getCurrentBalance() + "====");
        System.out.println("==========================");
        keyContinue();
    }
    private void quickExtraction (BankAccount ba){
        Scanner read = new Scanner(System.in);

        double extractionLimit;
        double extraction;

        extractionLimit = ba.getCurrentBalance() * 0.2;
            logo();
            System.out.println("=====QUICK EXTRACTION=====");
            System.out.println("");
            System.out.println("You can extract up to: $" + extractionLimit + ".");
            System.out.println("");
            System.out.println("How much do you wish to extract?");
            extraction = Double.parseDouble(read.nextLine());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (extraction < extractionLimit){
                System.out.println("=> Previous Balance: $" + ba.getCurrentBalance() +".");
                System.out.println("=> Extracted: $"+ extraction +".");
                double unconfirmedBalance = ba.getCurrentBalance() - extraction;
                System.out.println("=> New Balance: $" + unconfirmedBalance + ".");
                System.out.println("---- Confirm extraction? ----");
                System.out.println("Y - Yes ////////////// N - No");
                String opt = read.nextLine();

                if (opt.equalsIgnoreCase("y")){
                    ba.setCurrentBalance(unconfirmedBalance);
                    logo();
                    System.out.println("Extraction successful!");
                    keyContinue();
                } else if (opt.equalsIgnoreCase("n")){
                    logo();
                    System.out.println("Operation cancelled.");
                    keyContinue();
                } else {
                    logo();
                    System.out.println("Incorrect option");
                    keyContinue();
                }

            }
             else {
                 logo();
                System.out.println("Incorrect amount. Please, try again.");
            }
    }
    private void payServices (BankAccount ba){
        Scanner read = new Scanner(System.in);

        logo();
        System.out.println("How much would you like to pay?");
        double payment = Double.parseDouble(read.nextLine());

        System.out.println("------ Confirm payment? -----");
        System.out.println("Y - Yes ////////////// N - No");
        String opt = read.nextLine();

        if (opt.equalsIgnoreCase("y") &&
            ba.getCurrentBalance() > payment){

            ba.setCurrentBalance(ba.getCurrentBalance() - payment);
            logo();
            System.out.println("Extraction successful!");
            keyContinue();

        } else if (opt.equalsIgnoreCase("n")){
            logo();
            System.out.println("Operation cancelled.");
            keyContinue();
        } else if (opt.equalsIgnoreCase("y") &&
                   ba.getCurrentBalance() < payment){

            logo();
            System.out.println("Insufficient Founds!");
            keyContinue();
        }

    }
    private void depositMoney (BankAccount ba){
        Scanner read = new Scanner(System.in);
        logo();
        System.out.println("--How much will you deposit?-");
        double deposit = Double.parseDouble(read.nextLine());
        System.out.println("------ Confirm payment? -----");
        System.out.println("Y - Yes ////////////// N - No");
        String opt = read.nextLine();

        if (opt.equalsIgnoreCase("y")){
            ba.setCurrentBalance(ba.getCurrentBalance() + deposit);
            System.out.println("Deposit successful!");
            keyContinue();
        }
        else if (opt.equalsIgnoreCase("n")) {
            System.out.println("Deposit cancelled!");
            keyContinue();
        } else {
            System.out.println("Incorrect Option. Please, try again!");
            keyContinue();
        }
    }
    private void logo(){
        System.out.flush();
        System.out.println("==========================");
        System.out.println("=======Bank of Kiwis======");
        System.out.println("==========================");
        System.out.println("");
    }
    private void keyContinue(){
        System.out.println("Press enter to continue...");
        Scanner read = new Scanner(System.in);
        String pressToContinue = read.nextLine();
    }
}