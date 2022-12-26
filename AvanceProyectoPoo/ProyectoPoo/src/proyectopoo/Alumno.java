/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 *
 * @author crist
 */
public class Alumno extends Usuario {
    String name;
    String lastName;
    String address;
    HashMap<String, Float> subjects= new HashMap<>();
    float semester;
    float average;
    float scholarship;
    long numInscription;

    public Alumno() {
    }
    
    public Alumno(int IDE, int password) {
        super(IDE, password);
    }

    public Alumno(String name, String lastName, String address, float semester, float average, float scholarship, long numInscription, int IDE, int password) {
        super(IDE, password);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.semester = semester;
        this.average = average;
        this.scholarship = scholarship;
        this.numInscription = numInscription;
    }
    
    public HashMap<String, Float> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSemester() {
        return semester;
    }

    public void setSemester(float semester) {
        this.semester = semester;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public float getScholarship() {
        return scholarship;
    }

    public void setScholarship(float scholarship) {
        this.scholarship = scholarship;
    }

    public long getNumInscription() {
        return numInscription;
    }

    public void setNumInscription(long numInscription) {
        this.numInscription = numInscription;
    }

    public int getIDE() {
        return IDE;
    }

    public void setIDE(int IDE) {
        this.IDE = IDE;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
    
    
    
    @Override
    public String toString() {
        return "Alumno{" + "name=" + name + ", lastName=" + lastName + ", address=" + address + ", subjects=" + subjects + ", semester=" + semester + ", average=" + average + ", scholarship=" + scholarship + ", numInscription=" + numInscription + '}';
    }

 
    
    
}  