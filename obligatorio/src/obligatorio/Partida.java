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
                this.j2 = sistema.getListaJugadores().get(i);
            }
        }
        
        String[][] matriz = {{" "," "," "," "," "," "},{" "," "," "," "," "," "},{" "," "," "," "," "," "}};
        this.mat = matriz;
    }

    public void jugarPartida(){
        String jugActual = "Blanco";
        boolean fin=false;
        while (!fin){
            boolean repetirTurno = true;
            while (repetirTurno){
                repetirTurno = false;
                Menu.imprimirTablero(this.getMat());
                String accion=Menu.pedirString("Ingrese movimiento, X, H, B, N o T. Turno: "+jugActual+" -> ", 1, 3);
                switch (accion){
                    case "X":
                        fin=true;
                        if (jugActual.equals("Blanco")){
                            System.out.println("\nGanador: Negro - "+this.getJ1().getNombre());
                        }
                        else{
                            System.out.println("\nGanador: Blanco - "+this.getJ2().getNombre());
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
            
            String ganador=hayGanador();
            if (!(ganador.equals(""))){
                fin=true;
                if(ganador.equals("Blanco")){
                    Menu.imprimirTablero(this.getMat());
                    System.out.println("Ganador: Blanco - "+this.getJ1().getNombre());
                    this.getJ1().addGanadas();
                    this.getJ2().setInvicto(false);
                }
                else {
                    Menu.imprimirTablero(this.getMat());
                    System.out.println("Ganador: Negro - "+this.getJ2().getNombre());
                    this.getJ2().addGanadas();
                    this.getJ1().setInvicto(false);
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
    
    public String hayGanador(){
        boolean gano=false;
        String ganador = "";
        for (int i = 0; i < this.getMat().length && (!gano); i++) {
            if ((!gano) && this.getMat()[i][0].charAt(0)=='C' && this.getMat()[i][1].charAt(0)=='D' && this.getMat()[i][2].charAt(0)=='C' && this.getMat()[i][3].charAt(0)=='D' && this.getMat()[i][4].charAt(0)=='C' &&this.getMat()[i][5].charAt(0)=='D'){
                gano = true;
                ganador = "Blanco";
                for (int j = 0; j < this.getMat()[0].length; j++) {
                    this.getMat()[i][j]="OO";
                }
            }
            if ((!gano) && this.getMat()[i][0].charAt(0)=='D' && this.getMat()[i][1].charAt(0)=='C' && this.getMat()[i][2].charAt(0)=='D' && this.getMat()[i][3].charAt(0)=='C' && this.getMat()[i][4].charAt(0)=='D' &&this.getMat()[i][5].charAt(0)=='C'){
                gano = true;
                ganador = "Negro";
                for (int j = 0; j < this.getMat()[0].length; j++) {
                    this.getMat()[i][j]="XX";
                }
            }
        }

        for (int i = 0; i < this.getMat()[0].length && (!gano); i+=2) {
            if((!gano) && this.getMat()[0][i].charAt(0)=='C' && this.getMat()[0][i+1].charAt(0)=='D' && this.getMat()[1][i].charAt(0)=='C' && this.getMat()[1][i+1].charAt(0)=='D' && this.getMat()[2][i].charAt(0)=='C' &&this.getMat()[2][i+1].charAt(0)=='D'){
                gano=true;
                ganador="Blanco";
                for (int j=0; j<3; j++){
                    this.getMat()[j][i]="OO";
                    this.getMat()[j][i+1]="OO";
                }
            }
            if((!gano) && this.getMat()[0][i].charAt(0)=='D' && this.getMat()[0][i+1].charAt(0)=='C' && this.getMat()[1][i].charAt(0)=='D' && this.getMat()[1][i+1].charAt(0)=='C' && this.getMat()[2][i].charAt(0)=='D' &&this.getMat()[2][i+1].charAt(0)=='C'){
                gano=true;
                ganador="Negro";
                for (int j=0; j<3; j++){
                    this.getMat()[j][i]="XX";
                    this.getMat()[j][i+1]="XX";
                }
            }
        }
        
        for(int i=0; i<3; i++){
            if((!gano) && this.getMat()[0][i].charAt(0)=='C' && this.getMat()[0][i+1].charAt(0)=='D' && this.getMat()[1][i+1].charAt(0)=='C' && this.getMat()[1][i+2].charAt(0)=='D' && this.getMat()[2][i+2].charAt(0)=='C' && this.getMat()[2][i+3].charAt(0)=='D'){
                gano=true;
                ganador="Blanco";
                for (int j = i; j < i+3; j++) {
                    int fila=0;
                    this.getMat()[fila][j+fila]="OO";
                    this.getMat()[fila][j+fila+1]="OO";
                }
            }
            if((!gano) && this.getMat()[0][i].charAt(0)=='D' && this.getMat()[0][i+1].charAt(0)=='C' && this.getMat()[1][i+1].charAt(0)=='D' && this.getMat()[1][i+2].charAt(0)=='C' && this.getMat()[2][i+2].charAt(0)=='D' && this.getMat()[2][i+3].charAt(0)=='C'){
                gano=true;
                ganador="Negro";
                for (int j = i; j < i+3; j++) {
                    int fila=0;
                    this.getMat()[fila][j+fila]="XX";
                    this.getMat()[fila][j+fila+1]="XX";
                    fila++;
                }
            }
        }
        
        for(int i=0; i<3; i++){
            if((!gano) && this.getMat()[2][i].charAt(0)=='C' && this.getMat()[2][i+1].charAt(0)=='D' && this.getMat()[1][i+1].charAt(0)=='C' && this.getMat()[1][i+2].charAt(0)=='D' && this.getMat()[0][i+2].charAt(0)=='C' && this.getMat()[0][i+3].charAt(0)=='D'){
                gano=true;
                ganador="Blanco";
                int fila=2;
                for (int j = i; j < i+3; j++) {
                    this.getMat()[fila][j]="OO";
                    this.getMat()[fila][j+1]="OO";
                    fila--;
                }
            }
            if((!gano) && this.getMat()[2][i].charAt(0)=='D' && this.getMat()[2][i+1].charAt(0)=='C' && this.getMat()[1][i+1].charAt(0)=='D' && this.getMat()[1][i+2].charAt(0)=='C' && this.getMat()[0][i+2].charAt(0)=='D' && this.getMat()[0][i+3].charAt(0)=='C'){
                gano=true;
                ganador="Negro";
                int fila=2;
                for (int j = i; j < i+3; j++) {
                    this.getMat()[fila][j]="XX";
                    this.getMat()[fila][j+1]="XX";
                    fila--;
                }
            }
        }
        
        return ganador;
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
            if (this.getMat()[i][j].equals(" ")){
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
            if (!(this.getMat()[i][j].equals(" "))){
                if(jugActual.equals("Blanco")){
                    if (this.getMat()[i][j].charAt(1)=='B'){
                        switch (this.getMat()[i][j].charAt(0)) {
                            case 'C':
                                movi = "DB";      
                                break;
                            case 'D':
                                movi = "CB";
                                break;
                        }
                    }
                    else{
                        error = "La pieza elegida no es de su color";
                    }
                }
                else{
                    if (this.getMat()[i][j].charAt(1)=='N'){
                        switch (this.getMat()[i][j].charAt(0)) {
                            case 'C':
                                movi = "DN";
                                break;
                            case 'D':
                                movi = "CN";
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        error = "La pieza elegida no es de su color";
                    }

                }
            }
            else{
                error = "La posicion elegida no tiene una pieza a invetir";
            }
        }
        
        if ((error.equals(""))){
            this.getMat()[i][j]=movi;
        }
        else{
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
