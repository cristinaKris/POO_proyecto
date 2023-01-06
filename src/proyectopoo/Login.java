
package proyectopoo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Clase creada para el inicio de sesión, representando objetos de tipo Login que nos van a permitir el "acceso" al programa
 * según el usuario del que se trate, para identificarlos tenemos 2 atributos correspondientes a la IDE y contraseña
 * @author Equipo J 
 */
public class Login {
    String usuario;
    Scanner input = new Scanner(System.in);
    
    /**
     * Método de inicio de sesión que va a recibir la hastable de los alumnos y la lista de administradores para poder verificar que
     * existan en el registro
     * @param alumnos es la tabla hash que se recibe, con la información de los alumnos
     * @param administradores es la lista ligada, con los administradores registrados
     * @return usuario, que es una cadena indicando si se trata de un alumno o administrador
     */
    public String login(HashMap <Integer,Alumno> alumnos, LinkedList<Administracion> administradores){    
        String tipoUsuario;
        boolean out=false;
        while(!out){
            System.out.println("Escribe Alumno o AdministraciÃ³n segÃºn sea tu caso (sin acentos): \n");
            tipoUsuario=input.next().toUpperCase();
            switch (tipoUsuario) {
                case "ADMINISTRACION":
                    return loginAdministracion(administradores);
                case "ALUMNO":
                    return loginAlumno(alumnos);
                default:
                    System.out.println("OpciÃ³n invalida");
                    break;
            }
        
            System.out.println("Deseas regresar? ");
            System.out.println("escribe si o no: ");
            if ("SI".equals(input.next().toUpperCase())) {
                out=true;
            }
        }
        return usuario;
    }
    
    /**
     * Método privado que se llama al tratarse de un alumno, para ingresar IDE y contraseña y verificar que existe
     * @param alumnos recibe la tabla hash con los alumnos
     * @return la cadena "alumno" si existe, o "none" si no existe
     */
    private String loginAlumno(HashMap <Integer,Alumno> alumnos){
        Integer IDE;
        Integer password;
        boolean login;
        System.out.println("Ingresa tu usuario: ");
        IDE = input.nextInt();
        System.out.println("Ingresa tu contraseÃ±a: "); 
        password = input.nextInt();
        if(alumnos.containsKey(IDE) && alumnos.get(IDE).password==password){
            System.out.println("Alumno verificado");
            usuario="alumno";
            return usuario;
        }else {
            System.out.println("Lo sentimos tu usuario y/o contraseÃ±a son incorrectos");
            usuario="none";
            return usuario;
        }
    }
    
    /**
     * Método privado que se llama al tratarse de un administrador, para ingresar IDE y constraseña y verificar que existe
     * @param administradores recibe la lista ligada con los administradores guardados
     * @return la cadena "admi" si existe, o "none" si no existe
     */
    private String loginAdministracion(LinkedList<Administracion> administradores){
        Administracion administrador = new Administracion();
        Integer IDE;
        Integer password;
        System.out.println("Ingresa tu usuario: ");
        administrador.setIDE(input.nextInt());
        System.out.println("Ingresa tu contraseÃ±a: "); 
        administrador.setPassword(input.nextInt()); 
        usuario="none";
        administradores.forEach(new Consumer<Administracion>() {
            @Override
            public void accept(Administracion a) {
                if(a.IDE==administrador.IDE && a.password==administrador.password){
                    System.out.println("Administrador verificado");
                    usuario="admi";
                }   
            }
        });
        if(usuario=="none"){
            System.out.println("Lo sentimos tu usuario y/o contraseÃ±a son incorrectos");
        }
        return usuario;
    }
}
  

