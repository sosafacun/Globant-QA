import entity.Person;
import service.PersonService;

public class Main {
    public static void main(String[] args) {

        PersonService pService = new PersonService();

        Person p1 = pService.createPerson("Kiwi", 25, "H", 97.54, 1.64);
        Person p2 = pService.createPerson("Kewe", 7, "M", 80, 1.80);
        Person p3 = pService.createPerson("Kawa", 17, "O", 60, 1.64);
        Person p4 = pService.createPerson("Kowo", 88, "H", 100.57, 1.32);
        Person p5 = pService.createPerson("Kuwu", 23, "O", 21, 2.14);

        pService.checkPerson(p1);
        pService.checkPerson(p2);
        pService.checkPerson(p3);
        pService.checkPerson(p4);
        pService.checkPerson(p5);

        pService.showPerson(p1);
        pService.showPerson(p2);
        pService.showPerson(p3);
        pService.showPerson(p4);
        pService.showPerson(p5);
    }

}