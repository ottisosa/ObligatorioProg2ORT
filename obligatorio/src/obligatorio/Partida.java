package obligatorio;

// Autores: Santiago Quintana (327886), Octavio Sosa (363131)

public class Partida {
    private Jugador j1;
    private Jugador j2;
    private String[][] mat;

    public Partida(Sistema sistema) {
        sistema.mostrarJugadores();
        
        int num1 = Menu.pedirNumero("Ingrese nro de jugador 1", 1, sistema.getListaJugadores().size());
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            if (i+1==num1){
                this.j1 = sistema.getListaJugadores().get(i);
            }
        }
        
        int num2 = Menu.pedirNumero("Ingrese nro de jugador 2", 1, sistema.getListaJugadores().size());
        while (num2==num1){
            System.out.println("Jugador 2 tiene que ser diferente a Jugador 1");
            num2 = Menu.pedirNumero("Ingrese nro de jugador 2", 1, sistema.getListaJugadores().size());
        }
        for (int i = 0; i < sistema.getListaJugadores().size(); i++) {
            if (i+1==num2){
                this.j1 = sistema.getListaJugadores().get(i);
            }
        }
        
        String[][] matriz = {{"","","","","",""},{"","","","","",""},{"","","","","",""}};
        this.mat = matriz;
    }

    
    
    

    public Jugador getJ1() {
        return j1;
    }

    public void setJ1(Jugador j1) {
        this.j1 = j1;
    }

    public Jugador getJ2() {
        return j2;
    }

    public void setJ2(Jugador j2) {
        this.j2 = j2;
    }

    public String[][] getMat() {
        return mat;
    }

    public void setMat(String[][] mat) {
        this.mat = mat;
    }
}
