package Buquealtoque;
import java.util.ArrayList;
import java.util.List;

public class Persona {
	    private String email;
	    private String nombre;
	    private String apellido;
	    private String dni;
	    private String password;
	    private String tipo;

	    // Constructor
	    public Persona(String email, String nombre, String apellido, String dni, String password, String tipo) {
	        this.email = email;
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.dni = dni;
	        this.password = password;
	        this.tipo = tipo;
	    }

	    // Getters
	    public String getEmail() {
	        return email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    // Lista de usuarios predefinidos
	    private static List<Persona> usuarios = new ArrayList<>();

	    static {
	        usuarios.add(new Persona("omarbrondo@gmail.com", "Omar", "Brondo", "31895218", "felicitas", "Cliente"));
	        usuarios.add(new Persona("barby@outlook.com", "Barby", "Carrizo", "33037264", "gordo", "Empleado"));
			usuarios.add(new Persona("saramarielf@gmail.com", "Sara", "Fernandez", "40463702", "1234", "Empleado"));

	        // Puedes agregar más usuarios aquí
	    }

	    // Método para validar usuario
	    public static Persona validarUsuario(String email, String password) {
	        for (Persona usuario : usuarios) {
	            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
	                return usuario;
	            }
	        }
	        return null;
	    }

	    // Método para agregar un nuevo usuario
	    public static void agregarUsuario(String email, String nombre, String apellido, String dni, String password, String tipo) {
	        usuarios.add(new Persona(email, nombre, apellido, dni, password, tipo));
	    }
	}

