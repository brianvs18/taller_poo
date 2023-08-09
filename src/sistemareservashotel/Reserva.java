package sistemareservashotel;

public class Reserva extends ValueObject {
    private Cliente cliente;
    private Hotel hotel;
    private Habitacion habitacion;
    private String estado;

    public Reserva(int id, Cliente cliente, Hotel hotel, Habitacion habitacion) {
        super(id);
        this.cliente = cliente;
        this.hotel = hotel;
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void realizarReserva() {
        habitacion.reservarHabitacion();
        estado = "Reservada";
    }

    public void cancelarReserva() {
        habitacion.cancelarHabitacion();
        estado = "Cancelada";
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", hotel=" + hotel +
                ", habitacion=" + habitacion +
                '}';
    }
}
