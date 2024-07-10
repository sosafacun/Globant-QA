import entities.Dog;
import entities.Person;
import services.DogService;
import services.PersonService;

import java.util.ArrayList;

public class Main {
    public static DogService dogService = new DogService();
    public static PersonService personService = new PersonService();
    public static ArrayList<Dog> dogList = dogService.loadDogs();
    public static ArrayList<Person> peopleList = personService.loadPeople(dogList);

    public static void main(String[] args) {
        showDogsAndPeople(dogList, peopleList);
    }

    public static void showDogsAndPeople(ArrayList<Dog> dogList, ArrayList<Person> peopleList){
        for (Person person : peopleList) {
            System.out.println("Owner: " + person.getPersonLastName() + ", " + person.getPersonFirstName() + ".");
            System.out.println("ID: " + person.getPersonID());
            System.out.println("Dog data:");
            System.out.println("Name\t=>"+ person.getDog().getDogName());
            System.out.println("Breed\t=>"+ person.getDog().getDogBreed());
            System.out.println("Age\t\t=>"+ person.getDog().getDogAge());
            System.out.println("Size\t=>"+ person.getDog().getDogSize());
            System.out.println("=*=*==*=*=*=*=*=*=*=*=*==*=*=*=*=*=*=*=*=*==*=*=*=*=*=*=*=*=*==*=*=*=*=*=*=*=*=*==*=*=*=*=*=*=*=");
        }
    }
}