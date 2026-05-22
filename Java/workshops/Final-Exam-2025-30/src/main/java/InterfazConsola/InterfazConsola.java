package InterfazConsola;

import java.io.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class InterfazConsola implements Serializable {
    private static final String archivo = "datos.dat";
    Scanner entradaDatos = new Scanner(System.in);
    /**Métodos de la interfaz consola*/
    /*Método principal*/
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
    }

    /*Método para guardar la aerolinea*/
    public static void guardarAerolinea(Aerolinea datosAerolinea) throws IOException {
        try(ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(archivo))){
            escritura.writeObject(datosAerolinea);
            System.out.println("Escritura corrrecta");
        }catch (IOException e){
            System.out.println("Error al momento de hacer la escritura en el archivo");
        }
    }
}
