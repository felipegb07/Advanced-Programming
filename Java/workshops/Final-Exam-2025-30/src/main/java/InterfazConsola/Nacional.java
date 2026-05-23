package InterfazConsola;

import java.time.LocalDate;
import java.util.TreeSet;

public class Nacional extends Vuelo {
    private String tipoAeropuerto;
    private int impuesto;

    public Nacional(){};

    public Nacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, float valor, TreeSet<Pasajero> pasajeros, String tipoAeropuerto, int impuesto) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor, pasajeros);
        this.tipoAeropuerto = tipoAeropuerto;
        this.impuesto = impuesto;
    }

    @Override
    public float calcularValor(float valorBase){
        // Evitamos capturar datos aquí. Asumimos que 'tipoAeropuerto' ya fue seteado en la interfaz
        if(tipoAeropuerto != null) {
            switch (tipoAeropuerto.toUpperCase()) {
                case "GRANDE": impuesto = 20; break;
                case "MEDIANO": impuesto = 10; break;
                case "PEQUEÑO": impuesto = 5; break;
                default: impuesto = 0;
            }
        }
        return valorBase + (valorBase * impuesto / 100);
    }
}

