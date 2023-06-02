package eva3_10_escribir_archivos_texto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EVA3_10_ESCRIBIR_ARCHIVOS_TEXTO {

    public static void main(String[] args) {
        String ruta = "C:\\Docuentos\\";
        
        try {
            writeUsingFiles(ruta + "archivoFiles.txt", "Prueba de escritura de archivos \n" +
                                                       "Usando la clase Files");
            writeUsingFileWriter(ruta + "archivoFilerWriter.txt", "Prueba de escritura de archivos \n" + 
                                                                   "Usando la clase FileWriter");
            writeUsingBufferedWriter(ruta + "archivoBufferedWriter.txt", "Prueba de escritura de archivos \n" + 
                                                                   "Usando la clase BufferedWriter");
            
        }catch (IOException ex){
                Logger.getLogger(EVA3_10_ESCRIBIR_ARCHIVOS_TEXTO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void writeUsingFiles(String ruta, String datos) throws IOException{
        Path path = Paths.get(ruta);
        Files.write(path, datos.getBytes());
    }
    
    public static void writeUsingFileWriter(String ruta, String datos) throws IOException{
        File file = new File(ruta);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(datos);
        fileWriter.close();
    }
    
    public static void writeUsingBufferedWriter(String ruta, String datos) throws IOException{
        File file = new File(ruta);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter buffWriter = new BufferedWriter(fileWriter);
        for(int i = 0; i < 10; i++){
            buffWriter.write((i+1) +  " "  + datos);
            buffWriter.write("\n");
        }
        buffWriter.close();
        fileWriter.close();
    }
}
