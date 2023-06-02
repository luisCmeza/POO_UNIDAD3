package eva3_9_leer_archivos_txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class EVA3_9_LEER_ARCHIVOS_TXT {
    
    final static String RUTA = "C:\\Archivos\\Prueba.txt";
    
    public static void main(String[] args) {
        try{
            readUsingFiles(RUTA);
            readUsingBufferedReader(RUTA);
            readUsingFilesReader(RUTA); 
            readUsingScanner(RUTA); 
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
    }
    
    /* FILES: Se lee todo el contenido del archivo y se transfiere a memoria 
    principal (RAM) */
    //Es útil con archivos pequeños
    
    //Lee un archivo completo, "de jalón"
    //Ineficiente con archivos grandes porque trata de leerlo todo
    public static void readUsingFiles(String ruta) throws IOException{
        System.out.println("LEER UN ARCHIVO CON FILES");
        //Construímos la ruta en base a la cadena de texto
        Path path = Paths.get(ruta);
        /* List<String>  todasLineas = Files.readAllLines(path);
        System.out.println("Resultado: ");
        //System.out.println(todasLineas.toString());
        for(int i=0; i < todasLineas.size(); i++){
            System.out.println(todasLineas.get(i)); 
        } */
        
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes));
    }
    
    //Permite procesar archivos mas gradnes, ya que los lee por partes
    //Es un mecanismo adecuado para trabajar con multitareas (hilos)
    //En el caso de los archivos de texto, permite procesarlos linea por línea
    //Esta diseñado para leer archivos de texto
    public static void readUsingBufferedReader(String ruta) throws IOException{
        System.out.println("");
        System.out.println("LEER UN ARCHIVO CON BUFFERED READER");
        File file = new File(ruta);
        
        //Abre el archivo
        FileInputStream fileInputStream = new FileInputStream(file); 
        
        //Lee el aarchivo en bytes
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        
        //Procesa el archivo como texto
        BufferedReader buffReader = new BufferedReader(inputStreamReader);
        String linea;
        while((linea = buffReader.readLine()) != null){
            System.out.println(linea);
        }
        //Hay que cerrar los archivos una vez leídos
        buffReader.close();
    }
    
    //No es la mejor opción para ller archivos de texto
    //Híbrido con buffered, pero ineficiente
    //Es mejor usarlo para leer otro tipo de archivos
    public static void readUsingFilesReader(String ruta) throws IOException{
        System.out.println("");
        System.out.println("LEER UN ARCHIVO USANDO FILES READER");
        File file = new File(ruta);
        FileReader fileReader = new FileReader(file);
        BufferedReader buffReader = new BufferedReader(fileReader);
        String linea;
        while((linea = buffReader.readLine()) != null){
            System.out.println(linea);
        }
        //Hay qye cerrar los archivos una vez leídos
        buffReader.close();
        fileReader.close();
    }
    
    //Es una utilería mas general para lere inputs
    //Puede también ser usado para leer archivos de texto
    public static void readUsingScanner(String ruta) throws IOException{
        System.out.println("LEER UN ARCHIVO USANDO SCANNER");
        Path path = Paths.get(ruta);
        Scanner scanner = new Scanner(path);
        while(scanner.hasNextLine()){
            String linea = scanner.nextLine();
            System.out.println(linea);
        }
        scanner.close();
    }
}

