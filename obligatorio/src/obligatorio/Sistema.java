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

    public void mostrarJugadoresInvictos() {

        for (Jugador jug : listaJugadores) {

            if (jug.isInvicto() == true) {

                System.out.println(jug);
            }

        }

    }

    public void mostrarRanking() {
            
    }
}
