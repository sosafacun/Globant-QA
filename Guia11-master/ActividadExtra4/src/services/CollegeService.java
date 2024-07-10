package services;

import entities.staff.Personnel;
import entities.staff.Professor;
import entities.student.Student;
import services.staff.PersonnelService;
import services.staff.ProfessorService;
import services.student.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class CollegeService {
    Scanner read = new Scanner(System.in);
    //ArrayLists for hardcoded data.
    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Professor> professors = new ArrayList<>();
    //Ya sé que Personnel es plural. Pero ya le metí mucho como para cambiarlo. Mala mía.
    public static ArrayList<Personnel> personnels = new ArrayList<>();
    //Service initializations and DI for each of them.
    BasicInfoService basicInfoServices = new BasicInfoService();
    StudentService studentService = new StudentService(basicInfoServices, students);
    ProfessorService professorService = new ProfessorService(basicInfoServices, professors);
    PersonnelService personnelService = new PersonnelService(basicInfoServices, personnels);

    public void loadPeople() {
        System.out.println("Starting the load...");
        studentService.loadStudents();
        System.out.println("Students loaded.");
        professorService.loadProfessors();
        System.out.println("Professors loaded.");
        personnelService.loadPersonnels();
        System.out.println("Personnel loaded.");
        System.out.println("Finished loading...");
    }

    public void mainMenu() {
        while (true) {
            System.out.println("1 => STUDENTS");
            System.out.println("2 => PROFESSORS");
            System.out.println("3 => PERSONNEL");
            System.out.println("0 => EXIT");
            int option = Integer.parseInt(read.nextLine());

            if (option >= 1 && option <= 3) {
                generalMenu(option);
            } else if (option == 0) {
                System.exit(0);
            } else {
                System.out.println("Wrong option. Please, try again.");
            }

        }
    }
    private void generalMenu(int option) {
        String target = null;
        if (option == 1) {
            target = "student";
        } else if (option == 2) {
            target = "professor";
        } else if (option == 3) {
            target = "personal";
        }

        while (true) {
            System.out.println("1 => Register new " + target + ".");
            System.out.println("2 => See all " + target + "s.");
            System.out.println("3 => Edit " + target + "'s info.");
            System.out.println("4 => Delete a " + target + ".");
            System.out.println("0 => Go to the main menu");

            int action = Integer.parseInt(read.nextLine());
            switch (action) {
                case 1 -> {
                    if (option == 1) {
                        studentService.registerNewStudent();
                    } else if (option == 2) {
                        professorService.registerNewProfessor();
                    } else if (option == 3) {
                        //personnelService.registerNewPersonnel();
                    }
                }
                case 2 -> {
                    if (option == 1) {
                        studentService.fetchStudentList();
                    } else if (option == 2) {
                        professorService.fetchProfessorList();
                    } else if (option == 3) {
                        //personnelService.registerNewPersonnel();
                    }
                }
                case 3 -> {
                    if (option == 1) {
                        studentService.updateStudentInfo();
                    } else if (option == 2) {
                        professorService.updateProfessor();
                    } else if (option == 3) {
                        //personnelService.registerNewPersonnel();
                    }
                }
                case 4 -> {
                    if (option == 1) {
                        studentService.deleteStudent();
                    } else if (option == 2) {
                        professorService.deleteProfessor();
                    } else if (option == 3) {
                        //personnelService.registerNewPersonnel();
                    }
                }
                case 0 -> mainMenu();
            }
        }
    }

}
