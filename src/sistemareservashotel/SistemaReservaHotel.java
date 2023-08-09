package sistemareservashotel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SistemaReservaHotel {
    private static List<Hotel> hoteles = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static AtomicInteger cont = new AtomicInteger(1);

    public static void sistemaReservaHotel() {

        hoteles.add(new Hotel(1, "Gran hotel", 2));
        hoteles.add(new Hotel(2, "Luxury hotel", 3));
        clientes.add(new Cliente(1, "Juan Perez", "1234567", "Softlond"));
        clientes.add(new Cliente(2, "Maria Agudelo", "2334455", "Amazon"));

        datosReserva(1, 2, 2);
        datosReserva(1, 1, 1);
        // El estado de la reserva es Reservado
        mostrarReservas();
        // Muestra error al intentar reservar una habitacion que no existe o se encuentra ocupada
        datosReserva(1, 2, 5);
        // Se imprime los hoteles para mostrar que las habitaciones estan en disponible = false
        System.out.println(hoteles);
        System.out.println("########################################################");
        cancelarReserva(1);
        // El estado de la reserva pasa a ser Cancelado
        mostrarReservas();
        // Al cancelar la reserva, la habitacion de la reserva con el id enviado se mostrara en disponible = true
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

        boolean existe = hotel.getHabitacionesDisponibles().stream()
                .anyMatch(habitacion -> habitacion.getNumero() == numeroHabitacion && habitacion.isDisponible());

        if (existe) {
            hotel.getHabitacionesDisponibles().stream()
                    .filter(habitacion -> habitacion.getNumero() == numeroHabitacion)
                    .forEach(habitacion -> {
                        habitacion.reservarHabitacion();
                        Reserva reserva = new Reserva(cont.get(), cliente, hotel, habitacion);
                        reserva.realizarReserva();
                        reservas.add(reserva);
                        cont.getAndIncrement();
                    });
        } else System.out.println("La habitacion no existe o no está disponible para reservar");
    }

    private static void cancelarReserva(int reservaId) {
        reservas.stream()
                .filter(reserva -> reserva.id == reservaId)
                .forEach(reserva -> hoteles.forEach(hotel -> hotel.getHabitacionesReservadas().stream()
                        .filter(habitacion -> habitacion.getNumero() == reserva.getHabitacion().getNumero())
                        .forEach(habitacion -> reserva.cancelarReserva())));
    }

    private static void mostrarReservas() {
        System.out.println("*** INFO RESERVAS ***");
        reservas.forEach(reserva -> {
            System.out.println("************************");
            System.out.println("Reserva id: " + reserva.id + "\nHotel: " + reserva.getHotel().getNombre() + "\nCliente: " + reserva.getCliente().getNombre()
                    + "\nDocumento: " + reserva.getCliente().getDocumento() + "\nEmpresa: " + reserva.getCliente().getEmpresa()
                    + "\nHabitacion: " + reserva.getHabitacion().getNumero() + "\nEstado reserva: " + reserva.getEstado());
        });
    }
}
