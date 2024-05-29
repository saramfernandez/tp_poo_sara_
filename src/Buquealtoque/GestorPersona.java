package Buquealtoque;

import java.util.Scanner;

public class GestorPersona {
	
	 public static void registrarNuevoUsuario() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Ingrese el correo electrónico: ");
	        String email = scanner.nextLine();

	        System.out.print("Ingrese el nombre: ");
	        String nombre = scanner.nextLine();

	        System.out.print("Ingrese el apellido: ");
	        String apellido = scanner.nextLine();

	        System.out.print("Ingrese el DNI: ");
	        String dni = scanner.nextLine();

	        System.out.print("Ingrese la contraseña: ");
	        String password = scanner.nextLine();

	        System.out.print("Ingrese el tipo de usuario (Cliente/Empleado): ");
	        String tipo = scanner.nextLine();

	        Persona.agregarUsuario(email, nombre, apellido, dni, password, tipo);
	        System.out.println("Usuario registrado con éxito.");
	    }
	
	
	
}
