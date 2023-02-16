package benavente.melanie.practicapacientes.domain;

public class Patient {
    private String name;
    private int age;
    private boolean ingresado;

    private int id;

 public Patient(String name, int age, boolean ingresado, int id) {
     this.name = name;
     this.age = age;
     this.ingresado = ingresado;
     this.id = id;
 }

 public String getName(){
     return name;
 }
public void setName(String name){
     this.name = name;
 }
    public int getAge() {
        return age;
    }
public void setAge(int age) {
     this.age = age;
}
    public boolean getIngresado() {
     return ingresado;
    }
public void setIngresado(boolean ingresado){
     this.ingresado = ingresado;
    }
    public int getId() { return id; }

    public void setId(int id) { this.id=id; }
}
