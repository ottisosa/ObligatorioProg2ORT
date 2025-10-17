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
        String rank="-----------Rankings----------\n"
                + "Lista de invictos:\n";
        for (Jugador jug : listaJugadores) {

            if (jug.isInvicto() == true) {

                rank+=jug+"\n";
            }

        }
        
     rank+= "\n Lista de Jugadores";
     
        for (Jugador jugs : listaJugadores) {
          
            if (jugs.isInvicto() == false) {
            
            rank+=jugs+"\n";
            
        }
        }
    }

}
