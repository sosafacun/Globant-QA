package entities;

public class Person {
    private String personFirstName;
    private String personLastName;
    private long personID;
    private Dog dog;

    public Person() {
    }

    public Person(String personFirstName, String personLastName, long personID, Dog dog) {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.personID = personID;
        this.dog = dog;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
