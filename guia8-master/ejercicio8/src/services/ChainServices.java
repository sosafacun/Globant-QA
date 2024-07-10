package services;

import entities.Chain;

import java.util.Scanner;

public class ChainServices {
    Scanner READ = new Scanner(System.in);
    public Chain createChain(){
        Chain chain = new Chain();

        System.out.println("in [String]: phrase or word.");
        //chain.setChain(READ.nextLine());
        chain.setChain("The Quick Brown Fox Jumped over the lazy dog.");

        chain.setLongitude(chain.getChain().length());

        return chain;
    }
    public void chainOperations(Chain c){
        boolean exit = false;
        while (!exit){
            System.out.println("1 - showVocals");
            System.out.println("2 - invert");
            System.out.println("3 - repeated");
            System.out.println("4 - isLonger");
            System.out.println("5 - concatChains");
            System.out.println("6 - replace");
            System.out.println("7 - hasLetter");
            System.out.println("0 - exit");

            int opt = Integer.parseInt(READ.nextLine());

            switch (opt){
                case 1: showVocals(c);
                break;
                case 2: invert(c);
                break;
                case 3: repeated(c);
                break;
                case 4: isLonger(c);
                break;
                case 5: concatChains(c);
                    break;
                case 6: replace(c);
                    break;
                case 7: hasLetter(c);
                    break;
                case 0: exit = true;
                break;
                default:
                    System.out.println("Incorrect option, please try again.");
            }


        }
    }


    private void showVocals(Chain c){
        int vocalQuantity = 0;

        for (int i = 0; i < c.getLongitude(); i++){
            if (String.valueOf(c.getChain().charAt(i)).equalsIgnoreCase("A") ||
                String.valueOf(c.getChain().charAt(i)).equalsIgnoreCase("E") ||
                String.valueOf(c.getChain().charAt(i)).equalsIgnoreCase("I") ||
                String.valueOf(c.getChain().charAt(i)).equalsIgnoreCase("O") ||
                String.valueOf(c.getChain().charAt(i)).equalsIgnoreCase("U")){
                vocalQuantity ++;
            }
        }

        System.out.println("The phrase has "+ vocalQuantity + " vocals in it.");
    }
    private void invert(Chain c){

        String invertedChain = "";

        for(int i = (c.getLongitude() - 1); i >= 0; i--){
            String letter = String.valueOf(c.getChain().charAt(i));

            invertedChain = invertedChain.concat(letter);
        }

        System.out.println(invertedChain);
    }
    private void repeated(Chain c){

        int contLetter = 0;

        System.out.println("in [char]: search for a character");
        String letter = String.valueOf(READ.nextLine().charAt(0));

        for (int i = 0; i < c.getLongitude(); i++){
            if (String.valueOf(c.getChain().charAt(i)).equalsIgnoreCase(letter)){
                contLetter ++;
            }
        }
        System.out.println("The letter \"" + letter +"\" is "+ contLetter + " times in the phrase.");

    }
    private  void isLonger(Chain c){

        System.out.println("in [String]: second phrase");
        String secondChain = READ.nextLine();

        if(c.getLongitude() > secondChain.length()){
            System.out.println(c.getChain());
            System.out.println("IS LONGER THAN");
            System.out.println(secondChain);
        } else if (secondChain.length() > c.getLongitude()){
            System.out.println(secondChain);
            System.out.println("IS LONGER THAN");
            System.out.println(c.getChain());
        } else {
            System.out.println("Both phrases have the same amount of characters.");
        }
    }
    private void concatChains(Chain c){
        System.out.println("in [String]: phrase or word.");
        String secondChain = READ.nextLine();

        String newChain = "";

        newChain = newChain.concat(c.getChain());
        newChain = newChain.concat(secondChain);

        System.out.println(newChain);
    }
    private void replace(Chain c){
        String replacedChain = "";
        String j;

        System.out.println("int [Char]: letter to replace for");
        String letter = String.valueOf(READ.nextLine().charAt(0));

        for (int i = 0; i < c.getLongitude(); i++){
            j = String.valueOf(c.getChain().charAt(i));

            if(j.equalsIgnoreCase("a")){
                replacedChain = replacedChain.concat(letter);
            } else {
                replacedChain = replacedChain.concat(j);
            }
        }
        System.out.println("");
        System.out.println(replacedChain);
    }
    private void hasLetter(Chain c){
        String j;
        int letterCount = 0;

        System.out.println("int [Char]: letter to search for");
        String letter = String.valueOf(READ.nextLine().charAt(0));

        for (int i = 0; i < c.getLongitude(); i++){
            j = String.valueOf(c.getChain().charAt(i));

            if(j.equalsIgnoreCase(letter)){
                letterCount ++;
            }
        }
        System.out.println("The letter " + letter + " is "+letterCount+ " times in the phrase.");
    }
}
