package registroalumnos;

import java.util.ArrayList;
import java.util.List;

public class SistemaAlumnos {

    private List<Alumno> alumnos;

    public SistemaAlumnos() {
        this.alumnos = new ArrayList<>();
    }

    public Alumno crearAlumno(String nombre, int edad) {
        Alumno alumno = new Alumno(nombre, edad, new ArrayList<>());
        alumnos.add(alumno);
        return alumno;
    }

    public void asignarCalificacion(double calificacion, Alumno alumno) {
        ArrayList<Double> calificaciones = alumno.getCalificaciones();
        calificaciones.add(calificacion);
    }

    public void calcularPromedio(Alumno alumno) {
        double promedio = alumno.getCalificaciones().stream().mapToDouble(calificacion -> calificacion).sum();
        promedio = promedio / alumno.getCalificaciones().size();
        alumno.setPromedio(promedio);
    }

    public void mostarAlumnos() {
        alumnos.forEach(alumno -> {
            System.out.println(alumno);
            System.out.printf("El promedio de  %s es: %.1f%n", alumno.getNombre(), alumno.getPromedio());
        });
    }
}
