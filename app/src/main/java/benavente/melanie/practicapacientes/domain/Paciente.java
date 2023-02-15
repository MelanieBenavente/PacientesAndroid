package benavente.melanie.practicapacientes.domain;

public class Paciente {
    private String nombre;
    private int edad;
    private boolean ingresado;

    private int id;

 public Paciente(String nombre, int edad, boolean ingresado, int id) {
     this.nombre = nombre;
     this.edad = edad;
     this.ingresado = ingresado;
     this.id = id;
 }

 public String getNombre(){
     return nombre;
 }
public void setNombre(String nombre){
     this.nombre = nombre;
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
