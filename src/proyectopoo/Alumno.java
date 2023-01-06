/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoo;

import static java.lang.System.in;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Clase que va a conformar al objeto alumno con todos sus atributos y métodos, y que además
 * extiende de la superclase Usuario
 * @author Equipo J 
 */
public class Alumno extends Usuario {
    String name;
    String lastName;
    String address;
    int [] subjects;
    int semester;
    int age;
    float average; //promedio
    float scholarship; 
    float velocidad;
    long numInscription;

    /**
     * Constructor vacío que inicializa los atributos de un alumno (al crearlo) en NULL 
     */
    public Alumno() {
    }

    /**
     * Constructor que recibe los dos atributos de la superclase Usuario y los asigna para un alumno
     * @param IDE corresponde a su numero de cuenta
     * @param password corresponde a su contraseña (que es su mismo numero de cuenta)
     */
    public Alumno(int IDE, int password) {
        super(IDE, password);
    }

    /**
     * Constructor que recibe todos los atributos de un objeto alumno al crearse y los asigna donde corresponden (inicializandolos)
     * @param name corresponde al nombre del alumno
     * @param lastName corresponde al apellido del alumno
     * @param address corresponde a la dirección del alumno
     * @param subjects corresponde al arreglo con las calificaciones en 5 asignaturas del alumno
     * @param semester corresponde al semestre del alumno
     * @param age corresponde a la edad del alumno
     * @param average corresponde al promedio del alumno
     * @param scholarship corresponde a la escolaridad del alumno
     * @param velocidad corresponde a la velocidad del alumno
     * @param numInscription corresponde al numero de inscripcion del alumno
     * @param IDE corresponde al numero de cuenta del alumno (atributo de la superclase)
     * @param password corresponde a la contraseña del alumno (atributo de la superclase)
     */
    public Alumno(String name, String lastName, String address, int[] subjects, int semester, int age, float average, float scholarship, float velocidad, long numInscription, int IDE, int password) {
        super(IDE, password);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.subjects = subjects;
        this.semester = semester;
        this.age = age;
        this.average = average;
        this.scholarship = scholarship;
        this.velocidad = velocidad;
        this.numInscription = numInscription;
    }
    
    /**
     * Método que se va a encargar de calcular el promedio de cierto alumno, segun las calificaciones que tenga en su arreglo de asignaturas,
     * sumandolas todas y dividiendolas después entre 5 (porque cada uno tiene 5 materias)
     * @return sum que representa al promedio calculado
     */
    public float calcularPromedio(){
        float sum=0;
        for (int i = 0; i < subjects.length; i++) {
            sum+=subjects[i];
        }
        sum/=5;
        return sum;
    }
    
