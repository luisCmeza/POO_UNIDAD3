package eva3_4_multiples_excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author luis meza
 */
public class EVA3_4_MULTIPLES_EXCEPCIONES {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x, y;
        
     try{
         Scanner input = new Scanner(System.in);
        System.out.println("introduce el valor (entero) de x: ");
        x = input.nextInt();
        System.out.println("introduce el valor (entero) de y: ");
        y = input.nextInt();
        int resu = x/y;
        System.out.println("la division de " + x + "/" + y + " es: " + resu);
        
        System.out.println("programa terminado con exito");
    }catch(InputMismatchException e){
         System.out.println("la captura es incorrecta: " + e.getMessage());
    }catch(ArithmeticException e){
         System.out.println("no se puede dividir entre 0: "+ e.getMessage());
    }
    }
    }
