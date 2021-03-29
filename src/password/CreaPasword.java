/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package password;

//import java.util.Random;
/**
 *
 * @author ber
 */
public class CreaPasword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Password[] contrasenas = new Password [5];
        boolean [] fuerte = new boolean [5];

        for (int i = 0; i < 5; i++) {
            System.out.println("----------------------------------------------------");
            System.out.println("Contraseña 0" + (i + 1));
            System.out.println("----------------------------------------------------");
            System.out.println("Teclea 1: Si quieres introducir la contraña.");
            System.out.println("Teclea 2: Si quieres que se genere sola la contraña.");
            System.out.println("----------------------------------------------------");
            int numero = ES.leeEntero("Opción = ", 1, 2);

            if (numero == 1) {

                try {
                    System.out.println("\nIntroduce la contraseña, este debe tener 3 o más caracteres");
                    String lectura = ES.leeCadena("Contraseña = ");
                    contrasenas[i] = new Password(lectura);
                    fuerte [i] = contrasenas[i].esFuerte();
                } catch (Exception e) {
                    System.out.println("\n" + e.getMessage() + "\n");
                    i--;
                }
            }

            if (numero == 2) {

                try {
                    System.out.println("\nLa longitud de la contraseña debe de ser mayor de 3 caracteres.");
                    int lectura = ES.leeEntero("Longitud = ", numero);
                    contrasenas[i] = new Password(lectura);
                    fuerte [i] = contrasenas[i].esFuerte();
                } catch (Exception e) {
                    System.out.println("\n" + e.getMessage() + "\n");
                    i--;
                }

            }

        }
        

        for (int i = 0; i < 5; i++) {
            
            String seguridad;
            if (fuerte[i]){
            seguridad = " es FUERTE: ";
            } else {
            seguridad = " es DÉBIL:  ";}
            System.out.println("La contraseña 0" + i + seguridad + contrasenas[i].getContrasena());
        }

    }
}
