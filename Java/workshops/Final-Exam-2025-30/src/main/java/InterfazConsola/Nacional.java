package InterfazConsola;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeSet;

public class Nacional extends Vuelo {
    /**Atributos*/
    private String tipoAeropuerto;
    private int impuesto;
    Scanner entradaDatos = new Scanner(System.in);
    public Nacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, float valor, TreeSet<Pasajero> pasajeros, String tipoAeropuerto, int impuesto) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor, pasajeros);
        this.tipoAeropuerto = tipoAeropuerto;
        this.impuesto = impuesto;
    }

    /*Métodos*/
    @Override
    public float calcularValor(float valor){
        System.out.println("---Ingrese el tipo de aeropuerto--\n\tGrande\n\tMediano\n\tPequeño");
        tipoAeropuerto = entradaDatos.nextLine().toUpperCase();
        if(tipoAeropuerto.compareTo("GRANDE") == 0){
            System.out.println("Aeropuerto grande\nImpuesto 20%");
            impuesto = 20;
        }

        if(tipoAeropuerto.compareTo("MEDIANO") == 0) {
            System.out.println("Aeropuerto mediano\nImpuesto 10%");
            impuesto = 10;
        }

        if(tipoAeropuerto.compareTo("PEQUEÑO") == 0){
            System.out.println("Aeropuerto pequeño\nImpuesto 5%");
            impuesto = 5;
        }
        valor =+ valor*impuesto /100;
        return valor;
    }
}
