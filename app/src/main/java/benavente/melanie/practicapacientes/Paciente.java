package benavente.melanie.practicapacientes;

public class Paciente {
    private String nombre;
    private int edad;
    private boolean ingresado;

 public Paciente(String nombre, int edad, boolean ingresado) {
     this.nombre = nombre;
     this.edad = edad;
     this.ingresado = ingresado;
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
}
