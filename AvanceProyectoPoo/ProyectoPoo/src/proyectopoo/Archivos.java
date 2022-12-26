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
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crist
 */
public class Archivos {
    public void crearArchivo(){
        File archivo =new File("archivo.txt");
        System.out.println(archivo.exists());
        boolean seCreo;
        try{
            seCreo=archivo.createNewFile();
            System.out.println(seCreo);
            System.out.println(archivo.exists());
        } catch (IOException ex){
            Logger LOG = Logger.getLogger(Archivos.class.getName());
        }
    }
    
    public void writeAlumno(Alumno alumno){
        try {
            FileWriter fw;
            fw = new FileWriter("listaAlumnos.csv");
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            salida.print(alumno.IDE+","+alumno.password+","+alumno.name+","+alumno.lastName+","+alumno.address+",");
            //Agregar escribir materias
            salida.print(alumno.semester+","+alumno.average+","+alumno.scholarship+","+alumno.numInscription);
            salida.print(" \n");
            salida.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
   
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
            //Agregar leer Materias
            alumno.setSemester(Integer.parseInt(tokenizador1.nextToken()));
            alumno.setAverage(Float.parseFloat(tokenizador1.nextToken()));
            alumno.setScholarship(Float.parseFloat(tokenizador1.nextToken()));
            alumno.setNumInscription(Long.parseLong(tokenizador1.nextToken()));
            
            System.out.println(alumno);
            
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public String readName(String nameFile) throws IOException{
        String linea = null;
        try {
            FileReader fr;
            fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            linea =br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linea;
    }
    
    public String readLastName(String nameFile) throws IOException{
        String linea = null;
        try {
            FileReader fr;
            fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            linea =br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linea;
    }
    
    public String readAddress(String nameFile) throws IOException{
        String linea = null;
        try {
            FileReader fr;
            fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            linea =br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Archivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linea;
    }
}