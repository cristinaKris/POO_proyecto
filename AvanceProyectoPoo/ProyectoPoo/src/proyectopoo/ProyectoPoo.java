/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopoo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import proyectopoo.Login;

/**
 *
 * @author crist
 */
public class ProyectoPoo {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Bienvenidos a la Facultad de Ingenieria");
        HashMap <Integer,Alumno> alumnos = new HashMap();
        LinkedList<Administracion> administradores = new LinkedList();
        administradores.add(new Administracion(116001689, 030603));
        Login Login = new Login();
        alumnos.put(336001669, new Alumno());
        alumnos.put(116001689, new Alumno());
        alumnos.toString();
        if (Login.login(alumnos,administradores)) {
            
        }
        //DECIDIR SI ES USUARIO O ADMINISTRACION CAMBARILO DE LOGIN
        
        System.out.println(alumnos);
        
    }
    public static void menuAlumno(){
        int opc;
        boolean out=false;
        while (!out) {
            
        }
    }
    public static void menuAdministracion(){
        
    }
}
