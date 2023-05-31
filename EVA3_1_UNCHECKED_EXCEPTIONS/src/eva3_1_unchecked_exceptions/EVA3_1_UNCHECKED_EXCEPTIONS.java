package eva3_1_unchecked_exceptions;

import java.util.Scanner;

/**
 * @author LUIS MEZA
 */
public class EVA3_1_UNCHECKED_EXCEPTIONS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // SON TODAS RUNTIMEEXCEPTION
        
        //ARITHMETIC EXCEPTION:
        //division entre cero
       System.out.println("INICIANDO EL PROGRAMA");
        int x=5, y=0;
        System.out.println("INICIALIZANDO LAS VARIABLES");
        int resu = x/y;
        System.out.println("CALCULANDO LA DIVISIÓN");
        System.out.println("División = " + resu);
       
       
       //IMPUTMISMATCHEXCEPTION: ERROR DE CAPTURA DE DATOS
        Scanner input = new Scanner(System.in);
        System.out.println("introduce un numero:");
        int nume= input.nextInt();
        System.out.println("tu numero es: " + nume);
               
      //LNDEXOUTOFBOUNDS EXCEPTION
               int[] arreglo = new int [5];//0 - (N - 1)              
               arreglo[0] = 100;
               arreglo[1] = 200;
               arreglo[2] = 300;
               arreglo[3] = 400;
               arreglo[4] = 500;
               arreglo[5] = 600; //error de logica: 5 no es posicion valida
       
            
      //NULLPOINTER EXCEPTION
      Prueba objPrueba = null;
        System.out.println("Valaor de x = " + objPrueba.x);
    }
    
}


class Prueba{
    public int x;
}
