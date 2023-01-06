/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopoo;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal del proyecto donde estará el main y algunos métodos directos
 * @author Equipo J 
 */
public class ProyectoPoo {
    /**
     * Código main, en donde se encuentran las instrucciones que se van a ejecutar
     * @param args 
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GeneradorAlumnos genA= new GeneradorAlumnos();
        boolean out=false;
        System.out.println("Bienvenidos a la Facultad de Ingenieria");
        HashMap <Integer,Alumno> alumnos = new HashMap();
        LinkedList<Administracion> administradores = new LinkedList();
        administradores.add(new Administracion(116001689, 300603)); //Administradora Karen Cristina Isidro Castro
        administradores.add(new Administracion(319292709, 122015)); //Administradora Jacqueline Castillo Soto
        administradores.add(new Administracion(319312245, 170218)); //Administrador Cesar Enrique Hernandez Aguilar
        administradores.add(new Administracion(319240731, 260403)); //Administradora Carolina Figueros Ruiz
        administradores.add(new Administracion(319217449, 100303)); //Administradora Diana Nava Pineda
        try {
            genA.generarAlumno(alumnos);
        } catch (IOException ex) {
            Logger.getLogger(ProyectoPoo.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login Login = new Login();
        while(!out){
            System.out.println("Ingrese la opcion que desea:\n1)Iniciar sesion\n2)Salir\n");
            if(input.nextInt()==1){
                System.out.println("###INICIO DE SESION###");
                String usuario = Login.login(alumnos,administradores);
                if (usuario=="alumno")
                    menuAlumno(alumnos);
                else if (usuario=="admi")
                    menuAdministracion(alumnos);
            }
            else
                out=true;
        }        
        
    }
    /**
     * Método en donde se va a encontrar el menú para los usuarios de tipo alumno, permitiendoles ingresar a sus opciones correspondientes
     * @param alumnos recibe la tabla hash en donde vienen los alumnos organizados con toda su información, en donde las claves son los 
     * números de cuenta
     */
    public static void menuAlumno(HashMap <Integer,Alumno> alumnos ){
        Scanner input = new Scanner(System.in);
        Alumno alumno = new Alumno();
        int opc;
        boolean out=false;
        while (!out) {
            System.out.println("Que desea realizar?\n1)Consultar numero de inscripcion\n2)Cambiar contraseña\n3)Salir\n");
            int resp=input.nextInt();
            if(resp==1 || resp==2){                
            System.out.println("Por favor confirme su numero de cuenta:");
            alumno = alumnos.get(input.nextInt());
            }
            if(resp==1){                
                alumno.mostraralumno();
            }
            else if(resp==2){
                System.out.println("Escriba la nueva contraseÃ±a");
                alumno.password=input.nextInt();
                Archivos archivo = new Archivos();
                archivo.crearArchivo();
                archivo.writeTodosAlumnos(alumnos); 
            }
            else
                out=true;
        }
    }
    /**
     * Método en donde se va a encontrar el menú para los usuarios de tipo administradores, permitiendolesingresar a sus opciones correspndientes
     * @param alumnos recibe la tabla hash en donde se encuentran los alumnos organizados con toda su información y que se pueden localizar a partir
     * de su número de cuenta
     */
    public static void menuAdministracion(HashMap <Integer,Alumno> alumnos){
        Scanner input = new Scanner(System.in);
        Administracion admi = new Administracion();
        int opc;
        boolean out=false;
        while (!out) {
            System.out.println("Eliga la opciÃ³n que desea:\n1)Generar el archivo de registros\n2)Agregar alumno\n3)Eliminar alumno\n4)Consultar alumno\n5)Modificar dato de un alumno\n6)Salir\n");
            switch(input.nextInt()){
                case 1:
                    Archivos archivo = new Archivos();
                    archivo.crearArchivo();
                    archivo.writeTodosAlumnos(alumnos);                    
                    System.out.println("Se ha creado el archivo csv llamado listaAlumnos");
                    break;
                case 2:
                    admi.agregarAlumno(alumnos);
                    break;
                case 3:
                    admi.eliminarAlumno(alumnos);
                    break;
                case 4:
                    admi.consultarAlumno(alumnos);
                    break;
                case 5:
                    admi.modificarAlumno(alumnos);
                    break;
                case 6:
                    out=true;
            }
        }
    }
}
