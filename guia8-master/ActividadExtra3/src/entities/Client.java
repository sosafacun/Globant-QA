package entities;

public class Client {

    private int idClient;
    private String name;
    private int age;
    private double height;
    private double weight;
    private String objective;
    private boolean isActiveClient;
    private Routine routine;
    public Client() {
    }

    public Client(int idClient, String name, int age, double height, double weight, String objective, boolean isActiveClient, Routine routine) {
        this.idClient = idClient;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.objective = objective;
        this.isActiveClient = isActiveClient;
        this.routine = routine;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public boolean isActiveClient() {
        return isActiveClient;
    }

    public void setActiveClient(boolean activeClient) {
        isActiveClient = activeClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }
}
