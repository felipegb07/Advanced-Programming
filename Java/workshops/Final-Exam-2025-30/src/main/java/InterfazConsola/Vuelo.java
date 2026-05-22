package InterfazConsola;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;

public abstract class Vuelo {
    /**Atributos*/
    private String origen;
    private String destino;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int numeroVuelo;
    private float valor;
    Scanner entradaDatos = new Scanner(System.in);

    /**Métodos*/
    /*Constructor*/
    public Vuelo(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, float valor) {
        this.origen = origen;
        this.destino = destino;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.numeroVuelo = numeroVuelo;
        this.valor = valor;
    }

    /*Calulo de valor*/
    public float calcularValor(float valor){return valor;}

    /*Busqueda pasajero*/
    public Pasajero buscarPasajero(String nombre){
        System.out.println("Ingrese el nombre del pasajero: ");
        String nombrePasajero = entradaDatos.nextLine();

    }

    /*Eliminar pasajero menor de edad*/
    public void eliminarPasajeroMenoresDeEdad(){

    }

    /*Getters y setters*/
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(int numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
