/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoo;

import java.util.logging.Logger;

/**
 *
 * @author crist
 */
public class Usuario {
    int IDE;
    int password;

    public Usuario() {
    }

    public Usuario(int IDE, int password) {
        this.IDE = IDE;
        this.password = password;
    }

    public void setIDE(int IDE) {
        this.IDE = IDE;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    
    
}
