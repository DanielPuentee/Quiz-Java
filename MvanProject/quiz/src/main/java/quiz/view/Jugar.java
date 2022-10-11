package quiz.view;

import java.util.ArrayList;
import java.util.Scanner;

import quiz.model.ModelPreguntasRespuesta;
import java.sql.*;

import quiz.controller.Preguntas;
import quiz.controller.CrearPreguntas;


public class Jugar extends ModelPreguntasRespuesta implements Preguntas{


    public static void main(String[] args) {
        Jugar play = new Jugar();
        play.run();        
    }

    public void run(){   
        String usuario = seleccion_usuario();
        if (usuario.equalsIgnoreCase("admin")) {
            creacion_preguntas();
            dinamica_juego(usuario);
        } else {dinamica_juego(usuario);}
    }
    //static
    public void dinamica_juego(String usuario){
        CrearPreguntas crearPreguntas = new CrearPreguntas();
        try {
            ResultSet result = crearPreguntas.getPreguntas();
            Integer aciertos = 0;
            Integer fallos = 0;

            while (result.next()) {
                System.out.println("\n" + result.getString("pregunta"));
                System.out.println("\n" + result.getString("todas_respuestas"));
                System.out.println("\n" + "Escribe la respuesta correcta: ");
                Scanner sc = new Scanner(System.in);
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase(result.getString("respuesta_letra"))) {
                    aciertos++;
                } else {
                    fallos++;
                }
            }
            crearPreguntas.addResultado(usuario, String.valueOf(aciertos), String.valueOf(fallos));
            System.out.println("\n" + "Aciertos: " + aciertos);
            System.out.println("\n" + "Fallos: " + fallos);
        } 
        catch (Exception e) { System.out.println("\n" + e);}
    }
    public void creacion_preguntas(){

        CrearPreguntas crearPreguntas = new CrearPreguntas();
        String cont = "s";
        String respuesta_definitiva = "";
            
        while (!cont.equalsIgnoreCase("n")) {

            String pregunta = preguntas();
            String respuesta_correcta = respuestas_correctas();
            ArrayList<ArrayList<String>> almacen = respuestas();
            String almacen_string = String.valueOf(almacen.get(0).get(0)) + ", " + String.valueOf(almacen.get(0).get(1) ) + ", " + String.valueOf(almacen.get(0).get(2)) + ", " + String.valueOf(almacen.get(0).get(3));
            if (respuesta_correcta.equalsIgnoreCase("a")){
                respuesta_definitiva = almacen.get(1).get(0);
            } else if (respuesta_correcta.equalsIgnoreCase("b")){
                respuesta_definitiva = almacen.get(1).get(1);
            } else if (respuesta_correcta.equalsIgnoreCase("c")){
                respuesta_definitiva = almacen.get(1).get(2);
            } else { respuesta_definitiva = almacen.get(1).get(3);}
            crearPreguntas.addPregunta(pregunta, almacen_string, respuesta_definitiva, respuesta_correcta);
            cont = continuar();
        }
    }
    
    
    public String seleccion_usuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige el tipo de usuario que quiera ser: (usuario/admin)");
        String operacion = sc.nextLine();
        return operacion;
    }
    
    public static String continuar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Desea continuar generando preguntas? (s/n)");
        String operacion = sc.nextLine();
        return operacion;
    }    
    public String preguntas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Realice la pregunta: ");
        String operacion = sc.nextLine();
        return operacion;
    }

    public ArrayList<ArrayList<String>> respuestas(){

        String[] letras = {"a) ", "b) ", "c) ", "d) "};
        ArrayList<String> almacen = new ArrayList<String>();
        ArrayList<String> almacen_rest = new ArrayList<String>();
        ArrayList<ArrayList<String>> return_values = new ArrayList<ArrayList<String>>();


        for (int i = 0; i < 4; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la respuesta " + letras[i]);
            String operacion = sc.nextLine();
            almacen_rest.add(operacion);
            String resultado = letras[i] + operacion;
            almacen.add(resultado);
        }
        return_values.add(almacen);
        return_values.add(almacen_rest);
        return return_values;
    }

    public String respuestas_correctas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique cual va a ser la respuesta correcta: (a, b, c, d)");
        String operacion = sc.nextLine();
        return operacion;
    }
    
}
