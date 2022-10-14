package quiz.view;

import java.util.ArrayList;
import java.util.Scanner;

import java.sql.*;

import quiz.controller.Preguntas;
import quiz.controller.CrearPreguntas;

public class Jugar extends CrearPreguntas implements Preguntas {

    private Scanner sc = new Scanner(System.in);
    private String seleccion_usuario = "Elige el tipo de usuario que quiera ser: (usuario/admin)";
    private String continuar = "Desea continuar generando preguntas? (s/n)";
    private String preguntas = "Realice la pregunta: ";
    private String respuestas_correctas = "Indique cual va a ser la respuesta correcta: (a, b, c, d)";
    private Integer aciertos = 0;
    private Integer fallos = 0;

    public void run(){   
        System.out.println(seleccion_usuario);
        String usuario = sc.nextLine();
        if (usuario.equalsIgnoreCase("admin")) {
            creacion_preguntas();
            dinamica_juego(usuario);
        } else {dinamica_juego(usuario);}
    }

    public void dinamica_juego(String usuario){
        CrearPreguntas crearPreguntas = new CrearPreguntas();
        try {
            ResultSet result = crearPreguntas.getPreguntas();

            while (result.next()) {
                System.out.println("\n" + result.getString("pregunta"));
                System.out.println("\n" + result.getString("todas_respuestas"));
                System.out.println("\n" + "Escribe la respuesta correcta: ");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase(result.getString("respuesta_letra"))) {
                    aciertos++;
                } else {fallos++;}
            }
            crearPreguntas.addResultado(usuario, String.valueOf(aciertos), String.valueOf(fallos));
            System.out.println("\n" + "Aciertos: " + aciertos);
            System.out.println("\n" + "Fallos: " + fallos);

        } catch (Exception e) { System.out.println("\n" + e);}
    }
    
    public void creacion_preguntas(){

        CrearPreguntas crearPreguntas = new CrearPreguntas();
        String cont = "s";
        String respuesta_definitiva = "";
            
        while (!cont.equalsIgnoreCase("n")) {

            System.out.println(preguntas);
            String pregunta = sc.nextLine();

            System.out.println(respuestas_correctas);
            String respuesta_correcta = sc.nextLine();

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

            System.out.println(continuar);
            cont = sc.nextLine();
        }
    }
    

    public ArrayList<ArrayList<String>> respuestas(){

        String[] letras = {"a) ", "b) ", "c) ", "d) "};
        ArrayList<String> almacen = new ArrayList<String>();
        ArrayList<String> almacen_rest = new ArrayList<String>();
        ArrayList<ArrayList<String>> return_values = new ArrayList<ArrayList<String>>();


        for (int i = 0; i < 4; i++) {
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
    
}
