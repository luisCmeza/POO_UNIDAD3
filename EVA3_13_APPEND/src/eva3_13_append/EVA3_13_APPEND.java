package eva3_13_append;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EVA3_13_APPEND {

    public static void main(String[] args) {
        String ruta = "C:\\Documentos\\";
        
        try {
            writeUsingBufferedWriter(ruta + "archivoBufferedWriter.txt", "Prueba de escritura de archivos \n" + 
                                                                   "Usando la clase BufferedWriter");
            
        }catch (IOException ex){
                ex.printStackTrace(); //Imprime la excepción que se genera
        }
        
        
    }
    
    public static void writeUsingBufferedWriter(String ruta, String datos) throws IOException{
        File file = new File(ruta);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        for(int i = 0; i < 10; i++){
            buffWriter.write((i+1) +  " "  + datos);
            buffWriter.write("\n");
        }
        buffWriter.close();
        fileWriter.close();
    }
}
    

