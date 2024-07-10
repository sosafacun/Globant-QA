import entities.Circle;
import services.CircleService;

public class Main {
    public static void main(String[] args) {

        CircleService circleService = new CircleService();

        Circle circle1 = circleService.createCircle();

        circleService.calculateArea(circle1);
        circleService.calculatePerimeter(circle1);

    }
}