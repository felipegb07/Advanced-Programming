package InterfazConsola;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aerolinea {
    /**Atributos*/
    private String nombre;


    /**Métodos*/
    /*Constructor*/
    public Aerolinea(String nombre) {
        this.nombre = nombre;
    }

    /*Buscar vuelo*/
    public int buscarVuelo(int nuevoVuelo){

    }

    /*Agragar pasajero*/
    public void agregarPasajero(int numeroVuelo, String nombre, int id, LocalDate frechaNacimiento, int numero){

    }

    /*Vuelos con restricciones*/
    public ArrayList<String> vueloConRestriccion(String restriccion){

    }

    public void generarReporte(String orden){

    }

    /*Gettest y setters*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
