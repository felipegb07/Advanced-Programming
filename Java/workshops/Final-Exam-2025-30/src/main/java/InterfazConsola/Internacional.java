package InterfazConsola;

import java.time.LocalDate;
import java.util.TreeSet;

public class Internacional extends Vuelo {
    private RequisitoMigratorio requisitosVuelo;

    public Internacional(){}

    public Internacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, float valor, TreeSet<Pasajero> pasajeros, RequisitoMigratorio requisitosVuelo) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor, pasajeros);
        this.requisitosVuelo = requisitosVuelo;
    }

    @Override
    public float calcularValor(float valorBase){
        System.out.println("Ingrese el valor del impuesto");
        int impuesto = entradaDatos.nextInt();
        return valorBase + (valorBase * impuesto / 100);
    }

    public RequisitoMigratorio getRequisitosVuelo() { return requisitosVuelo; }
    public void setRequisitosVuelo(RequisitoMigratorio requisitosVuelo) { this.requisitosVuelo = requisitosVuelo; }
}

