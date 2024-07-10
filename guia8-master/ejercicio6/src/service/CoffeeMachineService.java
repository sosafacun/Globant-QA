package service;

import entity.CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachineService {
    public CoffeeMachine createCoffeeMachine(){

        CoffeeMachine cm = new CoffeeMachine();
        cm.setMaxCapacity(100);
        cm.setCurrentCapacity(0);

        return cm;
    }
    public void makeCoffee(CoffeeMachine cm){
        System.out.println("Making coffee...");
        for (int i = cm.getCurrentCapacity(); i < cm.getMaxCapacity() ; i++){
            System.out.println((cm.getCurrentCapacity()) + "ml.");
            waitASec(0);
            cm.setCurrentCapacity(cm.getCurrentCapacity() + 1);
        }
        System.out.println("Finished making coffee!");
        System.out.println("Coffee Machine at "+ cm.getCurrentCapacity() + "ml. of " + cm.getMaxCapacity()+"ml.");
        keyWait();
    }
    public void serveCoffee(CoffeeMachine cm){
        Scanner read = new Scanner(System.in);

        System.out.println("How much coffee does the cup hold?");
        int cupCapacity = Integer.parseInt(read.nextLine());

        System.out.println("Serving coffee...");
        if(cm.getCurrentCapacity() > cupCapacity){
            cm.setCurrentCapacity(cm.getCurrentCapacity() - cupCapacity);
            System.out.println("Coffee's been served!");
            keyWait();
        }
        else if (cm.getCurrentCapacity() < cupCapacity &&
        cm.getCurrentCapacity() != 0) {

            int missing;

            missing = cupCapacity - cm.getCurrentCapacity();
            cm.setCurrentCapacity(0);

            System.out.println("There wasn't enough coffee to fill the cup!");
            System.out.println("There's " +missing + "ml. missing in the cup");
            System.out.println("The Coffee Machine is empty. Please, make new coffee.");
            keyWait();
        } else {
            System.out.println("The coffee machine is EMPTY!");
            System.out.println("Please, make new coffee.");
            keyWait();
        }
    }
    public void emptyCoffeeMachine(CoffeeMachine cm){
        System.out.println("Emptying the coffee machine...");
        cm.setCurrentCapacity(0);
        System.out.println("The coffee machine's been emptied");
        keyWait();
    }
    private void keyWait(){
        Scanner read = new Scanner(System.in);
        String contString = read.nextLine();
    }
    private void waitASec(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
