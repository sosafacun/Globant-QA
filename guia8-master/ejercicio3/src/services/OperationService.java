package services;

import entities.Operation;

import java.util.Scanner;

public class OperationService {
    public Operation createOperation(){

        Operation operation = new Operation();
        Scanner read = new Scanner(System.in);

        System.out.println("in: [int] number1");
        operation.setNumber1(read.nextInt());
        System.out.println("in: [int] number2");
        operation.setNumber2(read.nextInt());

        return operation;
    }

    public int add (Operation n){
        int result;

        result = n.getNumber1()+n.getNumber2();

        return result;
    }
    public int subtract (Operation n){
        int result;

        result = n.getNumber1()-n.getNumber2();

        return result;
    }
    public int multiply (Operation n){
        int result;

        result = n.getNumber1()*n.getNumber2();

        return result;
    }
    public float divide (Operation n){
        float result;

        result = n.getNumber1()/n.getNumber2();

        return result;
    }
}
