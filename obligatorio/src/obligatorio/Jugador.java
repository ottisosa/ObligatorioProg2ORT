package obligatorio;

// Autores: Santiago Quintana (327886), Octavio Sosa (363131)

public class Jugador {
    private String nombre;
    private int edad;
    private boolean invicto;
    private int ganadas;

    public void crearJug(){
        String nombre = Menu.pedirString("Ingrese Nombre de Jugador", 1, Integer.MAX_VALUE);
        int edad = 
    }

    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.invicto = true;
        this.ganadas = 0;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
