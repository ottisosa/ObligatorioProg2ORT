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

    public void jugarPartida(){
        String jugActual = "Blanco";
        boolean fin=false;
        while (!fin){
            Menu.imprimirTablero(mat);
            String accion=Menu.pedirString("Ingrese movimiento, X, H, B, N o T. Turno: "+jugActual+" -> ", 1, 3);
            boolean repetirTurno = true;
            while (repetirTurno){
                repetirTurno = false;
                switch (accion){
                    case "X":
                        fin=true;
                        if (jugActual=="Blanco"){
                            System.out.println("\nGanador: Negro");
                        }
                        else{
                            System.out.println("\nGanador: Blanco");
                        }
                        break;
                    case "H":
                        
                        break;
                    case "B":
                        Menu.setGuiasTab(true);
                        repetirTurno=true;
                        break;
                    case "N":
                        Menu.setGuiasTab(false);
                        repetirTurno=true;
                        break;
                    case "T":
                        String rinde=Menu.pedirString("\nEl jugador "+jugActual+" se rindio. Si acepta el empate, ponga 'Y' ", 1, 1);
                        switch (rinde){
                            case "Y":
                                fin = true;
                                System.out.println("\nFin de partida - Empate");
                                break;
                            default:
                                System.out.println("\nNo se acepto el empate")
                                repetirTurno=true;
                                break;
                        }
                        break;
                    default:
                        if (verificarIngreso(accion)){
                            
                        }
                        else{
                            System.out.println("Ingrese movimiento correctamente");
                        }
                        break;
                }
            }
        }
    }
    
    public boolean verificarIngreso(String in){
        boolean es=true;
        if (in.length()!=3 ){
            es=false;
        }
        else{
            if (!(in.charAt(0)=='A' || in.charAt(0)=='B' || in.charAt(0)=='C')){
                es=false;
            }
            if (!(in.charAt(1)=='1' || in.charAt(1)=='2' || in.charAt(1)=='3' || in.charAt(1)=='4' || in.charAt(1)=='5' || in.charAt(1)=='6')){
                es=false;
            }
            if (!(in.charAt(2)=='C' || in.charAt(2)=='D' || in.charAt(2)=='I')){
                es=false;
            }
        }
        return es;
    }
    
    public void continuarPartida(){


        String jugadas = Menu.pedirString("Ingrese la cadena de jugadas: ",3, Integer.MAX_VALUE);

        String jugActual = "Blanco";
        boolean fin=false;

        for(int i=0 ; i < jugadas.length(); i+=4){
            
            String jug = "" + jugadas.charAt(i) + jugadas.charAt(i+1) + jugadas.charAt(i+2);
            Menu.imprimirTablero(mat);
            
            
            
        }

        
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
