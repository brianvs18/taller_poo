package sistemareservashotel;

public class Cliente extends ValueObject {
    private String nombre;
    private String documento;
    private String empresa;

    public Cliente(int id, String nombre, String documento, String empresa) {
        super(id);
        this.nombre = nombre;
        this.documento = documento;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
