package entities.staff;

import entities.BasicInfo;
import entities.data.ClassCourse;
import entities.data.MaritalStatus;

import java.time.LocalDate;

public class Professor extends StaffMemberInfo {
    private ClassCourse classTaught;

    public Professor() {
    }

    public void setBasicInfo(BasicInfo basicInfo){
        super.personID = basicInfo.getPersonID();
        super.maritalStatus = basicInfo.getMaritalStatus();
        super.personFirstName = basicInfo.getPersonFirstName();
        super.personMiddleName = basicInfo.getPersonMiddleName();
        super.personLastName = basicInfo.getPersonLastName();
    }
    public Professor(long personID, String personFirstName, String personMiddleName, String personLastName, MaritalStatus maritalStatus, LocalDate staffHireDate, int staffOfficeNumber, ClassCourse classTaught) {
        super(personID, personFirstName, personMiddleName, personLastName, maritalStatus, staffHireDate, staffOfficeNumber);
        this.classTaught = classTaught;
    }

    public ClassCourse getClassTaught() {
        return classTaught;
    }

    public void setClassTaught(ClassCourse classTaught) {
        this.classTaught = classTaught;
    }
}
