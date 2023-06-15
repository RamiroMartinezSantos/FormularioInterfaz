public class Alumno {
    String nombre;
    String apellidos;
    String telefono;
    String ine;
    String estado;

    public Alumno(String nombre, String apellidos, String telefono,String ine,String estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.ine = ine;
        this.estado = estado;
    }


    @Override
    public String toString() {
        return nombre + "nomrbe" + apellidos + "apellidos" + telefono + "telefono" + ine + "ine" + estado + "estado" ;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIne() {
        return ine;
    }

    public String getEstado() {
        return estado;
    }

}


