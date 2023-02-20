package benavente.melanie.practicapacientes.core.domain;

public class Utils {
      public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
