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
        String rank = "\n-----------Rankings----------\n"
                + "Lista de invictos:\n";

        ordenarPorNombre();

        for (Jugador jug : listaJugadores) {

            if (jug.isInvicto() == true) {

                rank += jug + "\n";
            }

        }

        rank += "\nRanking por ganadas:\n";
        ordenarPorGanadas();

        for (Jugador jug : listaJugadores) {

            rank += jug + "\n";
        }

        System.out.println(rank);
    }

    public void mostrarJugadores() {
        ordenarPorNombre();
        
        String lista = "\n-----------Lista de Jugadores-----------\n";

        
        for (int i = 0; i < listaJugadores.size(); i++) {

            lista += "" + (i+1) + listaJugadores.get(i) + "\n";
            
        }

        System.out.println(lista);

    }

    public void ordenarPorNombre() {

        Collections.sort(listaJugadores, new criterioNombre());

    }
// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    //AFOHIUADIGASFGFIUGIFAS
    public void ordenarPorGanadas() {

        Collections.sort(listaJugadores);

    }

    private class criterioNombre implements Comparator<Jugador> {

        @Override
        public int compare(Jugador jug1, Jugador jug2) {
            return jug1.getNombre().compareTo(jug2.getNombre());
        }
    }

}

<<<<<<< Updated upstream









dwadadwaddawwadadadwa






dwadw8adawhiihawhiawd
=======
// pene jaja xd 
>>>>>>> Stashed changes
