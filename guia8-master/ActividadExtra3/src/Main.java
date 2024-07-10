import java.util.ArrayList;
import java.util.Scanner;

import entities.Client;
import entities.Routine;
import services.ClientService;
import services.RoutineService;


/*TODO (high):
   - ID validation for everything
        -When creating a new client and selecting a routine
        -When selecting who to update
        -When selecting who to delete
        -When selecting to which routine to update
        -When selecting routine to update
        -When selecting routine to delete
   - A timer or a key press to continue in order to show everyone when a list in too long.*/
public class Main {
    static ArrayList<Client> clientList = new ArrayList<>();
    static ArrayList<Routine> routineList = new ArrayList<>();
    static ClientService cService = new ClientService();
    static RoutineService rService = new RoutineService();
    static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {
        routineList = rService.loadRoutines(routineList);
        clientList = cService.loadClients(clientList, routineList);
        mainMenu();
    }
    public static void mainMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an operation");
            System.out.println("1 - See or add client details");
            System.out.println("2 - See or add routine details");
            System.out.println("0 - Exit");

            int opt = Integer.parseInt(read.nextLine());

            switch (opt) {
                case 1 -> clientMenu();
                case 2 -> routineMenu();
                case 0 -> exit = true;
                default -> System.out.println("Wrong option, please, try again.");
            }
        }
    }
    public static void clientMenu(){
        int opt = 1;
        while(opt != 0){
            System.out.println("1 - Create clients");
            System.out.println("2 - List all active clients");
            System.out.println("3 - Update client info");
            System.out.println("4 - Delete a client");
            System.out.println("9 - Go back to the main menu");
            System.out.println("0 - Exit program");
            opt = Integer.parseInt(read.nextLine());

            switch (opt){
            case 1 -> clientList = cService.createClient(clientList, routineList);
            case 2 -> cService.showClients(clientList);
            case 3 -> clientList = cService.updateClient(clientList, routineList);
            case 4 -> clientList = cService.deleteClient(clientList);
            case 9 -> mainMenu();
            case 0 -> System.exit(0);
            default -> System.out.println("Incorrect option");
            }

        }
    }
    public static void routineMenu(){
        int opt = 1;
        while(opt != 0){
        System.out.println("1 - Create Routines");
        System.out.println("2 - List all routines");
        System.out.println("3 - Update routine info");
        System.out.println("4 - Delete a routine");
        System.out.println("9 - Go back to the main menu");
        System.out.println("0 - Exit program");
        opt = Integer.parseInt(read.nextLine());

        switch (opt){
            case 1 -> routineList = rService.createRoutines(routineList);
            case 2 -> rService.listRoutines(routineList);
            case 3 -> routineList = rService.updateRoutine(routineList);
            case 4 -> routineList = rService.deleteRoutine(routineList);
            case 9 -> mainMenu();
            case 0 -> System.exit(0);
            default -> System.out.println("Incorrect option");
            }
        }

    }
}