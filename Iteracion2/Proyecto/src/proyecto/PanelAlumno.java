/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.util.Scanner;
/**
 *
 * @author crist
 */
public class PanelAlumno {
    Alumno alumno;
    public void panel (){
        Scanner input = new Scanner(System.in);
        boolean salir=false;
        while (salir!=false) {
            System.out.println("Menú");//Agregar código ASCII
            System.out.println("1) Ver Información\n 2)Consultar número de inscripción\n 3)Salir");
            System.out.println("Da el número de la opción a elegir: ");
            int opcion= input.nextInt();
            switch (opcion) {
                case 1:
                    MenuInformacion();
                    break;
                case 2:
                   
                   break;
                case 3:
                    salir=false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
    }

    private void MenuInformacion(){
        Scanner input = new Scanner(System.in);
        boolean salir=false;
        while (!salir) {
            System.out.println("Opciones de información a ver");
            System.out.println("1) nombre\n 2)Apellido Paterno\n 3)Apellido materno \n 4)Número de cuenta \n 5)Promedio\n 6) Escolaridad\n 7) Velocidad \n 8)Salir");
            System.out.println("Da el número del dato a ver");
            int opcion=input.nextInt();
            switch (opcion) {
                case 1:
                    alumno.getNombre();
                    break;
                case 2:
                    alumno.getApPaterno();
                    break;
                case 3:
                    alumno.getApMaterno();
                    break;
                case 4:
                    alumno.getNumCuenta();
                    break;
                case 5:
                    alumno.getPromedio();
                    break;
                case 6:
                    alumno.getEscolaridad();
                    break;
                case 7:
                    alumno.getVelocidad();
                    break;
                case 8:
                    salir=false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
    }
}
