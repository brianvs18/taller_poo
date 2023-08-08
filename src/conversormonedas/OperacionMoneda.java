package conversormonedas;

import java.util.HashMap;
import java.util.Map;

public class OperacionMoneda {
    private String tipoMonedaIngreso;
    private String tipoMonedaSalida;
    private int cantidadMoneda;

    private static final double VALOR_DOLAR_PESO = 4035;
    private static final double VALOR_EURO_PESO = 4437;
    private static final double VALOR_EURO_DOLAR = 1.09;
    private static final String DOLAR = "dolar";
    private static final String EURO = "euro";
    private static final String PESO = "peso";

    public OperacionMoneda(String tipoMonedaIngreso, String tipoMonedaSalida, int cantidadMoneda) {
        this.tipoMonedaIngreso = tipoMonedaIngreso;
        this.tipoMonedaSalida = tipoMonedaSalida;
        this.cantidadMoneda = cantidadMoneda;
    }

    public Double convertir() {
        return monedaIngreso(tipoMonedaIngreso);
    }

    private Double monedaIngreso(String ingreso) {
        Map<String, Double> tipoMonedaIngresoMap = new HashMap<>();
        tipoMonedaIngresoMap.put(PESO, tipoConvertirPeso(tipoMonedaSalida));
        tipoMonedaIngresoMap.put(DOLAR, tipoConvertirDolar(tipoMonedaSalida));
        tipoMonedaIngresoMap.put(EURO, tipoConvertirEuro(tipoMonedaSalida));
        return tipoMonedaIngresoMap.get(ingreso);
    }

    private Double tipoConvertirPeso(String salida) {
        Map<String, Double> tipoMonedaSalidaMap = new HashMap<>();
        tipoMonedaSalidaMap.put(DOLAR, pesoADolar(cantidadMoneda));
        tipoMonedaSalidaMap.put(EURO, pesoAEuro(cantidadMoneda));
        return tipoMonedaSalidaMap.get(salida);
    }

    private Double tipoConvertirDolar(String salida) {
        Map<String, Double> tipoMonedaSalidaMap = new HashMap<>();
        tipoMonedaSalidaMap.put(PESO, dolarAPeso(cantidadMoneda));
        tipoMonedaSalidaMap.put(EURO, dolarAEuro(cantidadMoneda));
        return tipoMonedaSalidaMap.get(salida);
    }

    private Double tipoConvertirEuro(String salida) {
        Map<String, Double> tipoMonedaSalidaMap = new HashMap<>();
        tipoMonedaSalidaMap.put(PESO, euroAPeso(cantidadMoneda));
        tipoMonedaSalidaMap.put(DOLAR, euroADolar(cantidadMoneda));
        return tipoMonedaSalidaMap.get(salida);
    }

    private Double pesoADolar(int cantidad) {
        return cantidad / VALOR_DOLAR_PESO;
    }

    private Double pesoAEuro(int cantidad) {
        return cantidad / VALOR_EURO_PESO;
    }

    private Double dolarAPeso(int cantidad) {
        return VALOR_DOLAR_PESO * cantidad;
    }

    private Double dolarAEuro(int cantidad) {
        return cantidad / VALOR_EURO_DOLAR;
    }

    private Double euroADolar(int cantidad) {
        return VALOR_EURO_DOLAR * cantidad;
    }

    private Double euroAPeso(int cantidad) {
        return VALOR_EURO_PESO * cantidad;
    }

    public String getTipoMonedaIngreso() {
        return tipoMonedaIngreso;
    }

    public String getTipoMonedaSalida() {
        return tipoMonedaSalida;
    }

    public int getCantidadMoneda() {
        return cantidadMoneda;
    }
}
