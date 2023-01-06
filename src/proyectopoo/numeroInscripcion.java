/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoo;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

/**
 * Clase creada para tener objetos tipo numeroInscripcion, y así poder crear cada uno de ellos para los alumnos, además de tenerlos organizados
 * @author Equipo J
 */
public class numeroInscripcion {
    
    /**
     * Método estático que se va a invocar para asignar su correspondiente número de inscripción único para cada alumno
     * @param alumnos recibe la hash table para poder manipular dicho atributo
     */
    public static void numeroInsc (HashMap <Integer,Alumno> alumnos){
        int[] numeroC= new int[alumnos.size()];
        int[] numeroI= new int[alumnos.size()];
        Set<Integer> llaves = alumnos.keySet();
        int i=0;
        for(Integer key: llaves){
            numeroC[i]=key;
            i++;
        }
        for(i=0;i<alumnos.size();i++){
            Alumno al= alumnos.get(numeroC[i]);
            al.setNumInscription(al.calcularNumInscripcion());
        }
        for(i=0;i<alumnos.size();i++){
            Alumno al= alumnos.get(numeroC[i]);
            numeroI[i]=(int)al.numInscription;
        }
        bubbleSort(numeroI,numeroC); 
        int cont=1;
        for(Integer key: numeroC){
            Alumno a=alumnos.get(key);
            a.setNumInscription(cont);
            cont++;
        }
    }
    
    /**
     * Método de ordenamiento de burbuja que nos va a servir para ordenar los números de inscripción como lo marca el algoritmo de la FI
     * @param alumnos recibe un arreglo de alumnos
     * @param numC y recibe un arreglo de los números de inscripción
     */
    private static void bubbleSort(int[] alumnos, int[] numC){
        int n = alumnos.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (alumnos[j] < alumnos[j + 1]) {
                    int temp = alumnos[j];
                    alumnos[j] = alumnos[j + 1];
                    alumnos[j + 1] = temp;
                    int temp2 = numC[j];
                    numC[j] = numC[j + 1];
                    numC[j + 1] = temp2;
                }
    }
}
