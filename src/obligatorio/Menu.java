package obligatorio;

// Autores: Santiago Quintana (327886), Octavio Sosa (363131)

public class Menu {
    public void imprimirTablero(String[][] mat){
      try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException ex) {
            System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
      
        for (int i = 0; i < 3; i++) {
            
          String out=""; 
          for (int j = 0; j < 6; j++) {
            out+="+--";
          }
          System.out.println(out+"+");
            
          for (int j=0; j<3; j++){
              for (int k = 0; k < 6; k++){
                  System.out.print("|");
                    
                  if (j==0 || j==2){
                      switch (mat[i][k]){
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
                  }
                  else{
                      switch (mat[i][k]){
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
      String out="";
      for (int j = 0; j < 6; j++) {
          out+="+--";
      }
      System.out.println(out+"+");
  }
}