    /**
     * Método que se va a encargar de calcular la escolaridad de cierto alumno, segun sus materias aprovadas (mayor a 5)
     * @return aprovada que representa su numero obtenido en escolaridad (como entero)
     */
    public float calcularScholarship(){
        float aprovada=0;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i]>5) aprovada++;
        }
        aprovada= aprovada /5;
        aprovada*=100;
        return aprovada;
    }
     
    /**
     * Método que se va a encargar de calcular la velocidad de cierto alumno, segun las materias aprovadas y el semestre en el que va
     * @return aprovada que es la variable en donde estará el valor correspondiente a la velocidad
     */
    public float calcularVelocidad(){
        float aprovada=0;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i]>5) aprovada++;
        }
        
        aprovada += (5*(semester-1));
        aprovada /=(5*semester);
        aprovada*=100;
        return aprovada;
    }
    
    /**
     * Método que se va a encargar de calcular el número de inscripción único para cada alumno, siguiendo el método de la facultad,
     * tomando en cuenta la velocidad, promedio y escolaridad
     * @return numInscripcion que corresponde a dicho número calculado
     */
    public long calcularNumInscripcion(){
        long numInscripcion=1;
        numInscripcion = (long)(velocidad*average*scholarship);
        return numInscripcion;
    }

    /**
     * Método get para obtener el nombre de un alumno
     * @return name, correspondiente a este atributo
     */
    public String getName() {
        return name;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo nombre de un alumno
     * @param name, correspondiente al nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método get para obtener el apellido de un alumno
     * @return lastName, correspondiente a dicho atributo
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo apellido de un alumno
     * @param lastName, correspondiente al apellido
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Método get para obtener la dirección de un alumno
     * @return adress, correspondiente a dicho atributo
     */
    public String getAddress() {
        return address;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo dirección de un alumno
     * @param address, correspondiente a la dirección
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Método get para obtener el arreglo de calificaciones de un alumno
     * @return subjects, que es su atributo correspondiente de tipo arreglo
     */
    public int[] getSubjects() {
        return subjects;
    }
    
    /**
     * Método creado para mostrar en pantalla las calificaciones de las 5 materias de un alumno, ya que, al tratarse de un 
     * arreglo, no es directa su impresión, por lo que nos apoyamos de un ciclo for
     */
    public void showsubjects(){
        int cont=1;
        for (int i : subjects){
            System.out.println("calificacion de materia "+cont+" = "+i);
            cont++;
        }
    }

    /**
     * Método set que asigna el parámetro recibido al atributo asignaturas de un alumno
     * @param subjects es el arreglo que contiene las calificaciones a asignar
     */
    public void setSubjects(int[] subjects) {
        this.subjects = subjects;
    }

    /**
     * Método get para obtener el semestre de un alumno
     * @return semestre, correspondiente a dicho atributo
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo semestre de un alumno
     * @param semester, correspondiente al semestre
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Método get para obtener la edad de un alumno
     * @return age, atributo que guarda dicha información
     */
    public int getAge() {
        return age;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo edad de un alumno
     * @param age, correspondiente a la edad
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Método get para obtener el promedio de un alumno
     * @return average, atributo que guarda dicha información
     */
    public float getAverage() {
        return average;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo promedio de un alumno
     * @param average que se recibe, correspondiente al promedio
     */
    public void setAverage(float average) {
        this.average = average;
    }

    /**
     * Método get para obtener la escolaridad de un alumno
     * @return scholarship, atributo que guarda dicha información
     */
    public float getScholarship() {
        return scholarship;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo escolaridad de un alumno
     * @param scholarship que se recibe, correspondiente a la escolaridad
     */
    public void setScholarship(float scholarship) {
        this.scholarship = scholarship;
    }

    /**
     * Método get para obtener la velocidad de un alumno
     * @return velocidad, atributo que guarda dicha información
     */
    public float getVelocidad() {
        return velocidad;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo velocidad de un alumno
     * @param velocidad que se recibe, correspondiente a la velocidad
     */
    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Método get para obtener el número de inscripción de un alumno específico
     * @return numInscription, atributo que guarda dicha información
     */
    public long getNumInscription() {
        return numInscription;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo número de inscripción de un alumno
     * @param numInscription que se recibe, correspondiente al número de inscripción
     */
    public void setNumInscription(long numInscription) {
        this.numInscription = numInscription;
    }

    /**
     * Método get para obtener el numero de cuenta de un alumno
     * @return IDE, atributo de la superclase que guarda dicha información
     */
    public int getIDE() {
        return IDE;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo IDE (de la superclase) de un alumno
     * @param IDE que se recibe, correspondiente a la IDE
     */
    public void setIDE(int IDE) {
        this.IDE = IDE;
    }

    /**
     * Método get para obtener la contraseña de un alumno
     * @return password, atributo que guarda dicha información
     */
    public int getPassword() {
        return password;
    }

    /**
     * Método set que asigna el parámetro recibido al atributo contraseña de un alumno
     * @param password que se recibe, correspondiente a la contraseña
     */
    public void setPassword(int password) {
        this.password = password;
    }
    
    /**
     * Método funcional para mostrar a un alumno, con sus atributos correspondientes y ordenados
     */
    public void mostraralumno(){
        System.out.println("Nombre: "+name+" "+lastName);
        System.out.println("Direccion: "+address);
        System.out.println("Edad: "+age);
        System.out.println("Semestre "+semester);        
        System.out.println("Promedio: "+average);                
        System.out.println("Velocidad: "+velocidad);                
        System.out.println("Escolaridad: "+scholarship);
        int cont=1;
        for (int i : subjects){
            System.out.println("calificacion de materia "+cont+" = "+i);
            cont++;
        }
        System.out.println("Numero de inscripcion: "+numInscription);
    }

    /**
     * Método toString que es el que se encarga de mostrar un objeto alumno completo, con todos sus atributos, y los retorna
     * @return al alumno completo
     */
    @Override
    public String toString() {
        return "Alumno{" + "name=" + name + ", lastName=" + lastName + ", address=" + address + ", subjects=" + subjects + ", semester=" + semester + ", age=" + age + ", average=" + average + ", scholarship=" + scholarship + ", velocidad=" + velocidad + ", numInscription=" + numInscription + '}';
    }
    
}   