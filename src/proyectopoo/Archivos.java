/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase implementada para la creación y manipulación de archivos, tanto para leer información de ellos como para 
 * poder crear uno nuevo que guarde y permita modificar la información de los alumnos creados automaticamente
 * @author Equipo J 
 */
public class Archivos {
    
    /**
     * Metodo que nos va a permitir crear un archivo
     */
    public void crearArchivo(){
        File archivo =new File("archivo.txt");
    }
    
    /**
     * Método que será invocado para la escritura de los 500 alumnos generados, en el archivo generador
     * @param alumnos recibe la hash table para poder obtener la información de cada alumno de ahí
     */
    public void writeTodosAlumnos(HashMap <Integer,Alumno> alumnos){
        try {
            File archivo =new File("listaAlumnos.csv");
            FileWriter fw;
            fw = new FileWriter("listaAlumnos.csv");
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.print("num cuenta,password,nombre,apellidos,direccion,");
            salida.print("semestre,promedio,escolaridad,num inscripcion,edad,velocidad,");
                for (int i = 1; i < 6; i++) {
                    salida.print("asignatura "+i+",");
                }
                salida.print(" \n");
            Iterator<Alumno> alumnoA = alumnos.values().iterator();
            Alumno alumno = new Alumno();
            while(alumnoA.hasNext()){
                alumno=alumnoA.next();
                salida.print(alumno.IDE+","+alumno.password+","+alumno.name+","+alumno.lastName+","+alumno.address+",");
                salida.print(alumno.semester+","+alumno.average+","+alumno.scholarship+","+alumno.numInscription+","+alumno.age+","+alumno.velocidad+",");
                for (int i = 0; i < alumno.subjects.length; i++) {
                    salida.print(alumno.subjects[i]+",");
                }
                salida.print(" \n");
            }
            salida.close();  
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    /**
     * Método que podrá ser utilizado cuando se quiera escribir solo un alumno nuevo en nuestro archivo de registros
     * @param alumno recibe al objeto alumno ya "lleno".
     */
    public void writeAlumno(Alumno alumno){
        try {
            FileWriter fw;
            fw = new FileWriter("listaAlumnos.csv",true);
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.print(alumno.IDE+","+alumno.password+","+alumno.name+","+alumno.lastName+","+alumno.address+",");
            salida.print(alumno.semester+","+alumno.average+","+alumno.scholarship+","+alumno.numInscription+","+alumno.age+","+alumno.velocidad+",");
            for (int i = 0; i < alumno.subjects.length; i++) {
                salida.print(alumno.subjects[i]+",");
            }
            salida.print(" \n");
            salida.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
   
    /**
     * Método que se podrá utilizar cuando se quiera obtener la información de un alumno, solo para mostrarse en pantalla
     * @param nameFile recibe el nombre del archivo del que se leerá
     * @param alumno recibe un objto de tipo alumno al que se le asignara la información para después mostrarla en pantalla
     * @throws IOException 
     */
    public void readAlumno(String nameFile, Alumno alumno) throws IOException{   
        try {
            FileReader fr;
            fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            String linea =br.readLine();
            StringTokenizer tokenizador1 = new StringTokenizer(linea, ",");
            alumno.setIDE(Integer.parseInt(tokenizador1.nextToken()));
            alumno.setPassword(Integer.parseInt(tokenizador1.nextToken()));
            alumno.setName(tokenizador1.nextToken());
            alumno.setLastName(tokenizador1.nextToken());
            alumno.setAddress(tokenizador1.nextToken());
            alumno.setSemester(Integer.parseInt(tokenizador1.nextToken()));
            alumno.setAverage(Float.parseFloat(tokenizador1.nextToken()));
            alumno.setScholarship(Integer.parseInt(tokenizador1.nextToken()));
            alumno.setNumInscription(Long.parseLong(tokenizador1.nextToken()));
            alumno.setAge(Integer.parseInt(tokenizador1.nextToken()));
            alumno.setVelocidad(Integer.parseInt(tokenizador1.nextToken()));
                    //Agregar leer Materias
            System.out.println(alumno);
            
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    /**
     * Método que se va a utilizar para poder obtener nombres aleatorios de nuestro archivo de nombres
     * @param nameFile recibe el nombre del archivo del que vamos a buscar
     * @return name que corresponde al arreglo con los nombres
     * @throws IOException 
     */
    public ArrayList<String> readName(String nameFile) throws IOException{
        String linea = null;
        ArrayList<String> name = new ArrayList<String>();
        FileReader fr;
        fr = new FileReader(nameFile);
        BufferedReader br = new BufferedReader(fr);
        do{
            try {  
                linea =br.readLine();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
             name.add(linea);
        }while (linea != null);
        fr.close();
        return name;
    }
    
    /**
     * Método que se va a utilizar para poder obtener apellidos aleatorios de nuestro archivo de apellidos
     * @param nameFile recibe el nombre del archivo del que vamos a extraer
     * @return lastName que corresponde al arreglo con los apellidos
     * @throws IOException 
     */
    public ArrayList<String> readLastName(String nameFile) throws IOException{
        String linea = null;
        ArrayList<String> lastName = new ArrayList<String>();
        FileReader fr;
        fr = new FileReader(nameFile);
        BufferedReader br = new BufferedReader(fr);
        do{
            try {
                linea =br.readLine();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
            lastName.add(linea);
        }while (linea != null);
        fr.close();
        return lastName;
    }
    
    /**
     * Método que se va a utilizar para poder obtener direcciones aleatorios de nuestro archivo con direcciones
     * @param nameFile recibe el nombre del archivo del que vamos a extraer
     * @return address que corresponde al arreglo con las direcciones
     * @throws IOException 
     */
    public ArrayList<String> readAddress(String nameFile) throws IOException{
        String linea = null;
        ArrayList<String> address = new ArrayList<String>();
        FileReader fr;
        fr = new FileReader(nameFile);
        BufferedReader br = new BufferedReader(fr);
        do{
            try {
                linea =br.readLine();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
            }
           address.add(linea);
        }while (linea != null);
        fr.close();
        return address;
    }
}