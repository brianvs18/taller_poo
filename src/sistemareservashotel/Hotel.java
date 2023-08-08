package sistemareservashotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String nombre;
    private List<Habitacion> habitaciones;

    public Hotel(String nombre, int cantidadHabitaciones) {
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        for (int i = 1; i <= cantidadHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Habitacion> getHabitacionesDisponibles() {
        return habitaciones.stream()
                .filter(Habitacion::isDisponible)
                .collect(Collectors.toList());
    }
}
