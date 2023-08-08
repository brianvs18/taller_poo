package registroalumnos;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private int edad;
    private ArrayList<Double> calificaciones;
    private double promedio;

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public Alumno(String nombre, int edad, ArrayList<Double> calificaciones) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public String toString() {
        return "Alumno {" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", calificacion=" + calificaciones +
                '}';
    }
}
