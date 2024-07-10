package services.staff;

import entities.data.ClassCourse;
import entities.data.MaritalStatus;

import entities.staff.Professor;

import services.BasicInfoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorService implements ProfessorInterface {
    Scanner read = new Scanner(System.in);
    private final BasicInfoService basicInfoServices;
    private final ArrayList<Professor> professors;
    public ProfessorService(BasicInfoService basicInfoServices, ArrayList<Professor> professors) {
        this.basicInfoServices = basicInfoServices;
        this.professors = professors;
    }


    @Override
    public void registerNewProfessor() {
        Professor professor = new Professor();

        professor.setBasicInfo(basicInfoServices.register());
        professor.setClassTaught(addClassTaught());
        professor.setStaffHireDate(LocalDate.now());
        System.out.println("Enter the office number:");
        professor.setStaffOfficeNumber(Integer.parseInt(read.nextLine()));

        professors.add(professor);
    }
    @Override
    public void updateProfessor() {
        int selectedProfessor = selectProfessor();
        Professor professor = professors.get(selectedProfessor);
        fetchProfessor(professor);

        System.out.println("1 => EDIT basic info");
        System.out.println("2 => CHANGE class taught");
        System.out.println("3 => CHANGE Office number");
        System.out.println("0 => CANCEL");

        int updateOption = Integer.parseInt(read.nextLine());

        while (true){
            switch (updateOption){
                case 1 ->{
                    professor.setBasicInfo(basicInfoServices.update(professor));
                    professors.set(selectedProfessor, professor);
                    return;
                }
                case 2 -> {
                    professor.setClassTaught(addClassTaught());
                    professors.set(selectedProfessor, professor);
                    return;
                }
                case 3 -> {
                    System.out.println("Enter the new Office number");
                    int newOfficeNumber = Integer.parseInt(read.nextLine());
                    professor.setStaffOfficeNumber(newOfficeNumber);
                    professors.set(selectedProfessor, professor);
                    return;
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Wrong option. Please, try again.");
            }
        }
    }
    @Override
    public void deleteProfessor() {
        int professorToDelete = selectProfessor();
        fetchProfessor(professors.get(professorToDelete));
        while (true){
            System.out.println("ARE YOU SURE YOU WANT TO DELETE THIS PROFESSOR?");
            System.out.println("Y - YES //// N - NO");
            String confirmation = read.nextLine();
            if(confirmation.equalsIgnoreCase("y")){
                professors.remove(professorToDelete);
                System.out.println("The professor's been successfully removed.");
                return;
            } else if(confirmation.equalsIgnoreCase("n")){
                System.out.println("The deletion process has been canceled.");
                return;
            } else {
                System.out.println("Incorrect option. Please, try again.");
            }
        }
    }
    @Override
    public void fetchProfessor(Professor professor) {
        basicInfoServices.fetchBasicInfo(professor);
        System.out.println("Teaches: " + professor.getClassTaught());
        System.out.println("Office Number: " + professor.getStaffOfficeNumber());
        System.out.println("Works here since: " + professor.getStaffHireDate());
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    }
    @Override
    public void fetchProfessorList() {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=|-| PROFESSORS |-|*=*=*=*=*=*=*=*=*=*=*=*");
        for (int i = 0; i < professors.size(); i++) {
            System.out.print(i + 1 + "\t=> ");
            basicInfoServices.showPeople(professors.get(i));
        }
    }
    private int selectProfessor(){
        fetchProfessorList();
        System.out.println("Select the professor...");
        while (true){

            int selection = Integer.parseInt(read.nextLine());
            if (selection >= 1 && selection <= professors.size()){
                selection--;
                return selection;
            } else {
                System.out.println("Wrong option. Please, try gain.");
            }
        }
    }
    private ClassCourse addClassTaught() {

        while (true) {
            System.out.println("1 => MATHS");
            System.out.println("2 => CHEMISTRY");
            System.out.println("3 => PHYSICS");
            System.out.println("4 => GEOGRAPHY");
            System.out.println("5 => HISTORY");
            System.out.println("6 => BIOLOGY");
            System.out.println("7 => COMPUTER SCIENCE");
            System.out.println("8 => INFORMATION TECHNOLOGY");
            System.out.println("9 => STATISTICS");
            System.out.println("10 => BUSINESS");
            System.out.println("11 => ENGLISH");
            int course = Integer.parseInt(read.nextLine());

            switch (course) {
                case 1 -> {
                    return ClassCourse.MATHS;
                }
                case 2 -> {
                    return ClassCourse.CHEMISTRY;
                }
                case 3 -> {
                    return ClassCourse.PHYSICS;
                }
                case 4 -> {
                    return ClassCourse.GEOGRAPHY;
                }
                case 5 -> {
                    return ClassCourse.HISTORY;
                }
                case 6 -> {
                    return ClassCourse.BIOLOGY;
                }
                case 7 -> {
                    return ClassCourse.COMPUTER_SCIENCE;
                }
                case 8 -> {
                    return ClassCourse.INFORMATION_TECHNOLOGY;
                }
                case 9 -> {
                    return ClassCourse.STATISTICS;
                }
                case 10 -> {
                    return ClassCourse.BUSINESS;
                }
                case 11 -> {
                    return ClassCourse.ENGLISH;
                }
                default -> System.out.println("Wrong option. Please, try again.");
            }

        }
    }

    //It loads a bunch of people.
    public void loadProfessors() {

        Professor professor0 = new Professor(26569637,
                "Pedro",
                "Alejandro",
                "Yardin",
                MaritalStatus.SEPARATED,
                LocalDate.of(2001, 04, 19),
                101,
                ClassCourse.MATHS);

        Professor professor1 = new Professor(
                26321075,
                "Erica",
                "María",
                "Ojeda",
                MaritalStatus.REGISTERED_PARTNERSHIP,
                LocalDate.of(2005, 03, 05),
                201,
                ClassCourse.COMPUTER_SCIENCE);

        Professor professor2 = new Professor(22165419,
                "Ruben",
                "Rolando",
                "Rivero",
                MaritalStatus.MARRIED,
                LocalDate.of(2003, 02, 21),
                102,
                ClassCourse.PHYSICS);

        Professor professor3 = new Professor(29121391,
                "Aldana",
                "Maribel",
                "Pierotti",
                MaritalStatus.WIDOWED,
                LocalDate.of(1997, 05, 29),
                103,
                ClassCourse.STATISTICS);

        Professor professor4 = new Professor(24275728,
                "Alejandro",
                "Gabriel",
                "Medrano",
                MaritalStatus.MARRIED,
                LocalDate.of(1999, 02, 05),
                202,
                ClassCourse.GEOGRAPHY);

        Professor professor5 = new Professor(26809637,
                "Luana",
                "Belén",
                "Nicolini",
                MaritalStatus.REGISTERED_PARTNERSHIP,
                LocalDate.of(2003, 9, 12),
                203,
                ClassCourse.HISTORY);

        Professor professor6 = new Professor(23880253,
                "Ogando",
                "Magalí",
                "Roxana",
                MaritalStatus.SINGLE,
                LocalDate.of(1997, 7, 6),
                204,
                ClassCourse.ENGLISH);

        Professor professor7 = new Professor(29610700,
                "Nadia",
                "Martina",
                "Portillo",
                MaritalStatus.MARRIED,
                LocalDate.of(2000, 10, 31),
                301,
                ClassCourse.INFORMATION_TECHNOLOGY);

        Professor professor8 = new Professor(24249796,
                "Candela",
                "Rocio",
                "Moto",
                MaritalStatus.DIVORCED,
                LocalDate.of(2002, 3, 15),
                302,
                ClassCourse.BUSINESS);

        Professor professor9 = new Professor(29538803,
                "Lara",
                "Carmen",
                "Soto",
                MaritalStatus.SEPARATED,
                LocalDate.of(2010, 10, 20),
                303,
                ClassCourse.CHEMISTRY);

        Professor professor10 = new Professor(31521287,
                "Victoria",
                "Irina",
                "Yonas",
                MaritalStatus.MARRIED,
                LocalDate.of(1996, 03, 20),
                304,
                ClassCourse.BIOLOGY);

        professors.add(professor0);
        professors.add(professor1);
        professors.add(professor2);
        professors.add(professor3);
        professors.add(professor4);
        professors.add(professor5);
        professors.add(professor6);
        professors.add(professor7);
        professors.add(professor8);
        professors.add(professor9);
        professors.add(professor10);
    }
}
