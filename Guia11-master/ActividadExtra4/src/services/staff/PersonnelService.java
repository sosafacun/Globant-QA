package services.staff;

import entities.staff.Personnel;
import services.BasicInfoService;

import java.util.ArrayList;

public class PersonnelService implements PersonnelInterface {
    private final BasicInfoService basicInfoServices;
    private final ArrayList<Personnel> personnels;
    public PersonnelService(BasicInfoService basicInfoServices, ArrayList<Personnel> personnels) {
        this.basicInfoServices = basicInfoServices;
        this.personnels = personnels;
    }
    public void loadPersonnels(){

    }

    @Override
    public void registerNewPersonal() {

    }

    @Override
    public void updatePersonal() {

    }

    @Override
    public void deletePersonal() {

    }

    @Override
    public void fetchPersonal(Personnel personnel) {

    }

    @Override
    public void fetchPersonnelList() {

    }
}
