package InterfazConsola;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public abstract class Vuelo {
    /**Atributos*/
    private String origen;
    private String destino;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int numeroVuelo;
    private float valor;
    private TreeSet<Pasajero> pasajeros;
    Scanner entradaDatos = new Scanner(System.in);

    /**Métodos*/
    /*Constructor vacío*/
    public Vuelo(){};

    public Vuelo(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, float valor, TreeSet<Pasajero> pasajeros) {
        this.origen = origen;
        this.destino = destino;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.numeroVuelo = numeroVuelo;
        this.valor = valor;
        this.pasajeros = pasajeros;
    }

    /*Calulo de valor*/
    public float calcularValor(float valor){return valor;}

    /*Busqueda pasajero*/
    public Pasajero buscarPasajero(String nombre){
        System.out.println("Ingrese el nombre del pasajero: ");
        for(Pasajero p : pasajeros){
            if(p.getNombre().equals(nombre)){
                System.out.println("---Pasajero encontrado---");
                return p;
            }
        }
        System.out.println("---Pasajero no encontrado---");
        return null;
    }


    /*Esta parte del código quiero aclarar que fue apoyo de IA porque me arrojaba un error al momento de borrar
     * pasajeros en mi código anterior
    public void eliminarPasajeroMenoresDeEdad(Pasajero datosPasajero){
        for(Pasajero p: pasajeros){
            if(p.calcularEdad() < 18){
                pasajeros.remove(p);
            }
        }
    }*/

    /*Eliminar pasajero menor de edad*/
    public void eliminarPasajeroMenoresDeEdad(){
        // Elimina automáticamente cualquier pasajero cuyo cálculo de edad sea menor a 18
        pasajeros.removeIf(p -> p.calcularEdad() < 18);
    }

    /*Getters y setters*/

    public TreeSet<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(TreeSet<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "valor=" + valor +
                ", numeroVuelo=" + numeroVuelo +
                ", fechaFinal=" + fechaFinal +
                ", fechaInicial=" + fechaInicial +
                ", destino='" + destino + '\'' +
                ", origen='" + origen + '\'' +
                '}';
    }
}
