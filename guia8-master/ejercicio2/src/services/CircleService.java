package services;

import entities.Circle;
import java.util.Scanner;

public class CircleService {

    public Circle createCircle(){
        Scanner read = new Scanner(System.in);
        Circle circle = new Circle();

        System.out.println("in: [float] Radius: ");
        circle.setRadius(read.nextFloat());

        return circle;
    }

    public void calculateArea(Circle circle){
        float area;

        area = (float) (Math.PI * (circle.getRadius()*circle.getRadius()));

        System.out.println("Area (float): " + area);
    }

    public void calculatePerimeter(Circle circle){
        float perimeter;

        perimeter = (float)(2*Math.PI*circle.getRadius());

        System.out.println("Perimeter (float): " + perimeter);
    }
}
