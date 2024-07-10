import entities.Rectangle;
import services.RectangleService;

public class Main {
    public static void main(String[] args) {

        RectangleService recService = new RectangleService();

        Rectangle rectangle1 = recService.createRectangle();
        recService.drawRectangle(rectangle1);
        System.out.println("Area [int]: " + recService.area(rectangle1));
        System.out.println("Perimeter [int]: " + recService.perimeter(rectangle1));
    }
}