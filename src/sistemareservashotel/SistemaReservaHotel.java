package sistemareservashotel;

import java.util.ArrayList;
import java.util.List;

public class SistemaReservaHotel {
    private static List<Hotel> hoteles = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();

    public static void sistemaReservaHotel() {

        hoteles.add(new Hotel(1, "Gran hotel", 2));
        hoteles.add(new Hotel(2, "Luxury hotel", 3));
        clientes.add(new Cliente(1, "Juan Perez", "2334455", "Softlond"));
        clientes.add(new Cliente(2, "Maria Juana", "2334455", "Softlond"));

        datosReserva(1, 2, 2);
        datosReserva(1, 1, 1);
        System.out.println(reservas);
        System.out.println(hoteles);
    }

    private static void datosReserva(int hotelId, int clienteId, int numeroHabitacion) {
        hoteles.stream()
                .filter(hotel -> hotel.id == hotelId)
                .forEach(hotel -> clientes.stream()
                        .filter(cliente -> cliente.id == clienteId)
                        .forEach(cliente -> realizarReserva(hotel, cliente, numeroHabitacion)));
    }

    private static void realizarReserva(Hotel hotel, Cliente cliente, int numeroHabitacion) {
        hotel.getHabitacionesDisponibles().stream()
                .filter(habitacion -> habitacion.getNumero() == numeroHabitacion && habitacion.isDisponible())
                .forEach(habitacion -> {
                    habitacion.reservarHabitacion();
                    Reserva reserva = new Reserva(1, cliente, hotel, habitacion);
                    reserva.realizarReserva();
                    reservas.add(reserva);
                });
    }

    private static void cancelarReserva(int reservaId){
        reservas.stream()
                .filter(reserva -> reserva.id == reservaId)
                .forEach(Reserva::cancelarReserva);
    }
}
