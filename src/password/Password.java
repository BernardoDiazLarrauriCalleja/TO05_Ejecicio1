package password;

import java.util.Random;

/**
 * Esta clase define objetos que contienen contraseñas.
 *
 * @author Bernardo Díaz Larrauri Calleja
 * @version: 26/03/2021
 * @see
 * <a href = "https://github.com/BernardoDiazLarrauriCalleja/TO05_Ejercicio1.git"/>GitHub
 * TO05_Ejercicio1<a>*
 */
public class Password {

    //Campos de la clase
    private int longitud = 8;
    private String contrasena;
    //para la clave
    private final String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUWYZ";
    private final String MINUSCULAS = "abcdefghijklmnopqrstuwyz";
    private final String SINGNOSPUNTUACION = ",\"[]:¿?¡!().;—"; //RAE Signos puntuacion: https://www.rae.es/dpd/signos%20ortogr%C3%A1ficos
    private final String NUMEROS = "0123456789";

    /**
     * Constructor. Genera una contraseña con los caracteres introducidos.
     *
     * @param contrasena el parámetro guarda los caracteres de la contraseña
     * @throws Exception la contraseña debe tener una longitud mínima de 3
     * caracteres.
     */
    public Password(String contrasena) throws Exception {

        this.longitud = contrasena.length();
        //la contaseña tiene que tener al menos 3 caracteres, si no la tiene lanza excepción
        if (this.longitud < 3) {
            throw new Exception("La contraseña tiene que tener al menos 3 caracteres.");
        }

        this.contrasena = contrasena;
    }

    /**
     * Constructor. Genera una contraseña aleatoria con mayúsculas, minúsculas,
     * signos de puntuación y números.
     *
     * @param longitud
     * @throws Exception La longitúd de la contraseña debe de ser al menos de 3
     * caracteres.
     */
    public Password(int longitud) throws Exception {

        this.longitud = longitud;
        if (this.longitud < 3) {
            throw new Exception("La contraseña tiene que tener una de longitud de al menos 3 caracteres");
        }
        this.contrasena = generarPassword();
    }

    /**
     * Método que devuelve la longitud de la contraseña.
     *
     * @return devuelve la longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Método que devuelve la contraseña
     *
     * @return devuelve la contraseña
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Método para cambiar la contraseña
     *
     * @param contrasena
     * @throws Exception la contraseña debe tener al menos 3 caracteres
     */
    public void setContrasena(String contrasena) throws Exception {
        longitud = contrasena.length();
        if (longitud < 3) {
            throw new Exception("La contraseña tiene que tener una de longitud de al menos 3 caracteres");
        }
        this.longitud = longitud;
        this.contrasena = contrasena;
    }

    /**
     *
     * @return
     */
    private String generarPassword() {
        final String TODOSCARACTERES = MAYUSCULAS + MINUSCULAS + SINGNOSPUNTUACION + NUMEROS;

        StringBuilder contrasena = new StringBuilder(this.longitud);

        for (int i = 0; i < this.longitud; i++) {

            int r = (int) (Math.random() * TODOSCARACTERES.length());
            char aleatorioChar = TODOSCARACTERES.charAt(r);
            contrasena.append(aleatorioChar);
        }

        this.contrasena = contrasena.toString();
        //if(esFuerte())
        return contrasena.toString();
    }

/**
 * Método que nos indica si una contraseña es fuerte o débil
 * @return True si la contraseña es fuerte, tiene al menos una mayusculas, una minuscula, un numero y un signo de puntuacion.
 */
    public boolean esFuerte() {
        boolean tieneMinusculas = false;
        boolean tieneMayusculas = false;
        boolean tieneSignosPuntuacion = false;
        boolean tieneNumeros = false;

        for (int i = 0; i < contrasena.length(); i++) {
            char t = contrasena.charAt(i);

            for (int j = 0; j < MINUSCULAS.length() && !tieneMinusculas; j++) {

                if (t == MINUSCULAS.charAt(j)) {
                    tieneMinusculas = true;
                }
            }
            for (int k = 0; k < MAYUSCULAS.length() && !tieneMayusculas; k++) {

                if (t == MAYUSCULAS.charAt(k)) {
                    tieneMayusculas = true;
                }
            }

            for (int l = 0; l < SINGNOSPUNTUACION.length() && !tieneSignosPuntuacion; l++) {

                if (t == SINGNOSPUNTUACION.charAt(l)) {
                    tieneSignosPuntuacion = true;
                }
            }

            for (int m = 0; m < NUMEROS.length() && !tieneNumeros; m++) {
                if (t == NUMEROS.charAt(m)) {
                    tieneNumeros = true;
                }
            }

        }
        return tieneMinusculas && tieneMayusculas && tieneSignosPuntuacion && tieneNumeros;

    }
}
