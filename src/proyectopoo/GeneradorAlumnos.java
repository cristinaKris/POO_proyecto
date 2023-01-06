/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Clase que se va a encargar de generar a los 500 alumnos, cada uno con sus respectivos datos aleatorio, para ello igualmente
 * se describen algunos métodos necesarios
 * @author Equipo J 
 */
public class GeneradorAlumnos {
   
    /**
     * Constructor vacío que va a inicializar un objeto GeneradorAlumnos en NULL
     */
    public GeneradorAlumnos() {

    }
    
    /**
     * Método que se va a invocar como unica instrucción para generar a cada alumno con sus datos aleatorios, guardandolos 
     * en la hash table y también en un archivo
     * @param alumnos recibe dicha hash table para agregarlos
     * @throws IOException 
     */
    public void generarAlumno(HashMap <Integer,Alumno> alumnos) throws IOException{
        
        Archivos archivo = new Archivos(); 
        archivo.crearArchivo();
        
        ArrayList <String> name = archivo.readName("Nombres_mas_populares_2017_2020.csv");
        ArrayList <String> lastName = archivo.readName("Apellidos_mas_comunes_2020.csv");///Sale un interrogación
        ArrayList <String> address = archivo.readName("Direcciones-Proy.csv");
        for (int i = 0; i < 500; i++) {
            int indexN = (int)((Math.random()*1002)+1);
            int indexL = (int)((Math.random()*1000)+1);
            int indexL2 = (int)((Math.random()*1000)+1);
            int indexA = (int)(Math.random()*50);
            Alumno alumno = new Alumno();
            alumno.setIDE(generacionclaves(alumnos)); //genera un numero de cuenta
            alumno.setPassword(alumno.getIDE());      //su contraseña es el mismo numero de cuenta
            alumno.setName(name.get(indexN));
            alumno.setLastName(lastName.get(indexL)+" "+lastName.get(indexL2));
            alumno.setAddress(address.get(indexA));
            
            alumno.setSemester((int)(Math.random()*10)+1);
            alumno.subjects = generadorCalificaciones();
            alumno.setAverage(alumno.calcularPromedio());
            alumno.setScholarship(alumno.calcularScholarship());
            alumno.setVelocidad(alumno.calcularVelocidad()); 
            alumno.setNumInscription(alumno.calcularNumInscripcion());
            
            edad(alumno);
            alumnos.put(alumno.IDE, alumno);
        }
        numeroInscripcion.numeroInsc(alumnos);
        archivo.writeTodosAlumnos(alumnos);
    }
    
    /**
     * Método que se va a encargar de generar los numeros de cuenta únicos y aleatorios para cada alumno
     * @param alumnos recibe la hash table para verificar que no este registrado el nuevo número
     * @return num que representa dicho numero de cuenta
     */
    public Integer generacionclaves(HashMap <Integer,Alumno> alumnos){
        Integer num;
        do{
            num = (int)((Math.random()*100000000)+99999999);
        }while(alumnos.containsKey(num));
        return num;
    }
    
    /**
     * Método que va a generar las 5 calificaciones de cada alumno aleatoriamente
     * @return calificaciones, que es un arreglo de enteros que ya contiene las calificaciones
     */
    private int []generadorCalificaciones(){
        int [] calificaciones = {0,0,0,0,0};
        for (int i = 0; i < 5; i++) {
            calificaciones[i]=(int)((Math.random()*5)+5);
        }
    return calificaciones;
    }
    
    /**
     * Método que se va a encargar de asgnarle una cierta edad a cada alumno dependiendo del semestre en el que vaya, debido a 
     * que debe haber edades mínimas, un alumno de sexto semestre no puede tener 18 años
     * @param alumno recibe al objeto alumno para poder obtener su semestre
     */
    private void edad (Alumno alumno){
        int min=22;
        int max = 30;
        Random random = new Random();
        if (alumno.getSemester() == 1){
                alumno.setAge(18);
            }else if(alumno.getSemester() == 2){
                alumno.setAge(18);
            }else if(alumno.getSemester() == 3){
                alumno.setAge(19);
            }else if(alumno.getSemester() == 4){
                alumno.setAge(19);
            }else if(alumno.getSemester() == 5){
                alumno.setAge(20);
            }else if(alumno.getSemester() == 6){
                alumno.setAge(20);
            }else if(alumno.getSemester() == 7){
                alumno.setAge(21);
            }else if(alumno.getSemester() == 8){
                alumno.setAge(21);
            }else if(alumno.getSemester() == 9){
                alumno.setAge(22);
            }else if(alumno.getSemester()>9){
                alumno.setAge(random.nextInt((max - min) + 1) + min);
            }
    }

}
