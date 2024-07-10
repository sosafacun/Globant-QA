package entities.student;

import entities.BasicInfo;
import entities.data.ClassCourse;
import entities.data.MaritalStatus;

import java.util.ArrayList;

public class Student extends BasicInfo {
    private ArrayList<ClassCourse> enlistedCourses;

    public Student(){
    }
    public void setBasicInfo(BasicInfo basicInfo){
        super.personID = basicInfo.getPersonID();
        super.maritalStatus = basicInfo.getMaritalStatus();
        super.personFirstName = basicInfo.getPersonFirstName();
        super.personMiddleName = basicInfo.getPersonMiddleName();
        super.personLastName = basicInfo.getPersonLastName();
    }
    public BasicInfo getBasicInfo(Student student){
        BasicInfo basicInfo = student;
        return basicInfo;
    }
    public Student(long personID, String personFirstName, String personMiddleName, String personLastName, MaritalStatus maritalStatus, ArrayList<ClassCourse> enlistedCourses) {
        super(personID, personFirstName, personMiddleName, personLastName, maritalStatus);
        this.enlistedCourses = enlistedCourses;
    }

    public ArrayList<ClassCourse> getEnlistedCourses() {
        return enlistedCourses;
    }

    public void setEnlistedCourses(ArrayList<ClassCourse> enlistedCourses) {
        this.enlistedCourses = enlistedCourses;
    }

    public static Student copy(Student other){
        Student tempStudent = new Student();

        tempStudent.setBasicInfo(other);
        tempStudent.setEnlistedCourses(other.getEnlistedCourses());

        return tempStudent;
    }
}
