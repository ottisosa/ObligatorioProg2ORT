package obligatorio;

// Autores: Santiago Quintana (327886), Octavio Sosa (363131)

public class Obligatorio {
    public static void main(String[] args) {
        
        Sistema sistema = new Sistema();
        String [][] mat = {{"","","","CN","",""},{"","","","","",""},{"CN","CB","DN","DB","DB","CN"}};
        
        Menu menu = new Menu(sistema);
        menu.menuInicial();
        Menu.imprimirTablero(mat);
    }
}

