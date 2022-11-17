/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author crist
 */
public class Alumno extends Usuario{
    private String Nombre;
    private String apPaterno;
    private String apMaterno;
    private int numCuenta;
    private int edad;
    private float promedio;
    private int escolaridad;
    private int velocidad;

    public Alumno() {
    }

    public Alumno(String Nombre, String apPaterno, String apMaterno, int numCuenta, int edad, float promedio, int escolaridad, int velocidad) {
        this.Nombre = Nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.numCuenta = numCuenta;
        this.edad = edad;
        this.promedio = promedio;
        this.escolaridad = escolaridad;
        this.velocidad = velocidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public int getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(int escolaridad) {
        this.escolaridad = escolaridad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }   
    public int obtenerNumInscripcion(){
        int numeroInscripcion;
        
        return numeroInscripcion;
    }
    
}
