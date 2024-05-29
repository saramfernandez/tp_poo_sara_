package Buquealtoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class GestorReserva {
    private static List<Buque> buques = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    public static int agregarCarrito = 1;
    
    static {
        // Crear algunos buques
        buques.add(new Buque("B001", 1)); // 1 es Argentina
        buques.add(new Buque("B002", 2)); // 2 es Uruguay
    }

    public static void mostrarAsientosBuque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del buque:");
        String buqueId = scanner.nextLine();

        Buque buque = encontrarBuque(buqueId);
        if (buque != null) {
            buque.mostrarAsientos();
        } else {
            System.out.println("Buque no encontrado.");
        }
    }

    public static void gestionarReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del cliente:");
        String dni = scanner.nextLine();

        System.out.println("¿A qué destino desea viajar? (1 para Argentina, 2 para Uruguay):");
        int destino = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        Buque buque = encontrarBuquePorDestino(destino);
        if (buque != null) {
            buque.mostrarAsientos();

            System.out.println("Ingrese el asiento (por ejemplo, 1A, 2B):");
            String asientoId = scanner.nextLine().toUpperCase();;

            int[] filaColumna = buque.getFilaColumnaFromId(asientoId);
            if (filaColumna == null) {
                System.out.println("Asiento incorrecto. Seleccione un asiento correcto.");
                return;
            }


            int fila = filaColumna[0];
            int columna = filaColumna[1];

            if (!buque.getAsientos()[fila][columna]) {
                buque.getAsientos()[fila][columna] = true;
                reservas.add(new Reserva(dni, buque.getId(), destino, fila, columna));
                Carrito.carritoCompras.add(new Reserva(dni, buque.getId(), destino, fila, columna));
                System.out.println("Su Reserva fue  realizada exitosamente.");
                System.out.println("¿Desea agregar algo más al carrito? 1. Si 2. No");
                agregarCarrito = scanner.nextInt();

                if (agregarCarrito == 1) {
                    gestionarReserva();
                } else {
                    System.out.println("Gracias por su compra");
                }
                
                 // Espera a que el usuario presione Enter y no salir repentinamente
            } else {
                System.out.println("Asiento ya está ocupado.");
            }
        } else {
            System.out.println("Destino no disponible.");
        }
    }

    public static void verMisReservas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su DNI para ver sus reservas:");
        String dni = scanner.nextLine();

        System.out.println("Reservas del cliente con DNI " + dni + ":");
        
        boolean found = false;
        for (Reserva reserva : reservas) {
            if (reserva.getClienteDni().equals(dni)) {
                System.out.println("ID de reserva: " + reserva.getId());
                System.out.println("Buque: " + reserva.getBuqueId());
                System.out.println("Destino: " + (reserva.getDestino() == 1 ? "Argentina" : "Uruguay")); // Mostrar el destino del buque como texto
                System.out.println("Asiento: " + convertirAsiento(reserva.getFila(), reserva.getColumna()));
                System.out.println("Pagado: " + reserva.isPagada());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No hay reservas para este DNI.");
        }
    }

    public static String convertirAsiento(int fila, int columna) {
        char letraColumna = (char) ('A' + columna); 
        return (fila + 1) + String.valueOf(letraColumna); 
    }

    private static Buque encontrarBuque(String id) {
        for (Buque buque : buques) {
            if (buque.getId().equals(id)) {
                return buque;
            }
        }
        return null;
    }

    private static Buque encontrarBuquePorDestino(int destino) {
        for (Buque buque : buques) {
            if (buque.getDestino() == destino) {
                return buque;
            }
        }
        return null;
    }
}






/*package Buquealtoque;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorReserva {
    private static List<Buque> buques = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();

    static {
        // Crear algunos buques
        buques.add(new Buque("B001", 1)); // 1 es Argentina
        buques.add(new Buque("B002", 2)); // 2 es Uruguay
    }

    public static void mostrarAsientosBuque() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del buque:");
        String buqueId = scanner.nextLine();

        Buque buque = encontrarBuque(buqueId);
        if (buque != null) {
            buque.mostrarAsientos();
        } else {
            System.out.println("Buque no encontrado.");
        }
    }

    public static void gestionarReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del cliente:");
        String dni = scanner.nextLine();

        System.out.println("¿A qué destino desea viajar? (1 para Argentina, 2 para Uruguay):");
        int destino = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        Buque buque = encontrarBuquePorDestino(destino);
        if (buque != null) {
            buque.mostrarAsientos();

            System.out.println("Ingrese el asiento (por ejemplo, 1A, 2B):");
            String asientoId = scanner.nextLine();

            int[] filaColumna = buque.getFilaColumnaFromId(asientoId);
            if (filaColumna == null) {
                System.out.println("Asiento incorrecto. Seleccione un asiento correcto.");
                return;
            }

            int fila = filaColumna[0];
            int columna = filaColumna[1];

            if (!buque.getAsientos()[fila][columna]) {
                buque.getAsientos()[fila][columna] = true;
                reservas.add(new Reserva(dni, buque.getId(), destino, fila, columna));
                System.out.println("Reserva realizada exitosamente.");
            } else {
                System.out.println("Asiento ya está ocupado.");
            }
        } else {
            System.out.println("Destino no disponible.");
        }
    }

    public static void verMisReservas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su DNI para ver sus reservas:");
        String dni = scanner.nextLine();

        System.out.println("Reservas del cliente con DNI " + dni + ":");

        boolean found = false;
        for (Reserva reserva : reservas) {
            if (reserva.getClienteDni().equals(dni)) {
                System.out.println("ID de reserva: " + reserva.getId());
                System.out.println("Buque: " + reserva.getBuqueId());
                System.out.println("Destino: " + (reserva.getDestino() == 1 ? "Argentina" : "Uruguay")); // Mostrar el destino del buque como texto
                System.out.println("Asiento: " + convertirAsiento(reserva.getFila(), reserva.getColumna()));
                System.out.println("Pagado: " + reserva.isPagada());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No hay reservas para este DNI.");
        }
    }

    private static String convertirAsiento(int fila, int columna) {
        char letraColumna = (char) ('A' + columna); 
        return (fila + 1) + String.valueOf(letraColumna); 
    }

    private static Buque encontrarBuque(String id) {
        for (Buque buque : buques) {
            if (buque.getId().equals(id)) {
                return buque;
            }
        }
        return null;
    }

    private static Buque encontrarBuquePorDestino(int destino) {
        for (Buque buque : buques) {
            if (buque.getDestino() == destino) {
                return buque;
            }
        }
        return null;
    }
}
*/