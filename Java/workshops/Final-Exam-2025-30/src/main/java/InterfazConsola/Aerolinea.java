package InterfazConsola;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Aerolinea {
    /*Atributos*/
    private String nombre;
    private HashSet<Vuelo> vuelosAerolinea;

    /*Métodos*/
    public Aerolinea() {}
    public Aerolinea(String nombre, HashSet<Vuelo> vuelosAerolinea) {
        this.nombre = nombre;
        this.vuelosAerolinea = vuelosAerolinea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Vuelo> getVuelosAerolinea() {
        return vuelosAerolinea;
    }

    public void setVuelosAerolinea(HashSet<Vuelo> vuelosAerolinea) {
        this.vuelosAerolinea = vuelosAerolinea;
    }

    /*Buscar vuelo*/
    public int buscarVuelo(int nuevoVuelo) {
        System.out.println("Ingrese el numero de vuelo");
        for(Vuelo v : vuelosAerolinea) {
            if (v.getNumeroVuelo() == nuevoVuelo) {
                System.out.println("---Vuelo encontrado---");
                return nuevoVuelo;
            }
        }
        return -1;
    }

    /*Agragar pasajero*/
    public void agregarPasajero(int numeroVuelo, String nombre, int id, LocalDate frechaNacimiento, int numeroSilla) {
        if(buscarVuelo(numeroVuelo) != -1){
            System.out.println("Asignando pasajero a " + vuelosAerolinea.toString());
        }
    }

    /*Vuelos con restricciones*/
    public ArrayList<String> vueloConRestriccion(String restriccion) {
        System.out.println("---Vuelos con restricciones---");

    }

    public void generarReporte(String orden) {

    }

}
