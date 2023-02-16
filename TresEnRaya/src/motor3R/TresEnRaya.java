package motor3R;
import java.util.Random; //para xerar numeros aleatorios

public class TresEnRaya {
   private char[][] tableiro;

   public TresEnRaya(){
      tableiro= new char[3][3];
      for (int i = 0; i < tableiro.length; i++) {
         for (int j = 0; j < tableiro.length; j++) {
            setTableiro(i,j,' ');
         }
      }
   }

   public char[][] getTableiro() { //modificar para principio de ocultacion
      return tableiro; 
   }


   public char[][] setTableiro(int fila, int columna, char valor) {
      tableiro[fila][columna] = valor; //modifica unha posicion indicada do tableiro
      return tableiro;
  }
  

  public char[][] xogadaCPU(char[][] tableiro, char simboloCPU) { //XOGADA ORDENADOR
      Random rand = new Random();
  
      // xera posicións aleatorias
      int i = rand.nextInt(3);
      int j = rand.nextInt(3);
  
      // Comprobar si la posición está vacía
      if (tableiro[i][j] == ' ') {
          // A posición está vacía, meter el caracter
          tableiro[i][j] = simboloCPU;
      } else {
          // A posición non está vacía, xerar otra posición aleatoria
          xogadaCPU(tableiro, simboloCPU);
      }
      return tableiro;
  }

  public boolean haiTres(char[][] tableiro, char simboloCPU, char simboloPersoa) { //MIRAR SE HAI 3 EN LIÑA
   Boolean retorno=false;
   char ganador=' ';
   // Comprobar líneas
   for (int i = 0; i < 3; i++) {
       if (tableiro[i][0] != ' ' && tableiro[i][0] == tableiro[i][1] && tableiro[i][1] == tableiro[i][2]) {
         ganador=tableiro[i][0];
         retorno=true; 
       }
   }

   // Comprobar columnas
   for (int j = 0; j < 3; j++) {
       if (tableiro[0][j] != ' ' && tableiro[0][j] == tableiro[1][j] && tableiro[1][j] == tableiro[2][j]) {
         ganador=tableiro[0][j];
         retorno=true;
       }
   }

   // Comprobar diagonal 1
   if (tableiro[0][0] != ' ' && tableiro[0][0] == tableiro[1][1] && tableiro[1][1] == tableiro[2][2]) {
      ganador=tableiro[0][0];
       retorno=true;
   }

   // Comprobar diagonal 2
   if (tableiro[0][2] != ' ' && tableiro[0][2] == tableiro[1][1] && tableiro[1][1] == tableiro[2][0]) {
      ganador=tableiro[0][2];
       retorno=true;
   }
   if (ganador==simboloCPU){
      System.out.println("Sintoo, gaña a máquina");
   }
   else if  (ganador==simboloPersoa){
      System.out.println("Moi ben, gañastes");
   }
   // Non hai 3 en liña
   return retorno;
}
 
  public boolean tableiroCompleto(char[][] tableiro) {  //MIRAR SE O TABLEIRO ESTÁ COMPLETO
   for (int i = 0; i < 3; i++) {
       for (int j = 0; j < 3; j++) {
           if (tableiro[i][j] == ' ') {
               return false;
           }
       }
   }
   return true;
}







   


}
