package InterfazConsola;

import jdk.internal.classfile.impl.AnnotationReader;

import java.time.LocalDate;
import java.util.Scanner;

public class Nacional extends Vuelo {
    /**Atributos*/
    private String tipoAeropuerto;
    private int impuesto;
    Scanner entradaDatos = new Scanner(System.in);
    /**Métodos*/
    /*Calcular valor teniendo en cuenta el tipo de aeropuerto que tengamos*/
    @Override
    public float calcularValor(float valor){
        System.out.println("---Ingrese el tipo de aeropuerto--\n\tGrande\n\tMediano\n\tPequeño");
        tipoAeropuerto = entradaDatos.nextLine();
        if(tipoAeropuerto.compareTo("Grande") == 0){
            System.out.println("Aeropuerto grande\nImpuesto 20%");
            impuesto = 20;
        }

        if(tipoAeropuerto.compareTo("Mediano") == 0) {
            System.out.println("Aeropuerto mediano\nImpuesto 10%");
            impuesto = 10;
        }

        if(tipoAeropuerto.compareTo("Pequeño") == 0){
            System.out.println("Aeropuerto pequeño\nImpuesto 5%");
            impuesto = 5;
        }
        valor =+ valor*impuesto /100;
        return valor;
    }
    /*Constructor*/

    public Nacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, int valor, String tipoAeropuerto) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor);
        this.tipoAeropuerto = tipoAeropuerto;
    }
}
