import java.util.Scanner;

/**
 * ******************************************************
 *
 * Programa que resuelve el siguiente problema:
 * Dado un número 1 <= N <= 10^{9}
 * Encuentra el número más pequeño mayor que N que
 * tiene el mismo número de bits encendidos que él
 * Es decir, el mismo número de 1's en su presentación
 * binario.
 *
 * ******************************************************
 *
 * @author Derian Estrada
 *
 * ******************************************************
 */
public class Bits{

   /**
    * Cuenta los bits encendidos de un número
    * @param num el número al cual se calculará los bits
    *        encendidos
    * @return la cantidad de bits encendidos
    */
   private static int bitsEncendidos(String num){      
      int bits = 0;
      int i = 0;

      while(i<num.length()){

         if(num.charAt(i)=='1')
            bits+= 1;

         i++;
      }

      return bits;
   }

   /**
    * Compara los bits encendidos de dos números
    * Dado un número, se buscará su mínimo sucesor tal que
    * tenga la misma cantidad de bits encendidos.
    * @param n el número a partir del cual comenzaremos
    *          a buscar
    * @param n_bits la cantidad de bits encendidos del
    *               número dado
    * @return num_encontrado el número encontrado con las
    *                        condiciones requeridas
    */
   private static int comparaBits(int n, int n_bits, int num_encontrado){

      String i_bin = decimalToBinario(n, "");
      int i_bits = bitsEncendidos(i_bin);

      if(n_bits==i_bits){
         num_encontrado = n;
         return num_encontrado;
      }

      return comparaBits(n+1, n_bits, 0);

   }

   /**
    * Convierte un número decimal a su forma en binario
    * @param n el número que convertiremos a binario
    * @return s el número convertido en binario
    */
   private static String decimalToBinario(int n, String s){
      int m=0;
      
      if(n<=1){
         s+= Integer.toString(n);
         return reversa(s, "");
      }
      m=n%2;
      s+= Integer.toString(m);
      return decimalToBinario(n >> 1, s);
   }

   /**
    * Da la reversa de una cadena
    * @param s la cadena que vamos a transformar
    * @return r la cadena en reversa
    */
   private static String reversa(String s, String r){
      if(s.length()==0)
         return r;

      r+=s.charAt(s.length()-1);
      return reversa(s.substring(0,s.length()-1),r);
   }

    /* Método Main */
    public static void main(String[] args) {

      int[] numeros;
      Scanner sc = new Scanner(System.in);

      /* Pide el número de casos al usuario */
      System.out.print("Número de casos: ");
      int casos = sc.nextInt();

      if(casos > Math.pow(10,9)){
         System.exit(0);
      }

      numeros = new int[casos];

      /* Crea un arreglo con los números
         ingresados por el usuario*/
      for (int i=0; i<casos; i++ ){
         System.out.print("Número: ");
         numeros[i] = sc.nextInt();
      }
   
      System.out.println('\n');
   
      /* Imprime el resultado */
      for(int i = 0; i<casos; i++){
         String num_bin = decimalToBinario(numeros[i], "");
         int num_bits = bitsEncendidos(num_bin);
         int num_sig = comparaBits(numeros[i]+1, num_bits, 0);
         System.out.println(numeros[i]+" -> "+num_sig);
      }  
   }

}
