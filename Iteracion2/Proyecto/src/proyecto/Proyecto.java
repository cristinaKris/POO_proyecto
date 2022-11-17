/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;
import java.util.Scanner;
/**
 *
 * @author crist
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Eres Administrador o alumno?");
        String usuario= input.next().toLowerCase();
        switch (usuario) {
            case "alumno":
                System.out.println("Panel alumno");//Quitar
                System.out.println("Deseas consultar tu número de inscripción?");//Agregar código ascii
                String decision = input.next().toLowerCase();
                
                break;
            case "administrador":
                System.out.println("Panel Administrador");//Quitar
                break;                
            default:
                throw new AssertionError();
        }
    }
    
}
