package entities.staff;

import entities.BasicInfo;
import entities.data.MaritalStatus;
import entities.data.PersonnelDepartment;

import java.time.LocalDate;

public class Personnel extends StaffMemberInfo {
    private PersonnelDepartment department;
    public void setBasicInfo(BasicInfo basicInfo){
        super.personID = basicInfo.getPersonID();
        super.maritalStatus = basicInfo.getMaritalStatus();
        super.personFirstName = basicInfo.getPersonFirstName();
        super.personMiddleName = basicInfo.getPersonMiddleName();
        super.personLastName = basicInfo.getPersonLastName();
    }
    public Personnel() {
    }

    public Personnel(long personID, String personFirstName, String personMiddleName, String personLastName, MaritalStatus maritalStatus, LocalDate staffHireDate, int staffOfficeNumber, PersonnelDepartment department) {
        super(personID, personFirstName, personMiddleName, personLastName, maritalStatus, staffHireDate, staffOfficeNumber);
        this.department = department;
    }
}
