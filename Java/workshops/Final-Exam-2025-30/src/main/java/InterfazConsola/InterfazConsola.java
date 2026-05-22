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
    /* Método principal corregido */
    public static void main( String[] args ){
        // Usamos un único objeto de la interfaz para acceder a métodos no estáticos
        InterfazConsola interfaz = new InterfazConsola();

        // Creamos la aerolínea
        Aerolinea datosAerolinea = new Aerolinea();

        // Entrada de datos unificada
        Scanner entrada = interfaz.entradaDatos;

        System.out.println("---Datos iniciales---");
        System.out.println("Ingrese el nombre de la aerolinea: ");
        String nombreAerolinea = entrada.nextLine();
        datosAerolinea.setNombre(nombreAerolinea);

        System.out.println("Ingrese la cantidad de vuelos: ");
        int cantVuelos = entrada.nextInt();
        entrada.nextLine(); // 🔥 Limpieza: absorbe el salto de línea del entero

        for(int i = 0; i < cantVuelos; i++){
            System.out.println("Ingrese el tipo de vuelo \n\t(N)Nacional - (I)Internacional");
            String tipoVuelo = entrada.nextLine().toUpperCase();

            if(tipoVuelo.equals("N")){
                System.out.println("---Vuelo Nacional---");
                Vuelo vueloNacional = new Nacional();
                vueloNacional = interfaz.llenadoParametros(vueloNacional);

                // 🔥 Se agrega directamente al TreeSet interno de la aerolínea
                datosAerolinea.getVuelosAerolinea().add(vueloNacional);

            } else if(tipoVuelo.equals("I")){
                System.out.println("---Vuelo internacional---");
                Vuelo vueloInternacional = new Internacional();
                vueloInternacional = interfaz.llenadoParametros(vueloInternacional);

                // 🔥 Se agrega directamente al TreeSet interno de la aerolínea
                datosAerolinea.getVuelosAerolinea().add(vueloInternacional);
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
                i--; // Repetir iteración si se equivoca de letra
            }
        }

        /**Datos pasajeros*/
        System.out.println("Ingrese la cantidad de pasajeros");
        int cantPasajeros = entrada.nextInt();
        entrada.nextLine(); // 🔥 Limpieza del entero anterior

        /*LLenado de datos*/
        TreeSet<Pasajero> pastajeros = new TreeSet<Pasajero>();
        for(int i = 0; i < cantPasajeros; i++){
            System.out.println("\n--- Datos del Pasajero " + (i+1) + " ---");
            System.out.println("Ingrese el nombre: ");
            String nombre = entrada.nextLine(); // Ya no se lo saltará

            System.out.println("Ingrese el id: ");
            int id = entrada.nextInt();
            entrada.nextLine(); //Limpieaz salto de linea

            System.out.println("Ingrese la fecha de nacimiento en este formato AAAA-MM-DD");
            String fechaNac = entrada.nextLine();
            LocalDate fechaNacimiento = LocalDate.parse(fechaNac);

            System.out.println("Ingrese el numero de sillas por pasajero:");
            int numSillas = entrada.nextInt();
            entrada.nextLine(); // 🔥 Limpieza final del ciclo
            Pasajero pasajeroNuevo = new Pasajero(nombre, id, fechaNacimiento, numSillas);
            pasajeros.add(pasajeroNuevo);
        }

        /*Asignación de vuelos por pasajero*/
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
        entradaDatos.nextLine(); // 🔥 Limpieza crucial para que el bucle principal continúe bien

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
