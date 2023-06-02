package eva3_14_append_objects;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EVA3_14_APPEND_OBJECTS {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        try {
            guardarObjetos(new Persona ("AAAA", "AAAA",10));
            guardarObjetos(new Persona ("BBBB", "BBBB",20));
            guardarObjetos(new Persona ("CCCC", "CCCC",30));
            guardarObjetos(new Persona ("DDDD", "DDDD",40));
            guardarObjetos(new Persona ("EEEE", "EEEE",50));
            
            //Ahora a leer
            leerObjetos();
        } catch (IOException ex) {
            Logger.getLogger(EVA3_14_APPEND_OBJECTS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public static void guardarObjetos(Persona perso) throws FileNotFoundException, IOException{
        FileOutputStream  abrirArch = new FileOutputStream("C:\\Documentos\\Variaspersonas.per", true);
        ObjectOutputStream outStream = new ObjectOutputStream(abrirArch);
        outStream.writeObject(perso);
        outStream.close();
    }
    
    public static void leerObjetos() throws FileNotFoundException, IOException, ClassNotFoundException{
        Persona perso = null;
        FileInputStream abrirArch = new FileInputStream("C:\\Documentos\\Variaspersonas.per");
        ObjectInputStream outStream = new ObjectInputStream(abrirArch);
        
        //Casting: de obect a persona
        try{
            Object obj = outStream.readObject();
            while(obj!= null){
                if(obj instanceof Persona){
                    perso = (Persona)obj;
                    System.out.println("Nombre: " + perso.getNombre());
                    System.out.println("Nombre: " + perso.getApellido());
                    System.out.println("Nombre: " + perso.getEdad());
                }
                obj = outStream.readObject(); //Siguiente objeto
            }
            
        }catch(EOFException ex){
            ex.printStackTrace();
        }
        
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

