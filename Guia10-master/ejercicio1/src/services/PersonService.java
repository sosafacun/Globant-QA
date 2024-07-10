package services;

import entities.Dog;
import entities.Person;

import java.util.ArrayList;

public class PersonService {
    public ArrayList<Person> loadPeople(ArrayList<Dog> dogs){
        ArrayList<Person> people = new ArrayList<>();

//        private String personFirstName;
//        private String personLastName;
//        private long personID;
//        private Dog dog;

        Person p1 = new Person("Alejandro", "Magma", 00000000, dogs.get(2));
        people.add(p1);
        Person p2 = new Person("Thor", "God", 00000001, dogs.get(4));
        people.add(p2);
        Person p3 = new Person("Victor", "Magno", 00000002, dogs.get(0));
        people.add(p3);
        Person p4 = new Person("Victor", "Magno", 00000002, dogs.get(1));
        people.add(p4);
        Person p5 = new Person("Alex", "Gutierrez", 00000004, dogs.get(3));
        people.add(p5);

        return people;
    }
}
