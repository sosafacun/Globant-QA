package services;

import entities.Dog;

import java.util.ArrayList;

public class DogService {
    public ArrayList<Dog> loadDogs(){
        ArrayList<Dog> dogs = new ArrayList<>();

//        private String dogName;
//        private String dogBreed;
//        private int dogAge;
//        private String dogSize;

        Dog d1 = new Dog("Volo", "None", 8, "Medium");
        dogs.add(d1);
        Dog d2 = new Dog("Frane", "None", 8, "Medium");
        dogs.add(d2);
        Dog d3 = new Dog("Meatball", "German Shepard", 2, "Large");
        dogs.add(d3);
        Dog d4 = new Dog("Yarn", "Caniche Toy", 4, "Small");
        dogs.add(d4);
        Dog d5 = new Dog("Muffin", "Chihuahua", 1, "Small");
        dogs.add(d5);

        return dogs;
    }
}
