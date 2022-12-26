
package proyectopoo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Login {
    Scanner input = new Scanner(System.in);
    
    public boolean login(HashMap <Integer,Alumno> alumnos, LinkedList<Administracion> administradores){    
        String tipoUsuario;
        boolean out=false;
        while(!out){
            System.out.println("Escribe Alumno o Administración según sea tu caso (sin acentos): \n");
            tipoUsuario=input.next().toUpperCase();
            switch (tipoUsuario) {
                case "ADMINISTRACION":
                    return loginAdministracion(administradores);
                case "ALUMNO":
                    return loginAlumno(alumnos);
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        
            System.out.println("Deseas regresar? ");
            System.out.println("escribe si o no: ");
            if ("SI".equals(input.next().toUpperCase())) {
                out=true;
            }
        }
        return false;
    }
    
    private boolean loginAlumno(HashMap <Integer,Alumno> alumnos){
        Integer IDE;
        Integer password;
        boolean login;
        System.out.println("Ingresa tu usuario: ");
        IDE = input.nextInt();
        System.out.println("Ingresa tu contraseña: "); 
        password = input.nextInt();
        if(alumnos.containsKey(IDE) && alumnos.get(IDE).password==password){
            System.out.println("Alumno verificado");
            return true;
        }else {
            System.out.println("Lo sentimos tu usuario y/o contraseña son incorrectos");
            return false;
        }
    }
    
    private boolean loginAdministracion(LinkedList<Administracion> administradores){
        Administracion adminsitrador = new Administracion();
        Integer IDE;
        Integer password;
        System.out.println("Ingresa tu usuario: ");
        adminsitrador.setIDE(input.nextInt());
        System.out.println("Ingresa tu contraseña: "); 
        adminsitrador.setPassword(input.nextInt()); 
        if(administradores.contains(adminsitrador)){
            System.out.println("Alumno verificado");
            return true;
        }else {
            System.out.println("Lo sentimos tu usuario y/o contraseña son incorrectos");
            return false;
        }
    }
}
