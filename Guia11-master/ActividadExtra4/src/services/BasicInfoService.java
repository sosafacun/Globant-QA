package services;

import entities.BasicInfo;
import entities.data.MaritalStatus;

import java.util.Scanner;

public class BasicInfoService implements BasicInfoInterface {
    Scanner read = new Scanner(System.in);

    @Override
    public BasicInfo register() {
        BasicInfo basicInfo = new BasicInfo();
        System.out.println("Enter the person's FIRST NAME: ");
        basicInfo.setPersonFirstName(read.nextLine());
        System.out.println("Enter the person's MIDDLE NAME: ");
        basicInfo.setPersonMiddleName(read.nextLine());
        System.out.println("Enter the person's LAST NAME: ");
        basicInfo.setPersonLastName(read.nextLine());
        System.out.println("Enter the person's ID");
        basicInfo.setPersonID(Long.parseLong(read.nextLine()));
        basicInfo.setMaritalStatus(basicInfo_setMaritalStatus());


        return basicInfo;
    }
    @Override
    public void fetchBasicInfo(BasicInfo info) {
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*|-|BASIC INFO|-|=*=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println(info.getPersonLastName()+", "+info.getPersonFirstName()+" "+info.getPersonMiddleName());
        System.out.println("ID: "+info.getPersonID());
        System.out.println("MARITAL STATUS: " + info.getMaritalStatus());
    }
    @Override
    public BasicInfo update(BasicInfo oldInfo) {
        BasicInfo updatedBasicInfo = BasicInfo.copy(oldInfo);

        System.out.println("1 => Change FIRST name");
        System.out.println("2 => Change MIDDLE name");
        System.out.println("3 => Change LAST name");
        System.out.println("4 => Change Marital Status");
        System.out.println("5 => Change ID");
        System.out.println("6 => Change ALL basic info");
        System.out.println("0 => Cancel");
        int updateOption = Integer.parseInt(read.nextLine());

        switch (updateOption){
            case 1 -> updatedBasicInfo.setPersonFirstName(updateFirstName());
            case 2 -> updatedBasicInfo.setPersonMiddleName(updateMiddleName());
            case 3 -> updatedBasicInfo.setPersonLastName(updateLastName());
            case 4 -> updatedBasicInfo.setMaritalStatus(basicInfo_setMaritalStatus());
            case 5 -> updatedBasicInfo.setPersonID(updateID());
            case 6 -> updatedBasicInfo = register();
            case 0 -> {return oldInfo;}
        }
        fetchBasicInfo(updatedBasicInfo);
        System.out.println("Confirm changes?");
        System.out.println("Y - Yes //// N - No");
        String confirmation = read.nextLine();
        while (true){
            if(confirmation.equalsIgnoreCase("y")){
                System.out.println("Changes have been applied...");
                return updatedBasicInfo;
            }
            else if (confirmation.equalsIgnoreCase("n")){
                System.out.println("Changes have not been made...");
                return oldInfo;
            } else {
                System.out.println("Incorrect option, try again.");
            }
        }
    }
    @Override
    public void showPeople(BasicInfo info) {
        System.out.println("ID: " + info.getPersonID() + "\t|"+ info.getPersonLastName()+", "+ info.getPersonFirstName()+" "+info.getPersonMiddleName() + ".");
        System.out.println("-----------------------------------------------------------------");
    }
    private String updateFirstName(){
        System.out.println("Enter new FIRST name...");
        return read.nextLine();
    }
    private String updateMiddleName(){
        System.out.println("Enter new MIDDLE name...");
        return read.nextLine();
    }
    private String updateLastName(){
        System.out.println("Enter new LAST name...");
        return read.nextLine();
    }
    private MaritalStatus basicInfo_setMaritalStatus (){
        System.out.println("Select the MARITAL STATUS...");
        System.out.println("1 => SINGLE");
        System.out.println("2 => MARRIED");
        System.out.println("3 => DIVORCED");
        System.out.println("4 => SEPARATED");
        System.out.println("5 => WIDOWED");
        System.out.println("6 => REGISTERED PARTNERSHIP");
        int updateMaritalStatus = Integer.parseInt(read.nextLine());
        while (true){
            switch(updateMaritalStatus){
                case 1 -> {return MaritalStatus.SINGLE;}
                case 2 -> {return MaritalStatus.MARRIED;}
                case 3 -> {return MaritalStatus.DIVORCED;}
                case 4 -> {return MaritalStatus.SEPARATED;}
                case 5 -> {return MaritalStatus.WIDOWED;}
                case 6 -> {return MaritalStatus.REGISTERED_PARTNERSHIP;}
                default -> System.out.println("Wrong option, try again.");
            }

        }
    }
    private long updateID (){
        System.out.println("Enter new ID...");
        return Long.parseLong(read.nextLine());
    }

}
