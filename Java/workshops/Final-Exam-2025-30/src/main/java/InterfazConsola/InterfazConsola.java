package InterfazConsola;

import sun.reflect.generics.tree.Tree;
import java.io.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.TreeSet;

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
        InterfazConsola interfaz = new InterfazConsola(); //Curioso esto para poder hacer el llenado
        //Variables
        Aerolinea datosAerolinea = new Aerolinea(); //Creamos la aerolinea


        //Entrada de datos
        Scanner entrada = new Scanner(System.in);
        System.out.println("---Datos iniciales---");
        System.out.println("Ingrese el nombre de la aerolinea: ");
        String nombreAerolinea = entrada.nextLine();

        System.out.println("Ingrese la cantidad de vuelos: ");
        int cantVuelos = entrada.nextInt();
        for(int i = 0; i < cantVuelos; i++){
            System.out.println("Ingrese el tipo de vuelo \n\t(N)Nacional - (I)Internacional");
            String tipoVuelo = entrada.nextLine().toUpperCase();
            if(tipoVuelo.compareTo("N") == 0){
                System.out.println("---Vuelo Nacional---");
                Vuelo vueloNacional = new Nacional();
                vueloNacional = interfaz.llenadoParametros(vueloNacional);
                vuelosGenerales.add(vueloNacional);
            }else if(tipoVuelo.compareTo("I") == 0){
                System.out.println("---Vuelo internacional---");
                Vuelo vueloInternacional = new Internacional();
                vueloInternacional = interfaz.llenadoParametros(vueloInternacional);
                vuelosGenerales.add(vueloInternacional);
            }
        }

        System.out.println("Ingrese la cantidad de pasajeros");
        int cantPasajeros = entrada.nextInt();
        for(int i = 0; i < cantPasajeros; i++){
            System.out.println("Ingrese el nombre: ");
            String nombre = entrada.nextLine();

            System.out.println("Ingrese la edad: ");
            int edad = entrada.nextInt();

            System.out.println("Ingrese la fecha de nacimieno en este formato AAAA-MM-DD");
            String fechaNac = entrada.nextLine();
            LocalDate fechaNacimento = LocalDate.parse(fechaNac);

            System.out.println("Ingrese el numero de sillas por pasajero?");
            int numSillas = entrada.nextInt();
        }
    }

    public Vuelo llenadoParametros(Vuelo vueloCompleto){
        System.out.println();
        System.out.println("Ingrese el origen");
        String origen = entradaDatos.nextLine();

        System.out.println("Ingrese el destino");
        String destino = entradaDatos.nextLine();

        System.out.println("Ingrese la fecha de inicio en este formato AAAA-MM-DD");
        String fechaIni = entradaDatos.nextLine();
        LocalDate fechaInicio = LocalDate.parse(fechaIni);

        System.out.println("Ingrese la fecha de finalización en este formato AAAA-MM-DD");
        String fechaFin = entradaDatos.nextLine();
        LocalDate fechaFinal = LocalDate.parse(fechaFin);

        System.out.println("Ingrese el numero del vuelo");
        int numeroVuelo = entradaDatos.nextInt();

        System.out.println("Ingrese el valor del vuelo");
        float valorVuelo = entradaDatos.nextFloat();

        vueloCompleto.setOrigen(origen);
        vueloCompleto.setDestino(destino);
        vueloCompleto.setFechaInicial(fechaInicio);
        vueloCompleto.setFechaFinal(fechaFinal);
        vueloCompleto.setNumeroVuelo(numeroVuelo);
        vueloCompleto.setValor(valorVuelo);

        return vueloCompleto;
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
