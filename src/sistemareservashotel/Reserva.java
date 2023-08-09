package sistemareservashotel;

public class Reserva extends ValueObject {
    private Cliente cliente;
    private Hotel hotel;
    private Habitacion habitacion;

    public Reserva(int id, Cliente cliente, Hotel hotel, Habitacion habitacion) {
        super(id);
        this.cliente = cliente;
        this.hotel = hotel;
        this.habitacion = habitacion;
    }

    public void realizarReserva() {
        habitacion.reservarHabitacion();
    }

    public void cancelarReserva() {
        habitacion.cancelarHabitacion();
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
