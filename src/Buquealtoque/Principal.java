package Buquealtoque;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        while (true) {
            // Iniciar sesión
            Persona usuarioAutenticado = Login.iniciarSesion();

            // Mostrar el menú principal
            mostrarMenuPrincipal(usuarioAutenticado);
        }
    }

    private static void mostrarMenuPrincipal(Persona usuarioAutenticado) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        while (true) {
            menu.mostrarMenu();
            int opcion = menu.leerOpcion();

            switch (opcion) {
                case 1:
                    // Lógica para alta de reserva

                    GestorReserva.gestionarReserva();
                    break;
                case 2:
                    // Lógica para alta de cliente
               	 if (usuarioAutenticado.getTipo().equalsIgnoreCase("Cliente")) {
                     System.out.println("El usuario no tiene permisos para esta acción.");
                 } else {
                	 GestorPersona.registrarNuevoUsuario();
                 }
                    //GestorPersona.registrarNuevoUsuario();
                    break;
                case 3:
                    // Lógica para pagar reserva (implementación futura)
                    System.out.println("Pagar reserva (implementación futura)");
                    break;
                case 4:
                    // Mostrar todos los paquetes
                    GestorPaquetes.mostrarPaquetes();
                    break;
                case 5:
                    // Buscar paquete por ID
                    GestorPaquetes.mostrarPaquetePorId();
                    break;
                case 6:
                    // Ver mis reservas
                    GestorReserva.verMisReservas();
                    break;
                case 7:
                    Carrito.gestionarCarrito();
                    break;
                case 8:
                    System.out.println("Cerrando sesión...");
                    return; // Volver al inicio de sesión
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}
