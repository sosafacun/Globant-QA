import entities.Mathematics;
import services.MathematicsServices;

public class Main {
    public static void main(String[] args) {
        MathematicsServices mServices = new MathematicsServices();

        Mathematics m1 = mServices.createMath();

        System.out.println(m1.getNum1());
        System.out.println(m1.getNum2());
        System.out.println("************************");
        System.out.println( mServices.isBigger(m1)+ " is the larger number.");
        System.out.println("The largest number powered by the smallest one is:" + mServices.powerOf(m1));
        System.out.println("The square root of the smallest number is: " + mServices.squareRoot(m1));
    }
}