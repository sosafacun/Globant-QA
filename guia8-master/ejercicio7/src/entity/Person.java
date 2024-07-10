package entity;

public class Person {
    private String name;
    private int age;
    private String sex;
    private double weight;
    private double height;
    private boolean isHealthy;
    private boolean isOfAge;

    public Person(String name, int age, String sex, double weight, double height, boolean isHealthy, boolean isOfAge) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.isHealthy = isHealthy;
        this.isOfAge = isOfAge;
    }

    public Person() {
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public boolean isOfAge() {
        return isOfAge;
    }

    public void setOfAge(boolean ofAge) {
        isOfAge = ofAge;
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

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", isHealthy=" + isHealthy +
                ", isOfAge=" + isOfAge +
                '}';
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
