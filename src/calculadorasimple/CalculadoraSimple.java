package calculadorasimple;

public class CalculadoraSimple {

    public static void calculadoraSimple(){
        OperacionesMatematicas operacionesMatematicas = new OperacionesMatematicas(5, 3, "dividir");
        Object resultado = operacionesMatematicas.operacion();
        System.out.printf("El resultado de la operacion %s es: %s", operacionesMatematicas.getTipoOperacion(), resultado);
    }
}
