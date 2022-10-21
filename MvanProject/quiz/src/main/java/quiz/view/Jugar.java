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
    private String cont = "s";
    private String respuesta_definitiva = "";
    private String[] letras = {"a) ", "b) ", "c) ", "d) "};
    private String escriba_respuesta_correcta = "\n" + "Escribe la respuesta correcta: ";
    private String error_inserccion_respuesta = "La respuesta correcta debe ser una de las siguientes: a, b, c, d \n";

    private ArrayList<String> aList = new ArrayList<String>();
    private ArrayList<String> almacen_resultados = new ArrayList<String>();
    private ArrayList<String> almacen_operacion = new ArrayList<String>();
    private ArrayList<ArrayList<String>> return_values = new ArrayList<ArrayList<String>>();
    

    CrearPreguntas crearPreguntas = new CrearPreguntas();
    ResultSet result = crearPreguntas.getPreguntas();

    // ############################################################################################################################################
    
    public void run() {   
        System.out.println(seleccion_usuario);
        String usuario = sc.nextLine();

        if (usuario.equalsIgnoreCase("admin")) {

            creacion_preguntas();
            dinamica_juego(usuario);

        } else {
            dinamica_juego(usuario); 
        }
    }

    public void dinamica_juego(String usuario){
        
        try {
            
            while (result.next()) {
                System.out.println("\n" + result.getString("pregunta"));
                System.out.println("\n" + result.getString("todas_respuestas"));
                System.out.println(escriba_respuesta_correcta);
                String respuesta = sc.nextLine();

                if (respuesta.equalsIgnoreCase(result.getString("respuesta_letra"))) { aciertos++; } 
                else { fallos++; }
            }

            crearPreguntas.addResultado(usuario, String.valueOf(aciertos), String.valueOf(fallos));
            System.out.println("\nAciertos: " + aciertos + "\nFallos: " + fallos);

        } catch (Exception e) { System.out.println("\n" + e);}
    }
    
    public void creacion_preguntas(){
                    
        while (!cont.equalsIgnoreCase("n")) {

            System.out.println(preguntas);
            String pregunta = sc.nextLine();

            System.out.println(respuestas_correctas);
            String respuesta_correcta = sc.nextLine();

            ArrayList<ArrayList<String>> almacen = respuestas();

            aList.add("a");
            aList.add("b");
            aList.add("c");
            aList.add("d");

            String almacen_string = String.valueOf(almacen.get(0).get(0)) + ", " + String.valueOf(almacen.get(0).get(1) ) + ", " + String.valueOf(almacen.get(0).get(2)) + ", " + String.valueOf(almacen.get(0).get(3));
            boolean state_of_response = aList.contains(respuesta_correcta);
            while (!state_of_response) {
                System.out.println(error_inserccion_respuesta + respuestas_correctas);
                respuesta_correcta = sc.nextLine();
                state_of_response = aList.contains(respuesta_correcta);
            }
            Integer position_leter = aList.indexOf(respuesta_correcta);
            respuesta_definitiva = almacen.get(1).get(position_leter);
            crearPreguntas.addPregunta(pregunta, almacen_string, respuesta_definitiva, respuesta_correcta);

            System.out.println(continuar);
            cont = sc.nextLine();
        }
    }
    

    public ArrayList<ArrayList<String>> respuestas(){

        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese la respuesta " + letras[i]);
            String operacion = sc.nextLine();
            String resultado = letras[i] + operacion;

            almacen_operacion.add(operacion);
            almacen_resultados.add(resultado);
        }

        return_values.add(almacen_resultados);
        return_values.add(almacen_operacion);
        return return_values;
    }
    
}
