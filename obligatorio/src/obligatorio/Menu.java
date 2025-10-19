package obligatorio;

// Autores: Santiago Quintana (327886), Octavio Sosa (363131)

import com.sun.tools.javac.Main;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Menu {
    private Sistema sistema;
    private static boolean guiasTab;
    
    public void menuInicial() {
        
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\nAutores: Santiago Quintana (327886), Octavio Sosa (363131)"
                    + "\n\n"
                    + "-----------------------------------------\n"
                    + "------------Menu Principal---------------\n"
                    + "-----------------------------------------\n"
                    + "1. Registrar un jugador\n"
                    + "2. Comenzar partida\n"
                    + "3. Continuar partida\n"
                    + "4. Mostrar ranking e invictos\n"
                    + "5. Terminar el programa"
            );
            
            opcion = pedirNumero("Elija su opcion (1-5): ", 1, 5);

            switch(opcion){
            
                case 1:
                    Jugador jug = new Jugador(sistema.getListaJugadores());
                    sistema.addListaJugadores(jug);
                    break;
                    
                case 2:
                    
                    if (sistema.getListaJugadores().size()>= 2) {
                        
                        Partida p = new Partida(sistema);
                        p.jugarPartida();
                    
                    }else{
                    
                        System.out.println("\nNo hay jugadores Suficientes");
                    }
                    break;
                    
                case 3:
                    
                    if (sistema.getListaJugadores().size()>= 2) {

                        Partida p = new Partida(sistema);
                        p.continuarPartida();
                        
                    }else{
                    
                        System.out.println("\nNo hay jugadores Suficientes");
                    }
                    
                    break;
                    
                case 4:
                    sistema.mostrarRankings();
                                 
                    break;
                    
            };
        };
        System.out.println("Programa finalizado");
    }

    public static void imprimirTablero(String[][] mat) {
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
        if (isGuiasTab()){
            System.out.println("\n    1  2  3  4  5  6");
        }
        for (int i = 0; i < 3; i++) {
            String out = "  ";
            for (int j = 0; j < 6; j++) {
                out += "+--";
            }
            System.out.println(out + "+");
            
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j == 0 || j == 2) {
                        if (k==0){
                            System.out.print("  |");
                        }
                        else{
                            System.out.print("|");
                        }
                        
                        switch (mat[i][k]) {
                            case "CB":
                                System.out.print(" ○");
                                break;
                            case "CN":
                                System.out.print(" ●");
                                break;
                            case "DB":
                                System.out.print("○ ");
                                break;
                            case "DN":
                                System.out.print("● ");
                                break;
                            default:
                                System.out.print("  ");
                                break;
                        }
                    } else {
                        if (k==0){
                            if (isGuiasTab()){
                                switch (i){
                                case 0:
                                    System.out.print("A |");

                                    break;
                                case 1:
                                    System.out.print("B |");

                                    break;
                                case 2:
                                    System.out.print("C |");

                                    break;
                                }
                            }
                            else{
                            System.out.print("  |");
                            }
                        }
                        else{
                            System.out.print("|");
                        }
                        
                        
                        switch (mat[i][k]) {
                            case "CB":
                                System.out.print("○ ");
                                break;
                            case "CN":
                                System.out.print("● ");
                                break;
                            case "DB":
                                System.out.print(" ○");
                                break;
                            case "DN":
                                System.out.print(" ●");
                                break;
                            default:
                                System.out.print("  ");
                                break;
                        }
                    }
                }
                System.out.println("|");
            }
        }
        String out = "  ";
        for (int j = 0; j < 6; j++) {
            out += "+--";
        }
        System.out.println(out + "+");
    }

    public static int pedirNumero(String mensaje, int minimo, int maximo) {
        Scanner in = new Scanner(System.in);
        int dato = 0;
        boolean ok = false;
        while (!ok) {
            try {
                System.out.print(mensaje);
                dato = in.nextInt();
                in.nextLine();
                if (dato < minimo || dato > maximo) {
                    System.out.println("Valor fuera de rango\n");
                } else {
                    ok = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese *SOLO* numeros en el rango aceptado.\n");
                in.nextLine();
            }
        }
        return dato;
    }
    public static String pedirString(String mensaje, int minimo, int maximo) {
        Scanner in = new Scanner(System.in);
        String dato = "";
        boolean ok = false;
        while (!ok) {
            try {
                System.out.print(mensaje);
                dato = in.nextLine();
                if (dato.length() < minimo || dato.length() > maximo) {
                    System.out.println("Valor fuera de rango\n");
                } else {
                    ok = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese texto, por favor\n");
                in.nextLine();
            }
        }
        return dato;
    }

    public Menu(Sistema sistema) {
        this.sistema = sistema;
        this.guiasTab = true;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public static boolean isGuiasTab() {
        return guiasTab;
    }

    public static void setGuiasTab(boolean guiasTab) {
        Menu.guiasTab = guiasTab;
    }
    
}
