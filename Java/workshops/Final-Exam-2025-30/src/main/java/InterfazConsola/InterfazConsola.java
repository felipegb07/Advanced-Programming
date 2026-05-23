package InterfazConsola;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.TreeSet;

public class InterfazConsola implements Serializable {
    // Buena práctica: Identificador de versión para la serialización
    private static final long serialVersionUID = 1L;
    private static final String ARCHIVO = "datos.dat";

    // Scanner global para toda la instancia de la interfaz
    private final Scanner entradaDatos = new Scanner(System.in);

    public static void main(String[] args) {
        // Instancia para acceder a los métodos no estáticos
        InterfazConsola interfaz = new InterfazConsola();
        Aerolinea datosAerolinea = new Aerolinea();
        Scanner entrada = interfaz.entradaDatos;

        System.out.println("--- Datos iniciales ---");
        System.out.print("Ingrese el nombre de la aerolinea: ");
        datosAerolinea.setNombre(entrada.nextLine());

        // ==========================================
        // 1. REGISTRO DE VUELOS
        // ==========================================
        System.out.print("Ingrese la cantidad de vuelos: ");
        int cantVuelos = entrada.nextInt();
        entrada.nextLine(); // Limpieza del salto de línea

        for (int i = 0; i < cantVuelos; i++) {
            System.out.println("\n--- Registro de Vuelo " + (i + 1) + " ---");
            System.out.println("Ingrese el tipo de vuelo \n\t(N) Nacional - (I) Internacional");
            String tipoVuelo = entrada.nextLine().toUpperCase();

            if (tipoVuelo.equals("N")) {
                System.out.println("--- Vuelo Nacional ---");
                Vuelo vueloNacional = interfaz.llenadoParametros(new Nacional());
                datosAerolinea.getVuelosAerolinea().add(vueloNacional);

            }else if (tipoVuelo.equals("I")) {
            System.out.println("--- Vuelo Internacional ---");

            Internacional vueloInternacional = new Internacional();

            interfaz.llenadoParametros(vueloInternacional);

            System.out.print("¿El vuelo tiene requisitos migratorios? (S/N): ");
            String requisitos = entrada.nextLine().toUpperCase();

            if (requisitos.equals("S")) {
                System.out.print("Ingrese el requisito migratorio: ");
                String reqTexto = entrada.nextLine();
                vueloInternacional.setRequisitoMigratorio(reqTexto);
            }

            // 4. Se agrega al TreeSet de la aerolínea
            datosAerolinea.getVuelosAerolinea().add(vueloInternacional);

        } else {
                System.out.println("Opción inválida. Intente de nuevo.");
                i--;
            }
        }

        TreeSet<Pasajero> pasajeros = interfaz.registrarPasajeros();
        guardarAerolinea(datosAerolinea);

        interfaz.entradaDatos.close();
    }

    public Vuelo llenadoParametros(Vuelo vueloCompleto) {
        System.out.print("Ingrese el origen: ");
        vueloCompleto.setOrigen(entradaDatos.nextLine());

        System.out.print("Ingrese el destino: ");
        vueloCompleto.setDestino(entradaDatos.nextLine());

        vueloCompleto.setFechaInicial(leerFecha("Ingrese la fecha de inicio (AAAA-MM-DD): "));
        vueloCompleto.setFechaFinal(leerFecha("Ingrese la fecha de finalización (AAAA-MM-DD): "));

        System.out.print("Ingrese el numero del vuelo: ");
        vueloCompleto.setNumeroVuelo(entradaDatos.nextInt());

        System.out.print("Ingrese el valor del vuelo: ");
        vueloCompleto.setValor(entradaDatos.nextFloat());
        entradaDatos.nextLine(); // Limpieza de flujo crucial para los siguientes textos

        return vueloCompleto;
    }

    public TreeSet<Pasajero> registrarPasajeros() {
        TreeSet<Pasajero> listaPasajeros = new TreeSet<>();
        System.out.print("\nIngrese la cantidad de pasajeros: ");
        int cantPasajeros = entradaDatos.nextInt();
        entradaDatos.nextLine(); // Limpieza del salto de línea

        for (int i = 0; i < cantPasajeros; i++) {
            System.out.println("\n--- Datos del Pasajero " + (i + 1) + " ---");
            System.out.print("Ingrese el nombre: ");
            String nombre = entradaDatos.nextLine();

            System.out.print("Ingrese el id: ");
            int id = entradaDatos.nextInt();
            entradaDatos.nextLine(); // Limpieza

            LocalDate fechaNacimiento = leerFecha("Ingrese la fecha de nacimiento (AAAA-MM-DD): ");

            System.out.print("Ingrese el numero de silla: ");
            int numSillas = entradaDatos.nextInt();
            entradaDatos.nextLine(); // Limpieza final del ciclo

            listaPasajeros.add(new Pasajero(nombre, id, fechaNacimiento, numSillas));
        }
        return listaPasajeros;
    }

    private LocalDate leerFecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(entradaDatos.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor use el formato AAAA-MM-DD.");
            }
        }
    }

    public static void guardarAerolinea(Aerolinea datosAerolinea) {
        try (ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            escritura.writeObject(datosAerolinea);
            System.out.println("\n¡Datos guardados correctamente en " + ARCHIVO + "!");
        } catch (IOException e) {
            System.err.println("Error crítico al escribir en el archivo: " + e.getMessage());
        }
    }
}

