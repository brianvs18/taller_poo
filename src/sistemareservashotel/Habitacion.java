package sistemareservashotel;

public class Habitacion {
    private int numero;
    private boolean disponible;

    public Habitacion(int numero) {
        this.numero = numero;
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void reservarHabitacion() {
        disponible = false;
    }

    public void cancelarReserva() {
        disponible = true;
    }
}
