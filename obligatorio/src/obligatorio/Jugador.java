package obligatorio;

// Autores: Santiago Quintana (327886), Octavio Sosa (363131)

import java.util.ArrayList;


public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int edad;
    private boolean invicto;
    private int ganadas;

    public Jugador(ArrayList<Jugador> listaJug) {
        boolean ok=false;
        String nom="";
        while(!ok) {
            nom = Menu.pedirString("Ingrese nombre: ", 1, Integer.MAX_VALUE);
            ok=true;
            for (int i = 0; i < listaJug.size(); i++) {
                if(listaJug.get(i).getNombre()==nombre){
                    ok=false;
                    System.out.println("Nombre ya existe");
                }

            }
        }
        
        if (ok==true){
            this.nombre = nom;
            this.edad = Menu.pedirNumero("Ingrese Edad (1-200)", 1, 200);
            this.invicto = true;
            this.ganadas = 0;
        }
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
    
    
    @Override
    // Criterio por defecto ordenar por Ganadas
    public int compareTo(Jugador jug){
    
        return this.getGanadas() - jug.getGanadas();
    }
    
    
}
