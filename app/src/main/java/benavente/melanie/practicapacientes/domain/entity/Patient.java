package benavente.melanie.practicapacientes.domain.entity;

public class Patient {
    private final int ADULT_AGE = 18;
    private String name;
    private int age;
    private boolean status;
    private int id;

    public Patient(String name, int age, boolean status, int id) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.id = id;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdult() {
        return getAge() >= ADULT_AGE;
    }
}
