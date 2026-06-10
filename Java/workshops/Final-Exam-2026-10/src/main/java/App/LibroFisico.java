package App;

import java.util.Scanner;

public class LibroFisico extends Libro{
    //atributos de la clase
    private double costoEnvio;

    //Métodos particulares de la clase
    public LibroFisico(int codigo, String titulo, double precioBase, int copiasLicenciadas, double costoEnvio) {
        super(codigo, titulo, precioBase, copiasLicenciadas);
        this.costoEnvio = costoEnvio;
    }

    @Override
    public double calcularPrecio(Scanner entrada){
        Double precioFinal = 0.0;

        return precioFinal;
    }
}
