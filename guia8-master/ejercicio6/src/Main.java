import entity.CoffeeMachine;
import service.CoffeeMachineService;

public class Main {
    public static void main(String[] args) {
        CoffeeMachineService cmService = new CoffeeMachineService();

        CoffeeMachine cm1 = cmService.createCoffeeMachine();

        cmService.serveCoffee(cm1);
        cmService.makeCoffee(cm1);
        cmService.emptyCoffeeMachine(cm1);
        cmService.makeCoffee(cm1);
        cmService.serveCoffee(cm1);
        cmService.serveCoffee(cm1);
        cmService.serveCoffee(cm1);
    }
}