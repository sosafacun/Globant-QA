package service;

import entity.Person;

public class PersonService {
    public Person createPerson(String name, int age, String sex, double weight, double height){
        Person p = new Person();
        p.setName(name);
        p.setAge(age);
        p.setSex(sex);
        p.setWeight(weight);
        p.setHeight(height);

        return p;
    }
    public void checkPerson(Person p){
        p.setHealthy(checkBMI(p));
        p.setOfAge(isOfAge(p));
    }
    public void showPerson(Person p){
        System.out.println(p.toString());
    }
    private boolean checkBMI (Person p){
        double bmi;
        boolean isHealthy;

        bmi = p.getWeight() / (p.getHeight()*p.getHeight());

        if(bmi < 20){
            isHealthy = false;
        }
        else if (bmi > 25) {
            isHealthy = false;
        }
        else {
            isHealthy = true;
        }

        return isHealthy;
    }
    private boolean isOfAge(Person p){
        boolean isOfAge;

        if (p.getAge() >= 18){
            isOfAge = true;
        } else {
            isOfAge = false;
        }
        return isOfAge;
    }
}
