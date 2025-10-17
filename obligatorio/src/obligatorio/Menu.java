package obligatorio;

import com.sun.tools.javac.Main;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public abstract class Menu {

    public static void menuInicial() {

        int opcion = 0;
        while (opcion != 5) {
            System.out.println("Autores: Santiago Quintana (327886), Octavio Sosa (363131)"
                    + "\n\n"
                    + "-----------------------------------------\n"
                    + "------------Menu Principal---------------\n"
                    + "-----------------------------------------\n"
                    + "1. Registrar un jugador\n"
                    + "2. Comenzar partida\n"
                    + "3. Continuar partida\n"
                    + "4. Mostrar ranking de invictos\n"
                    + "5. Terminar el programa"
            );
            
            opcion = pedirNumero("Elija su opcion (1-5): ", 1, 5);

            switch(opcion){
            
                case 1:
                    
                    break;
                    
                case 2:
                    
                    break;
                    
                case 3:
                    
                    break;
                    
                case 4:
                    
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

        for (int i = 0; i < 3; i++) {

            String out = "";
            for (int j = 0; j < 6; j++) {
                out += "+--";
            }
            System.out.println(out + "+");

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 6; k++) {
                    System.out.print("|");

                    if (j == 0 || j == 2) {
                        switch (mat[i][k]) {
                            case "CW":
                                System.out.print(" ○");
                                break;
                            case "CB":
                                System.out.print(" ●");
                                break;
                            case "DW":
                                System.out.print("○ ");
                                break;
                            case "DB":
                                System.out.print("● ");
                                break;
                            default:
                                System.out.print("  ");
                                break;
                        }
                    } else {
                        switch (mat[i][k]) {
                            case "CW":
                                System.out.print("○ ");
                                break;
                            case "CB":
                                System.out.print("● ");
                                break;
                            case "DW":
                                System.out.print(" ○");
                                break;
                            case "DB":
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
        String out = "";
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
                    System.out.println("Valor fuera de rango");
                } else {
                    ok = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese solo numeros, por favor");
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
                    System.out.println("Valor fuera de rango");
                } else {
                    ok = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese texto, por favor");
                in.nextLine();
            }
        }
        return dato;
    }
}
