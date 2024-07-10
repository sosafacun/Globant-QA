package services.staff;

import entities.staff.Professor;

public interface ProfessorInterface {
    void registerNewProfessor();
    void updateProfessor();
    void deleteProfessor();
    void fetchProfessor(Professor professor);
    void fetchProfessorList();
}
