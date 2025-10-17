package obligatorio;

// Autores: Santiago Quintana (327886), Octavio Sosa (363131)

public class Jugador {
    private String nombre;
    private int edad;
    private boolean invicto;
    private int ganadas;

    public Jugador(String nombre, int edad) {
        for(int i=0; i<Sistema.getListaJugadores().size(); i++){
            if (Sistema.getListaJugadores()[i].getNombre()==)
        }
        
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

    public boolean isInvicto() {
        return invicto;
    }

    public void setInvicto(boolean invicto) {
        this.invicto = invicto;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }
    
}
