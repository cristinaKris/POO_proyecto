/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoo;

import java.util.logging.Logger;

/**
 * Clase que representará a un usuario en general (pudiendo ser alumno o admin.), por ello tiene los dos atributos que 
 * ocuparían ambos, y además es la superclase hacia las otras dos
 * @author Equipo J 
 */
public class Usuario {
    int IDE;
    int password;

    /**
     * Constructor vacío que inicializa los atributos de cada objeto Usuario en NULL
     */
    public Usuario() {
    }

    /**
     * Constructor que recibe como parámetros la información de los dos atributos y los asigna a cada uno
     * @param IDE es el numero de cuenta 
     * @param password es la contraseña
     */
    public Usuario(int IDE, int password) {
        this.IDE = IDE;
        this.password = password;
    }
    
    /**
     * Método set que asigna el número que recibe, al atributo correspondiente IDE
     * @param IDE corresponde al numero de cuenta/IDE que se va a asignar
     */
    public void setIDE(int IDE) {
        this.IDE = IDE;
    }

    /**
     * Método set que asigna el número que recibe como el atributo correspondiente a password
     * @param password corresponde a la contraseña que se va a asignar
     */
    public void setPassword(int password) {
        this.password = password;
    }
    
    
}
