package eva3_12_serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EVA3_12_SERIALIZABLE {

    public static void main(String[] args) {  
        try {
            Persona perso = new Persona("Branan", "Chavos", 4);
            guardarObjetos(perso);
            Persona resu = leerObjetos();
            System.out.println("Nombre: " + resu.getNombre());
            System.out.println("Apellido : " + resu.getApellido());
            System.out.println("Edad: " + resu.getEdad());
            
        } catch (IOException ex) {
            Logger.getLogger(EVA3_12_SERIALIZABLE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EVA3_12_SERIALIZABLE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void guardarObjetos(Persona perso) throws FileNotFoundException, IOException{
        FileOutputStream  abrirArch = new FileOutputStream("C:\\Documentos\\personas.per");
        ObjectOutputStream outStream = new ObjectOutputStream(abrirArch);
        outStream.writeObject(perso);
        outStream.close();
    }
    public static Persona leerObjetos() throws FileNotFoundException, IOException, ClassNotFoundException{
        Persona perso = null;
        FileInputStream abrirArch = new FileInputStream("C:\\Documentos\\personas.per");
        ObjectInputStream outStream = new ObjectInputStream(abrirArch);
        
        //Casting: de obect a persona
        perso = (Persona) outStream.readObject();
        return perso;
    }
}

class Persona implements Serializable{
    private String nombre;
    private String apellido;
    private int edad;
    
    
    public Persona(){
        this.nombre = "----";
        this.apellido = "----";
        this.edad = 0;
    }
    
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
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

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}
