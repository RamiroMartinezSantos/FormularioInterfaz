import java.util.ArrayList;
public class IngresarAlumno {
    public ArrayList<Alumno> alumnos;
    public IngresarAlumno(){alumnos = new ArrayList<>();}
    public void ingresar(ArrayList<Alumno> alumnos,String nombre,String apellidos,String telefono,String ine,String estado){
        alumnos.add(new Alumno(nombre,apellidos,telefono,ine,estado));
    }
    public ArrayList<Alumno> getAlumnos() {return alumnos;}
}
