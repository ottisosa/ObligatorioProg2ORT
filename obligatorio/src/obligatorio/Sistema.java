package obligatorio;

// Autores: Santiago Quintana (327886), Octavio Sosa (363131)
import java.util.*;

public class Sistema {

    private ArrayList<Jugador> listaJugadores = new ArrayList<>();

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void addListaJugadores(Jugador Jug) {

        listaJugadores.add(Jug);

    }

    public void mostrarRankings() {
        String rank = "-----------Rankings----------\n"
                + "Lista de invictos:\n";
        
        ordenarPorNombre();
        
        for (Jugador jug : listaJugadores) {

            if (jug.isInvicto() == true) {

                rank += jug + "\n";
            }
            
        }

        ordenarPorGanadas();
        
        for (Jugador jug : listaJugadores) {

                rank += jug + "\n";
        }
        
        System.out.println(rank);
    }

    public void ordenarPorNombre() {

        Collections.sort(listaJugadores, new criterioNombre());

    }

    public void ordenarPorGanadas() {

        Collections.sort(listaJugadores);

    }

    public void mostrarJugadores() {

        String lista = "-----------Lista de Jugadores-----------\n";

        for (Jugador jug : listaJugadores) {

            lista += jug + "\n";

        }
    }

    private class criterioNombre implements Comparator<Jugador> {

        public int compare(Jugador jug1, Jugador jug2) {
            return jug1.getNombre().compareTo(jug2.getNombre());
        }
    }

}
