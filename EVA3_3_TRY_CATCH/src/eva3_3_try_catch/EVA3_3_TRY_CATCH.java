/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_3_try_catch;

/**
 *
 * @author Usuario
 */
public class EVA3_3_TRY_CATCH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x=5, y=0;
        try {
            //seccion de codigo que potenciamente genera
            //una excepción
            int resu =x/y;
            System.out.println("el resultado es = " + resu);
        }catch(ArithmeticException e){
            //se genera un objeto excpetion llamado "e"
            //de tipo ArthmeticException
            System.out.println("excepción: " + e.getMessage());
        }
        System.out.println("fin del programa");
        
        
    }
    
}
