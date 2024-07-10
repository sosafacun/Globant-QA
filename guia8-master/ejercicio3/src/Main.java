import entities.Operation;
import services.OperationService;

public class Main {
    public static void main(String[] args) {

        OperationService opService = new OperationService();

        Operation operation1 = opService.createOperation();

        System.out.println("Add [int]: "+ opService.add(operation1));
        System.out.println("Subtract [int]: " + opService.subtract(operation1));
        System.out.println("Multiply [int]: " + opService.multiply(operation1));
        System.out.println("Divide [float]: " + opService.divide(operation1));
    }
}