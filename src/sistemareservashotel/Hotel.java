package sistemareservashotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel extends ValueObject {
    private String nombre;
    private List<Habitacion> habitaciones;

    public Hotel(int id, String nombre, int cantidadHabitaciones) {
        super(id);
        this.nombre = nombre;
        this.habitaciones = new ArrayList<>();
        for (int i = 1; i <= cantidadHabitaciones; i++) {
            habitaciones.add(new Habitacion(i, i));
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

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", habitaciones=" + habitaciones +
                '}';
    }
}
