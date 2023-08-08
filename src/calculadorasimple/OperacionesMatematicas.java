package calculadorasimple;

import java.util.HashMap;
import java.util.Map;

public class OperacionesMatematicas {
    private int numero1;
    private int numero2;
    private String tipoOperacion;

    public OperacionesMatematicas(int numero1, int numero2, String tipoOperacion) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.tipoOperacion = tipoOperacion;
    }

    public Object operacion() {
        Map<String, Object> operaciones = new HashMap<>();
        operaciones.put("sumar", sumar(numero1, numero2));
        operaciones.put("restar", restar(numero1, numero2));
        operaciones.put("multiplicar", multiplicar(numero1, numero2));
        operaciones.put("dividir", dividir(numero1, numero2));
        Object respuesta = operaciones.get(tipoOperacion);
        if (respuesta != null) {
            return respuesta;
        }
        return "No se encuentra la operacion";
    }

    private Double sumar(int num1, int num2) {
        return (double) (num1 + num2);
    }

    private Double restar(int num1, int num2) {
        return (double) num1 - num2;
    }

    private Double multiplicar(int num1, int num2) {
        return (double) num1 * num2;
    }

    private Object dividir(int num1, int num2) {
        if (num2 != 0) {
            return (double) num1 / num2;
        }
        return "No se puede dividir por cero";
    }

    public int getNumero1() {
        return numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }
}
