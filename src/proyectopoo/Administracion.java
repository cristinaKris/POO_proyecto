/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectopoo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase creada para poder crear objetos de tipo Administracion, que justamente van a representar a los administradores
 * que son el otro tipo de usuario posible para el programa, teniendo entonces sus atriburos de la superclase Usuario
 * @author Equipo J 
 */
public class Administracion extends Usuario{

    /**
     * Constructor que recibe los dos atributos de la superclase Usuario y los asigna para un administrador
     * @param IDE corresponde a su numero de identificación
     * @param password corresponde a su contraseña de inicio de sesión
     */
    public Administracion(int IDE, int password) {
        super(IDE, password);
    }

    /**
     * Constructor vacío para inicializar un objeto de este tipo en NULL
     */
    Administracion() {
    }

    /**
     * Metodo diseñado para permitirle al usuario de tipo administrador AGREGAR los datos de un alumno, uno por uno (no aleatoreamente)
     * @param alumnos recibe a la hash table para poder agregarlo
     */
    public void agregarAlumno(HashMap <Integer,Alumno> alumnos){
        Scanner input = new Scanner(System.in);
        Archivos archivo = new Archivos();
        Alumno alumno = new Alumno();
        int [] calificaciones={0,0,0,0,0};
        System.out.println("Da el numero de cuenta del nuevo alumno: ");
        alumno.setIDE(input.nextInt());
        if (!alumnos.containsKey(alumno.IDE)) {
            System.out.println("Da el password del alumno(solo numeros enteros): ");
            alumno.setPassword(input.nextInt());
            input.nextLine();
            System.out.println("Da el nombre del alumno: ");
            alumno.setName(input.nextLine());
            System.out.println("Da los apellidos");
            alumno.setLastName(input.nextLine());
            System.out.println("Da la dirrección del alumno: ");
            alumno.setAddress(input.nextLine());
            System.out.println("Da el semestre: ");
            alumno.setSemester(input.nextInt());
            input.nextLine();
            System.out.println("Da la edad del alumno: ");
            alumno.setAge(input.nextInt());
            input.nextLine();
            for (int i = 0; i < 5; i++) {
                System.out.println("Da la calificacion "+i+": ");
                calificaciones[i]=input.nextInt();
                input.nextLine();
            }
            alumno.setSubjects(calificaciones);
            alumno.setScholarship(alumno.calcularScholarship());
            alumno.setAverage(alumno.calcularPromedio());
            alumno.setVelocidad(alumno.calcularVelocidad());
            alumno.setNumInscription(alumno.calcularNumInscripcion());            
            alumnos.put(alumno.IDE, alumno);
            numeroInscripcion.numeroInsc(alumnos);
            archivo.writeAlumno(alumno);
        }else System.out.println("Este alumno ya esta registrado");
    }
    
    /**
     * Método diseñado para permitirle a un usuario de tipo administrador ELIMINAR a cierto alumno, con todos su datos, tanto de la 
     * tabla hash como del archivo
     * @param alumnos recibe a dicha tabla hash para poder modificarla
     */
    public void eliminarAlumno(HashMap <Integer,Alumno> alumnos){
        Archivos archivo = new Archivos();
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el numero de cuenta del alumno a eliminar: ");
        alumnos.remove(input.nextInt());
        //Instrucciones para eliminar en el archivo
        numeroInscripcion.numeroInsc(alumnos);
        archivo.crearArchivo();
        archivo.writeTodosAlumnos(alumnos);
    }
    
    /**
     * Método diseñado para permitirle a un usuario de tipo administrador CONSULTAR unicamente los datos de un alumno, buscandolo
     * por su número de cuenta
     * @param alumnos recibe a la tabla hash que los contiene
     */
    public void consultarAlumno(HashMap <Integer,Alumno> alumnos){//se traba al ejecutar
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el numero de cuenta del alumno a consultar: ");
        int cuenta=input.nextInt();
        if(alumnos.containsKey(cuenta)){
            Alumno alumno = alumnos.get(cuenta);
            System.out.println("El alumno es: ");
            alumno.mostraralumno();
        }else
            System.out.println("El alumno que busca no esta registrado");
    }
    
