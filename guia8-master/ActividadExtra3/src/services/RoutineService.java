package services;

import entities.Routine;

import java.util.ArrayList;
import java.util.Scanner;

public class RoutineService {
    Scanner read = new Scanner(System.in);
    public ArrayList<Routine> loadRoutines(ArrayList<Routine> rList){

        Routine r1 = new Routine(rList.size(), "Power Play Workout", 90, 5, "Is bery dificul", true);
        rList.add(r1);
        Routine r2 = new Routine(rList.size(), "Dynamic Fusion Fitness", 60, 4, "A mover la cola", true);
        rList.add(r2);
        Routine r3 = new Routine(rList.size(), "Total Body Blitz", 120, 3, "A chivar como loco", true);
        rList.add(r3);
        Routine r4 = new Routine(rList.size(), "Cardio Core Circuit", 60, 2, "A la cinta y a correr.", true);
        rList.add(r4);
        Routine r5 = new Routine(rList.size(), "Strength and Stamina Challenge", 180, 10, "Traete el bidón de agua.", true);
        rList.add(r5);

        return rList;
    }
    public ArrayList<Routine> createRoutines(ArrayList<Routine> rList){
        String input = "a";
        int cont = rList.size();

        while (!input.equalsIgnoreCase("q")) {
            Routine routine = new Routine();

            System.out.println("Press 'Q' at any time to exit");
            System.out.println("in [String] routineName: ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            routine.setRoutineName(input);

            System.out.println("in [double] duration (in minutes): ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            routine.setDuration(Double.parseDouble(input));

            System.out.println("in [int] difficultyLevel (1 to 10): ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            routine.setDifficultyLevel(Integer.parseInt(input));

            System.out.println("in [String] description: ");
            input = read.nextLine();
            if(exit(input)){
                break;
            }
            routine.setDescription(input);

            routine.setIdRoutine(cont);
            routine.setActive(true);
            rList.add(routine);
        }
        return rList;
    }
    public void listRoutines(ArrayList<Routine> rList){
        System.out.println("-----------------------------------------");
        System.out.println("=*=*=*=*=*=*=*=*ROUTINES=*=*=*=*=*=*=*=*=");

        for (Routine routine : rList) {

            if (routine.isActive()) {
                System.out.println("-Client Code-|----------Routine Name-----");
                System.out.println("\t" + routine.getIdRoutine() + "\t\t |\t" + routine.getRoutineName());
                System.out.println("----------------DETAILS------------------");
                System.out.println("Duration:\t\t |\t" + routine.getDuration());
                System.out.println("Difficulty Level:|\t" + routine.getDifficultyLevel());
                System.out.println("Description:\t |\t" + routine.getDescription());
                System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            }
        }

    }
    public ArrayList<Routine> updateRoutine(ArrayList<Routine> rList){
        String input;
        int routineID;

        listRoutines(rList);
        System.out.println("Which routine do you wish to update?");
        System.out.println("Select an ID...");
        input = read.nextLine();
        routineID = Integer.parseInt(input);

        System.out.println("Do you wish to modify:");
        System.out.println("1 - Name");
        System.out.println("2 - Duration");
        System.out.println("3 - Difficulty Level");
        System.out.println("4 - Description");
        System.out.println("0 - Cancel");
        input = read.nextLine();

        switch (Integer.parseInt(input)){

            case 1 -> {
                System.out.println("Input new name:");
                input = read.nextLine();
                String newName = input;

                if (confirm(rList.get(routineID).getRoutineName(),"update")){
                    rList.get(routineID).setRoutineName(newName);
                }
            }
            case 2 ->{
                System.out.println("Input new duration:");
                input = read.nextLine();
                double newDuration = Double.parseDouble(input);

                if (confirm(rList.get(routineID).getRoutineName(),"update")){
                    rList.get(routineID).setDuration(newDuration);
                }
            }
            case 3 ->{
                System.out.println("Input new difficulty (1 to 10):");
                input = read.nextLine();
                int newDifficulty = Integer.parseInt(input);

                if (confirm(rList.get(routineID).getRoutineName(),"update")) {
                    rList.get(routineID).setDifficultyLevel(newDifficulty);
                }
            }
            case 4 ->{
                System.out.println("Input new description:");
                input = read.nextLine();
                String newDescription = input;

                if (confirm(rList.get(routineID).getRoutineName(),"update")){
                    rList.get(routineID).setDescription(newDescription);
                }
            }
            case 0 -> {
                return rList;
            }
            default -> System.out.println("Incorrect option");
        }
        return rList;
    }
    public ArrayList<Routine> deleteRoutine(ArrayList<Routine> rList){
        listRoutines(rList);
        String input;
        int routineID;

        System.out.println("in [int] Routine Code that you wish to delete");
        input = read.nextLine();
        routineID = Integer.parseInt(input);
        /*TODO: Validate clientID*/

        if (confirm(rList.get(routineID).getRoutineName(),"delete")){
            rList.get(routineID).setActive(false);
        }

        return rList;
    }
    private boolean exit(String e){
        return e.equalsIgnoreCase("Q");
    }
    private boolean confirm(String name, String operation){
        String input;
        System.out.println("Are you sure you want to "+operation+ " '"+ name +"'s details?");
        System.out.println("Y - Yes");
        System.out.println("N - No");
        input = read.nextLine();

        if (input.equalsIgnoreCase("y")){
            System.out.println("The routine info has been "+operation+"d");
            return true;
        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("The routine has NOT been modified.");
            return false;
        } else {
            System.out.println("Incorrect option.");
            return false;
        }
    }

}
