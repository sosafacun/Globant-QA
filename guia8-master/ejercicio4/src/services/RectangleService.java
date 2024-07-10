package services;

import entities.Rectangle;

import java.util.Scanner;

public class RectangleService {

    public Rectangle createRectangle(){

        Rectangle r = new Rectangle();
        Scanner read = new Scanner(System.in);

        System.out.println("in: [int] width => ");
        r.setWidth(read.nextInt());
        System.out.println("in: [int] length => ");
        r.setLength(read.nextInt());

        return r;
    }

    public int area(Rectangle r){
        int area;
        area = r.getWidth() * r.getLength();
        return area;
    }

    public int perimeter (Rectangle r){
        int perimeter;
        perimeter = (r.getWidth() + r.getLength())*2;
        return perimeter;
    }

    public void drawRectangle(Rectangle r){

        System.out.println("");

        for(int i = 0; i < r.getLength(); i++){
            for(int j = 0; j < r.getWidth(); j++){
                if (i == 0 || i == r.getLength()-1){
                    System.out.print("*  ");
                } else if (j == 0 || j == r.getWidth()-1){
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
    }

}
