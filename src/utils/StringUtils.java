package utils;

public class StringUtils {

    public static String capitalizar(String nombre,String apellidopat) {
        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase()
                +" "+ apellidopat.substring(0, 1).toUpperCase() +
                apellidopat.substring(1).toLowerCase();
    }

}
