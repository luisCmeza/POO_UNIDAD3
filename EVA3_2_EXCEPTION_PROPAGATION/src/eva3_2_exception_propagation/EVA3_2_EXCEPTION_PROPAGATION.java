/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_2_exception_propagation;

/**
 *
 * @author Usuario
 */
public class EVA3_2_EXCEPTION_PROPAGATION {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("inicia main");
        A();
        System.out.println("termina main");
    }
    
    public static void A(){
        System.out.println("INICIA A");
        B();
        System.out.println("TERMINA A");
    }
     public static void B(){
        System.out.println("INICIA B");
        C();
        System.out.println("TERMINA B");
    }
      public static void C(){
        System.out.println("INICIA C");
        int x =5, y =0;
        int resu = x/y;
          System.out.println("RESULTADO = " + resu);
        System.out.println("TERMINA C");
    }
}
