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
                                System.out.println("\nNo se acepto el empate");
                                repetirTurno=true;
                                break;
                        }
                        break;
                    default:
                        if (verificarIngreso(accion)){
                            
                            if(!(ingresarMovimiento(accion, jugActual))){
                                repetirTurno=true;
                            }
                            
                        }
                        else{
                            System.out.println("Ingrese movimiento correctamente");
                            repetirTurno=true;
                        }

                        break;
                }
            }
            if(jugActual=="Blanco"){
                jugActual="Negro";
            }
            else{
                jugActual="Blanco";
            }
        }
    }
    
    public boolean ingresarMovimiento(String mov, String jugActual){
        boolean hacerMov = true;
        String movi = "";
        String error = "";
        int i = 0;
        switch (mov.charAt(0)) {
            case 'A':
                i=0;
                break;
            case 'B':
                i=1;
                break;
            case 'C':
                i=2;
                break;
            default:
                break;
        }

        int j = (Integer.parseInt(""+mov.charAt(1))-1);

        if (mov.charAt(2)=='C' || mov.charAt(2)=='D'){
            if (mat[i][j] == ""){
                if (jugActual=="Blanco"){
                    movi=""+mov.charAt(2)+"B";
                }
                else{
                    movi=""+mov.charAt(2)+"N";
                }
            }
            else{
                error="La posicion elegida ya tiene una pieza";
            }
        }
        else{
            if (mat[i][j]!=""){
                if(jugActual=="Blanco" && mat[i][j].charAt(1)=='B'){

                    switch (mat[i][j].charAt(1)) {
                        case 'C':
                            
                            mat[i][j] = "DB";
                                                      
                          break;
                    
                        case 'D':

                            mat[i][j] = "CB";
                            break;
                    }

                }
                else{

                    error="La pieza elegida no es de su color";

                }
                
                if(jugActual=="Negro" && mat[i][j].charAt(1)=='N'){
                    switch (mat[i][j].charAt(0)) {
                        case 'C':
                            mat[i][j] = "DN";
                            break;
                        case 'D':
                            mat[i][j] = "CN";
                            break;
                        default:
                            break;
                    }
                }
                else{
                    error="La pieza elegida no es de su color";
                }
            }
            else{
                error="La posicion elegida no tiene una pieza a invetir";
            }
        }
        
        if (error!=""){
            hacerMov=false;
            System.out.println(error);
        }
        return hacerMov;
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
