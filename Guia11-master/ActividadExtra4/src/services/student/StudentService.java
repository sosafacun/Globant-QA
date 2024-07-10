package services.student;

import entities.data.ClassCourse;
import entities.data.MaritalStatus;
import entities.student.Student;
import services.BasicInfoService;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService implements StudentInterface{
    private final BasicInfoService basicInfoServices;
    private final ArrayList<Student> students;
    public StudentService(BasicInfoService basicInfoServices, ArrayList<Student> students) {
        this.basicInfoServices = basicInfoServices;
        this.students = students;
    }
    Scanner read = new Scanner(System.in);
    public void loadStudents(){
        //There are 12 people here.
        ArrayList<ClassCourse> coursesBusiness =  new ArrayList<>();
        coursesBusiness.add(ClassCourse.ENGLISH);
        coursesBusiness.add(ClassCourse.BUSINESS);
        coursesBusiness.add(ClassCourse.STATISTICS);

        ArrayList<ClassCourse> coursesIT =  new ArrayList<>();
        coursesIT.add(ClassCourse.ENGLISH);
        coursesIT.add(ClassCourse.COMPUTER_SCIENCE);
        coursesIT.add(ClassCourse.INFORMATION_TECHNOLOGY);

        ArrayList<ClassCourse> coursesHuman = new ArrayList<>();
        coursesHuman.add(ClassCourse.BIOLOGY);
        coursesHuman.add(ClassCourse.HISTORY);
        coursesHuman.add(ClassCourse.GEOGRAPHY);

        ArrayList<ClassCourse> coursesScience = new ArrayList<>();
        coursesScience.add(ClassCourse.MATHS);
        coursesScience.add(ClassCourse.PHYSICS);
        coursesScience.add(ClassCourse.CHEMISTRY);


        Student student0 = new Student(95086283,
                "Maria",
                "Sol",
                "Garcilazo",
                MaritalStatus.SINGLE,
                coursesBusiness);
        Student student1 = new Student(
                26196580,
                "Ariel",
                "David",
                "Albacete",
                MaritalStatus.REGISTERED_PARTNERSHIP,
                coursesBusiness);
        Student student2 = new Student(
                24837657,
                "Miguel",
                "Angel",
                "Alberdi",
                MaritalStatus.WIDOWED,
                coursesBusiness);
        //----------------------//
        Student student3 = new Student(
                35860651,
                "Susana",
                "Pilar",
                "Adamo",
                MaritalStatus.REGISTERED_PARTNERSHIP,
                coursesIT);
        Student student4 = new Student(
                40510562,
                "Facundo",
                "Nicolas",
                "Sosa",
                MaritalStatus.SINGLE,
                coursesIT);
        Student student5 = new Student(
                37997717,
                "Florencia",
                "Paola",
                "Oviedo",
                MaritalStatus.MARRIED,
                coursesIT);
        //----------------------//
        Student student6 = new Student(
                25568258,
                "Bruno",
                "Rodrigo",
                "Osse",
                MaritalStatus.SINGLE,
                coursesHuman);
        Student student7 = new Student(
                95871470,
                "Dario",
                "Ezequiel",
                "Garea",
                MaritalStatus.SEPARATED,
                coursesHuman);
        Student student8 = new Student(
                35393435 ,
                "Anahi",
                "Rosaura",
                "Cerutti,",
                MaritalStatus.MARRIED,
                coursesHuman);
        //----------------------//
        Student student9 = new Student(
                93530491 ,
                "Camila",
                "Yael",
                "Buenavida",
                MaritalStatus.DIVORCED,
                coursesScience);
        Student student10 = new Student(
                41325196,
                "Natalia",
                "Micaela",
                "Pertinencia",
                MaritalStatus.REGISTERED_PARTNERSHIP,
                coursesScience);
        Student student11 = new Student(
                18029282,
                "Hector",
                "Nicolas",
                "Ferreyra ",
                MaritalStatus.SINGLE,
                coursesScience);


        students.add(student0);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
        students.add(student11);
        //----------------------//
    }
    @Override
    public void registerNewStudent() {
        Student student = new Student();

        student.setBasicInfo(basicInfoServices.register());

        ArrayList<ClassCourse> courses = new ArrayList<>();
        student.setEnlistedCourses(addCourses(courses));

        students.add(student);
    }
    @Override
    public void updateStudentInfo() {
        int selection = studentSelection();
        Student student = students.get(selection);
        fetchStudentInfo(student);

        System.out.println("1 => EDIT basic info");
        System.out.println("2 => ADD courses");
        System.out.println("3 => DELETE courses");
        System.out.println("0 => CANCEL.");
        int updateOption = Integer.parseInt(read.nextLine());

        while (true) {
            switch (updateOption) {
                case 1 -> {
                    student.setBasicInfo(basicInfoServices.update(student));
                    students.set(selection, student);
                    return;
                }
                case 2 -> {
                    student.setEnlistedCourses(addCourses(student.getEnlistedCourses()));
                    students.set(selection, student);
                    return;
                }
                case 3 -> {/*DELETE COURSES*/
                    System.out.println("Imaginate que borro las clases en las que se anotan...");
                return;}
                case 0 -> {
                    return;
                }
                default -> System.out.println("Wrong option, try again.");
            }
        }
    }
    @Override
    public void deleteStudent() {
        int studentDeleteSelection = studentSelection();
        fetchStudentInfo(students.get(studentDeleteSelection));
        while (true){
        System.out.println("ARE YOU SURE YOU WANT TO DELETE THIS STUDENT?");
        System.out.println("Y - YES //// N - NO");
        String confirmation = read.nextLine();
            if(confirmation.equalsIgnoreCase("y")){
                students.remove(studentDeleteSelection);
                System.out.println("The student's been successfully removed.");
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
    public void fetchStudentList(){
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*|-| STUDENTS |-|=*=*=*=*=*=*=*=*=*=*=*=*");
        for(int i = 0; i<students.size(); i++) {
            System.out.print(i+1+ "\t=> ");
            basicInfoServices.showPeople(students.get(i));
        }
    }
    private ArrayList<ClassCourse> addCourses(ArrayList<ClassCourse> courses) {
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
            System.out.println("--------------------");
            System.out.println("0 => STOP ADDING COURSES");
            int course = Integer.parseInt(read.nextLine());

            switch (course) {
                case 1 -> {
                    if (!courses.contains(ClassCourse.MATHS)) {
                        courses.add(ClassCourse.MATHS);
                    } else {
                        repeatedMessage();
                    }
                }
                case 2 -> {
                    if (!courses.contains(ClassCourse.CHEMISTRY)){
                        courses.add(ClassCourse.CHEMISTRY);
                    } else {
                        repeatedMessage();
                    }
                }
                case 3 -> {
                    if(!courses.contains(ClassCourse.PHYSICS)){
                        courses.add(ClassCourse.PHYSICS);
                    } else {
                        repeatedMessage();
                    }
                }
                case 4 -> {
                    if(!courses.contains(ClassCourse.GEOGRAPHY)){
                        courses.add(ClassCourse.GEOGRAPHY);
                    } else {
                        repeatedMessage();
                    }
                }
                case 5 -> {
                    if(!courses.contains(ClassCourse.HISTORY)){
                        courses.add(ClassCourse.HISTORY);
                    } else {
                        repeatedMessage();
                    }
                }
                case 6 -> {
                    if(!courses.contains(ClassCourse.BIOLOGY)){
                        courses.add(ClassCourse.BIOLOGY);
                    } else {
                        repeatedMessage();
                    }
                }
                case 7 -> {
                    if(!courses.contains(ClassCourse.COMPUTER_SCIENCE)){
                        courses.add(ClassCourse.COMPUTER_SCIENCE);
                    } else {
                        repeatedMessage();
                    }
                }
                case 8 -> {
                    if(!courses.contains(ClassCourse.INFORMATION_TECHNOLOGY)){
                        courses.add(ClassCourse.INFORMATION_TECHNOLOGY);
                    } else {
                        repeatedMessage();
                    }
                }
                case 9 -> {
                    if(!courses.contains(ClassCourse.STATISTICS)){
                        courses.add(ClassCourse.STATISTICS);
                    } else {
                        repeatedMessage();
                    }
                }
                case 10 -> {
                    if(!courses.contains(ClassCourse.BUSINESS)){
                        courses.add(ClassCourse.BUSINESS);
                    } else {
                        repeatedMessage();
                    }
                }
                case 11 -> {
                    if(!courses.contains(ClassCourse.ENGLISH)){
                        courses.add(ClassCourse.ENGLISH);
                    } else {
                        repeatedMessage();
                    }
                }
                case 0 -> {
                    if (courses.size() == 0) {
                        System.out.println("You have to enlist to AT LEAST one course.");
                    } else {
                        return courses;
                    }
                }
                default -> System.out.println("Incorrect value");
            }

        }
    }
    private void repeatedMessage(){
        System.out.println("That student is already enlisted on that subject...");
    }
    private void fetchStudentInfo(Student student) {
        basicInfoServices.fetchBasicInfo(student);
        System.out.println("Enlisted Courses: " + student.getEnlistedCourses());
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
    }
    private int studentSelection(){
        fetchStudentList();
        System.out.println("Select the student...");
        while (true){
            int selection = Integer.parseInt(read.nextLine());

            if (selection >= 1 && selection <= students.size()){
                selection--;
                return selection;
            }else{
                System.out.println("Wrong option. Please, try again");
            }

        }
    }
}
