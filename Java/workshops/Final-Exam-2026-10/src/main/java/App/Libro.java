package App;

import java.util.Scanner;

public abstract class Libro {
    //Atributos
    private int codigo;
    private String titulo;
    private double precioBase;
    private int copiasLicenciadas;

    //Métodos pariculares de clase
    public Libro(int codigo, String titulo, double precioBase, int copiasLicenciadas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.copiasLicenciadas = copiasLicenciadas;
    }

    public double calcularPrecio(Scanner entrada){}

    //Mpetodos para aplicaión de encapsulamiento
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getCopiasLicenciadas() {
        return copiasLicenciadas;
    }

    public void setCopiasLicenciadas(int copiasLicenciadas) {
        this.copiasLicenciadas = copiasLicenciadas;
    }
}
