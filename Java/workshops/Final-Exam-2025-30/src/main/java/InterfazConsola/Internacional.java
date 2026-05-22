package InterfazConsola;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeSet;

public class Internacional extends Vuelo {
    /**Atributos*/
    Scanner entradaDatos = new Scanner(System.in);
    private RequisitoMigratorio requisitosVuelo;

    public Internacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, float valor, TreeSet<Pasajero> pasajeros, Scanner entradaDatos, RequisitoMigratorio requisitosVuelo) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor, pasajeros);
        this.entradaDatos = entradaDatos;
        this.requisitosVuelo = requisitosVuelo;
    }

    /*Calcular valor teniendo en cuenta el impuesto ingresado*/
    @Override
    public float calcularValor(float valor){
        System.out.println("Ingrese el porcentaje del impueto sobre el valor inicial del vuelo: ");
        int impuesto = entradaDatos.nextInt();
        valor =+ valor*impuesto /100;
        return valor;
    }
}
