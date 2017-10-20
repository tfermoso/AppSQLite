package DBHELPER;

/**
 * Created by Tomás on 20/10/2017.
 */

public class Usuario {
    private int idusuario, edad;
    private String nombre, apellidos;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Usuario(int idusuario, int edad, String nombre, String apellidos) {

        this.idusuario = idusuario;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
}
