package services.staff;

import entities.staff.Personnel;


//IT'S THE SAME AS PROFESSORS.
public interface PersonnelInterface {
    void registerNewPersonal();
    void updatePersonal();
    void deletePersonal();
    void fetchPersonal(Personnel personnel);
    void fetchPersonnelList();
}
