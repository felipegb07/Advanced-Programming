package InterfazConsola;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pasajero implements Comparable<Pasajero> {
    private String nombre;
    private int id;
    private LocalDate fechaNacimiento;
    private int numSillas;

    public Pasajero(){}

    public Pasajero(String nombre, int id, LocalDate fechaNacimiento, int numSillas) {
        this.nombre = nombre;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.numSillas = numSillas;
    }

    public long obtenerEdad(){
        System.out.println("Su edad es: " + ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now()));
        return ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
    }

    @Override // Requerido para que funcione en un TreeSet
    public int compareTo(Pasajero otro) {
        return Integer.compare(this.id, otro.id);
    }

    // Getters y Setters standard...
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public int getNumSillas() { return numSillas; }
    public void setNumSillas(int numSillas) { this.numSillas = numSillas; }

    @Override
    public String toString() {
        return "Pasajero{id=" + id + ", nombre='" + nombre + "'}";
    }
}

