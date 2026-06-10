package App;

import java.util.Scanner;

public class LibroDigital extends Libro{
    private double descuento;

    //Métodos particulares de la clase especifica

    public LibroDigital(int codigo, String titulo, double precioBase, int copiasLicenciadas, double descuento) {
        super(codigo, titulo, precioBase, copiasLicenciadas);
        this.descuento = descuento;
    }

    @Override
    public double calcularPrecio(Scanner entrada){
        Double preciototal = 0.0;
        System.out.println("Ingrese el valor del descuento: ");
        descuento = entrada.nextDouble();
        entrada.nextLine();

        //Aquí podemos generar una excepción para poder implementar la parte del descuento :)
        return preciototal;
    }

    //Métodos generales de la clase
    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