    /**
     * Método diseñado para permitirle a un usuario de tipo administrador MODIFICAR cierto dato de un alumno, pudiendo
     * elegir entre sus diferentes atributos para actualizar únicamente ese, aunque en algunos casos van a actualizarse automáticamente
     * otros datos, dependientes entre si
     * @param alumnos recibe la tabla hash para poder modificar a un alumno
     */
    public void modificarAlumno(HashMap <Integer,Alumno> alumnos){//se traba y no continua
        Archivos archivo = new Archivos();
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el numero de cuenta del alumno a modificar: ");
        int alum=input.nextInt();
        if(alumnos.containsKey(alum)){
            Alumno alumno = alumnos.get(alum);
            System.out.println("Que dato desea modificar?\n   1)Nombre. 2)Apellido. 3)Direccion. 4)Asignaturas. 5)Semestre. 6)Edad 7)Numero de cuenta\n");
            int opc=input.nextInt();
            input.nextLine();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese el nombre actualizado del alumno:");
                    alumno.name=input.nextLine();
                    break;
                case 2:
                    System.out.println("Ingrese el apellido actualizado del alumno:");
                    alumno.lastName=input.nextLine();
                    break;
                case 3:
                    System.out.println("Ingrese la nueva direccion del alumno:");
                    alumno.address=input.nextLine();
                    break;
                case 4:                    
                    System.out.println("Las calificaciones actuales del alumno son:");
                    alumno.showsubjects();
                    System.out.println("Ingrese las calificaciones actualizadas del alumno:");
                    int [] calificaciones={0,0,0,0,0};
                    for (int i = 0; i < 5; i++) {
                        do{
                            System.out.println("calificacion "+(i+1)+":");
                            calificaciones[i]=input.nextInt();
                        }while(calificaciones[i]>10);
                    }
                    input.nextLine();
                    alumno.setSubjects(calificaciones);
                    alumno.average=alumno.calcularPromedio();
                    System.out.println("El promedio fue actualizado");
                    alumno.scholarship=alumno.calcularScholarship();
                    System.out.println("La escolaridad fue actualizada");          //porque al cambiar calificaciones todo esto tambien cambia
                    alumno.velocidad=alumno.calcularVelocidad();
                    System.out.println("La velocidad fue actualizada");
                    alumno.numInscription=alumno.calcularNumInscripcion();
                    numeroInscripcion.numeroInsc(alumnos);
                    System.out.println("El numero de inscripcion fue actualizado");
                    break;
                case 5:
                    do{
                        System.out.println("Ingrese el semestre actualizado del alumno:");
                        alumno.semester=input.nextInt();
                    }while(alumno.semester>10 || alumno.semester<1);
                    input.nextLine();
                    alumno.velocidad=alumno.calcularVelocidad();
                    numeroInscripcion.numeroInsc(alumnos);
                    break;
                case 6:
                    System.out.println("Ingrese la edad actualizada del alumno:");
                    alumno.age=input.nextInt();
                    input.nextLine();
                    break;
                case 7:
                    System.out.println("Ingrese el numero de cuenta actualizado del alumno:");
                    alumno.IDE=input.nextInt();
                    System.out.println("Desea que la contraseÃ±a sea la misma que el numero de cuenta o colocar una nueva?  1)La misma   2)Nueva");
                    int op2=input.nextInt();
                    input.nextLine();
                    if(op2==2){
                        System.out.println("Escriba la nueva contraseÃ±a");
                        alumno.password=input.nextInt();
                        input.nextLine();
                    }else{                      
                        alumno.password=alumno.IDE;
                    }
                    System.out.println("La contraseÃ±a tambien fue actualizada");
                    alumnos.remove(alum);
                    alumnos.put(alumno.IDE, alumno);
                    break;
                default:
                    System.out.println("Opcion no valida");;
            }
            System.out.println("El alumno actualizado es: ");
            alumno.mostraralumno();
            //Agregar instrucciones para reemplazar el archivo
            archivo.crearArchivo();
            archivo.writeTodosAlumnos(alumnos);
        }else
            System.out.println("El alumno que busca no esta registrado");
       
    }
    
    
}
