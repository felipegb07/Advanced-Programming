package InterfazConsola;

import java.time.LocalDate;
import java.util.TreeSet;

public abstract class Vuelo {
    private String origen;
    private String destino;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int numeroVuelo;
    private float valor;
    private TreeSet<Pasajero> pasajeros = new TreeSet<>(); // Inicializado siempre

    public Vuelo(){};

    public Vuelo(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int numeroVuelo, float valor, TreeSet<Pasajero> pasajeros) {
        this.origen = origen;
        this.destino = destino;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.numeroVuelo = numeroVuelo;
        this.valor = valor;
        this.pasajeros = pasajeros != null ? pasajeros : new TreeSet<>();
    }

    public abstract float calcularValor(float valorBase); // Ahora es abstracto puro

    public Pasajero buscarPasajero(String nombre){
        for(Pasajero p : pasajeros){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("---Pasajero encontrado---");
                return p;
            }
        }
        System.out.println("---Pasajero no encontrado---");
        return null;
    }

    public void eliminarPasajeroMenoresDeEdad(){
        pasajeros.removeIf(p -> p.obtenerEdad() < 18);
    }

    // Getters y Setters
    public TreeSet<Pasajero> getPasajeros() { return pasajeros; }
    public void setPasajeros(TreeSet<Pasajero> pasajeros) { this.pasajeros = pasajeros; }
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public LocalDate getFechaInicial() { return fechaInicial; }
    public void setFechaInicial(LocalDate fechaInicial) { this.fechaInicial = fechaInicial; }
    public LocalDate getFechaFinal() { return fechaFinal; }
    public void setFechaFinal(LocalDate fechaFinal) { this.fechaFinal = fechaFinal; }
    public int getNumeroVuelo() { return numeroVuelo; }
    public void setNumeroVuelo(int numeroVuelo) { this.numeroVuelo = numeroVuelo; }
    public float getValor() { return valor; }
    public void setValor(float valor) { this.valor = valor; }
}

