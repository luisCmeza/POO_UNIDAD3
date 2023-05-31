package eva3_8_custom_exceptions;

/**
 * @author LUIS C.
 */
public class EVA3_8_CUSTOM_EXCEPTIONS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona perso = new Persona();
        perso.setNombre("juan");
        perso.setApellido("perez");
        try{
        perso.setEdad(-10);
        }catch(DatoEntradaCheckedEx e){
            System.out.println(e.getMessage());    
        }
    }
    
}

class Persona{
    private String nombre;
    private String apellido;
    private int edad;

    public Persona() {
        nombre = "---------";
        apellido = "---------";
        edad =000 ;
    }

    public Persona(String nombre, String apellido, int edad) throws DatoEntradaCheckedEx {
        this.nombre = nombre;
        this.apellido = apellido;
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws DatoEntradaCheckedEx {
        if(edad<0)
          //  throw new DatoEntradaException();//uncheckd
            throw new DatoEntradaCheckedEx();
        this.edad = edad;
    }
    
    
}

        
   class DatoEntradaException extends RuntimeException{
       public DatoEntradaException(){
           super("Dato de entrada incorrecto!! El valor debe ser psitivo");
       }
   }


 class DatoEntradaCheckedEx extends Exception{

    public DatoEntradaCheckedEx() {
           super("Dato de entrada incorrecto!! El valor debe ser positivo");
    }
     
 }