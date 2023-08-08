package conversormonedas;

public class ConversorMoneda {
    public static void conversorMoneda(){
        OperacionMoneda operacionMoneda = new OperacionMoneda("dolar", "euro", 100);
        Double total = operacionMoneda.convertir();
        System.out.println("Cantidad ingresada: " + operacionMoneda.getCantidadMoneda());
        System.out.println("Tipo de moneda ingresada: " + operacionMoneda.getTipoMonedaIngreso());
        System.out.println("Tipo de moneda a convertir: " + operacionMoneda.getTipoMonedaSalida());
        System.out.printf("Valor total: %.2f%n", total);
    }
}
