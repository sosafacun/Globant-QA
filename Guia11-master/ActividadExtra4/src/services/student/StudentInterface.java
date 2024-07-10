package services.student;

import entities.student.Student;

import java.util.ArrayList;

public interface StudentInterface{
    void registerNewStudent();
    void updateStudentInfo();
    void deleteStudent ();
    void fetchStudentList();
}
