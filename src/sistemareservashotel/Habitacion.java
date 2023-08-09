package sistemareservashotel;

public class Habitacion extends ValueObject {
    private int numero;
    private boolean disponible;

    public Habitacion(int id, int numero) {
        super(id);
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

    public void cancelarHabitacion() {
        disponible = true;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", numero=" + numero +
                ", disponible=" + disponible +
                '}';
    }
}
