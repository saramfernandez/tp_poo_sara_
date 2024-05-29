package Buquealtoque;
import java.util.Scanner;
import java.io.Console;


public class Login {
	Console consola = null;
	
    public static Persona iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        Persona usuarioAutenticado = null;
    	System.out.println("+---------------------------+");
    	System.out.println("|                           |");
    	System.out.println("|    BUQUE AL TOQUE S.A.    |");
    	System.out.println("|                           |");
    	System.out.println("+---------------------------+");
        while (usuarioAutenticado == null) {

            System.out.print("\nIngrese su correo electrónico: ");
            String email = scanner.nextLine();

            System.out.print("Ingrese su contraseña: ");
            String password = scanner.nextLine();

            usuarioAutenticado = Persona.validarUsuario(email, password);

            if (usuarioAutenticado == null) {
                System.out.println("Usuario o contraseña inválida. Intente nuevamente.");
            } else {
                System.out.println("\nBienvenido, " + usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido() + "!! \t\t[" + usuarioAutenticado.getTipo() + "]");
            }
        }

        return usuarioAutenticado;
    }

}
