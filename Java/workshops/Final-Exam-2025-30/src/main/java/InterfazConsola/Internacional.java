package InterfazConsola;

import java.time.LocalDate;

public class Internacional extends Vuelo {
    /**Atributos*/
    private int impuesto;

    /**Métodos*/
    /*Constructores*/
    public Internacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, int valor, int impuesto) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor);
        this.impuesto = impuesto;
    }

    /*Calcular valor*/
    @Override
    public float calcularValor(){

    }
}
