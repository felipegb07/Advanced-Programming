package InterfazConsola;

import java.time.LocalDate;

public abstract class Vuelo {
    /**Atributos*/
    private String origen;
    private String destino;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int numeroVuelo;
    private int valor;

    /**Métodos*/
    /*Constructor*/
    public Vuelo(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, int valor) {
        this.origen = origen;
        this.destino = destino;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.numeroVuelo = numeroVuelo;
        this.valor = valor;
    }

    /*Calulo de valor*/
    public float calcularValor(){

    }

    /*Busqueda pasajero*/i
    public Pasajero buscarPasajero(String nombre){

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

    public void setValor(int valor) {
        this.valor = valor;
    }
}
