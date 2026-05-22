package InterfazConsola;

import java.time.LocalDate;
import java.util.Scanner;

public class Internacional extends Vuelo {
    /**Atributos*/
    Scanner entradaDatos = new Scanner(System.in);
    /**Métodos*/
    /*Constructores*/
    public Internacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, int valor, int impuesto) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor);
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
