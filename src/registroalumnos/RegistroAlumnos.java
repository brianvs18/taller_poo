package registroalumnos;

public class RegistroAlumnos {
    public static void registroAlumnos() {

        SistemaAlumnos sistemaAlumnos = new SistemaAlumnos();
        Alumno juan = sistemaAlumnos.crearAlumno("Juan", 20);
        sistemaAlumnos.asignarCalificacion(4.5, juan);
        sistemaAlumnos.asignarCalificacion(3.0, juan);
        sistemaAlumnos.asignarCalificacion(3.5, juan);
        sistemaAlumnos.calcularPromedio(juan);
        Alumno maria = sistemaAlumnos.crearAlumno("Maria", 24);
        sistemaAlumnos.asignarCalificacion(4.5, maria);
        sistemaAlumnos.asignarCalificacion(4.0, maria);
        sistemaAlumnos.asignarCalificacion(5.0, maria);
        sistemaAlumnos.calcularPromedio(maria);
        sistemaAlumnos.mostarAlumnos();
    }
}
