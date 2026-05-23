package InterfazConsola;

import com.sun.tools.jdeprscan.scan.Scan;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeSet;

public class Internacional extends Vuelo {
    private String requisitoMigratorio;
    Scanner entradaDatos = new Scanner(System.in);

    public Internacional(){}

    public Internacional(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, float valor, TreeSet<Pasajero> pasajeros, String requisitoMigratorio) {
        super(origen, destino, fechaInicial, fechaFinal, numeroVuelo, valor, pasajeros);
        this.requisitoMigratorio = requisitoMigratorio;
    }

    @Override
    public float calcularValor(float valorBase){
        System.out.println("Ingrese el valor del impuesto");
        int impuesto = entradaDatos.nextInt();
        return valorBase + (valorBase * impuesto / 100);
    }

    public String getRequisitoMigratorio() { return requisitoMigratorio; }
    public void setRequisitoMigratorio(String requisitoMigratorio) { this.requisitoMigratorio = requisitoMigratorio; }
}

