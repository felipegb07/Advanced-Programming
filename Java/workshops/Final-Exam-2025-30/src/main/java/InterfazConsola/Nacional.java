package InterfazConsola;

import java.time.LocalDate;

public class Nacional extends Vuelo {
    /**Atributos*/
    private String tipoAeropuerto;

    /**Métodos*/
    @Override
    public float calcularValor(){

    }
    /*Constructor*/

    public Nacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, int valor, String tipoAeropuerto) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor);
        this.tipoAeropuerto = tipoAeropuerto;
    }
}
