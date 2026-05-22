package InterfazConsola;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pasajero {
    /**Atributos*/
    private String nombre;
    private int id;
    private LocalDate fechaNacimiento;
    private int numSillas;

    /**Métodos*/
    public long calcularEdad(){
        LocalDate fechaActual = LocalDate.now();
        long edad = ChronoUnit.YEARS.between(fechaNacimiento, fechaActual);
        System.out.println("Su edad es " + edad);
        return edad;
    }

    /*Getters y setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getNumSillas() {
        return numSillas;
    }

    public void setNumSillas(int numSillas) {
        this.numSillas = numSillas;
    }
}
