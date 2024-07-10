import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args)  {

        int day, month, year;

        Scanner read = new Scanner(System.in);

        System.out.println("in [int]: day");
        day = Integer.parseInt(read.nextLine());

        System.out.println("in [int]: month");
        month = Integer.parseInt(read.nextLine());

        System.out.println("in [int]: year");
        year = Integer.parseInt(read.nextLine());

        Date inDate = new Date(year, month, day);
        Date today = new Date();

        String sInDate = String.valueOf(inDate);
        String sToday = String.valueOf(today);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date simpleInDate = sdf.parse(sInDate);
        Date simpleToday = sdf.parse(sToday);


    }
}