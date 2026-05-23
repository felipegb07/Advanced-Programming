package InterfazConsola;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;

public class Aerolinea {
    private String nombre;
    private Set<Vuelo> vuelosAerolinea = new HashSet<>(); // Inicializado para evitar NullPointer

    public Aerolinea() {}
    public Aerolinea(String nombre, Set<Vuelo> vuelosAerolinea) {
        this.nombre = nombre;
        this.vuelosAerolinea = vuelosAerolinea;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Set<Vuelo> getVuelosAerolinea() { return vuelosAerolinea; }
    public void setVuelosAerolinea(Set<Vuelo> vuelosAerolinea) { this.vuelosAerolinea = vuelosAerolinea; }

    public int buscarVuelo(int nuevoVuelo) {
        for(Vuelo v : vuelosAerolinea) {
            if (v.getNumeroVuelo() == nuevoVuelo) {
                System.out.println("---Vuelo encontrado---");
                return nuevoVuelo;
            }
        }
        return -1;
    }

    public void agregarPasajero(int numeroVuelo, Pasajero pasajero) {
        for(Vuelo v : vuelosAerolinea) {
            if(v.getNumeroVuelo() == numeroVuelo) {
                v.getPasajeros().add(pasajero);
                System.out.println("Pasajero asignado exitosamente.");
                return;
            }
        }
        System.out.println("Vuelo no encontrado.");
    }

    public Set<String> vueloConRestriccion(String restriccion) {
        System.out.println("---Vuelos con restricciones---");
        Set<String> resultado = new HashSet<>();
        for (Vuelo v : vuelosAerolinea) {
            if (v instanceof Internacional) {
                Internacional inter = (Internacional) v;
                if (inter.getRequisitosVuelo() != null && inter.getRequisitosVuelo().getDescripcion().contains(restriccion)) {
                    resultado.add("Vuelo " + v.getNumeroVuelo() + " a " + v.getDestino());
                }
            }
        }
        return resultado;
    }

    public void generarReporte(String orden) {
        System.out.println("---Reporte general aerolinea---");
        System.out.println("Vuelos aerolinea");
        int i = 1;
        for(Vuelo v: vuelosAerolinea){
            System.out.println("\nVuelo " + i);
            System.out.println(v);
            i++;
        }
    }
}

