package benavente.melanie.practicapacientes.domain;

public class Patient {
    private String name;
    private int edad;
    private boolean ingresado;

    private int id;

 public Patient(String name, int edad, boolean ingresado, int id) {
     this.name = name;
     this.edad = edad;
     this.ingresado = ingresado;
     this.id = id;
 }

 public String getName(){
     return name;
 }
public void setName(String name){
     this.name = name;
 }
    public int getEdad() {
        return edad;
    }
public void setEdad(int edad) {
     this.edad=edad;
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
