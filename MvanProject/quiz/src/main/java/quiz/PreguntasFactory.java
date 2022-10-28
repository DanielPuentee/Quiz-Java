package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class PreguntasFactory {

    private String cont = "s";
    private Scanner sc = new Scanner(System.in);
    private String[] letras = {"a) ", "b) ", "c) ", "d) "};
    private ArrayList<String> aList = new ArrayList<String>();
    private ArrayList<String> almacen_resultados = new ArrayList<String>();
    private ArrayList<String> almacen_operacion = new ArrayList<String>();
    private ArrayList<ArrayList<String>> almacen = new ArrayList<ArrayList<String>>();
    private PreguntasDAO preguntasDAO = new PreguntasDAO();
    private Pregunta pregunta = new Pregunta();

    public PreguntasFactory(){}

    public void CrearPreguntas(){

        while (!cont.equalsIgnoreCase("n")) {

            System.out.println("Realice la pregunta: ");
            pregunta.texto = sc.nextLine();
            System.out.println("Indique cual va a ser la respuesta correcta: (a, b, c, d)");
            String respuesta_correcta = sc.nextLine();

            for (int i = 0; i < 4; i++) {
                System.out.println("Ingrese la respuesta " + letras[i]);
                String operacion = sc.nextLine();
                String resultado = letras[i] + operacion;
    
                almacen_operacion.add(operacion);
                almacen_resultados.add(resultado);
            }
    
            almacen.add(almacen_resultados);
            almacen.add(almacen_operacion);
        

            aList.add("a");
            aList.add("b");
            aList.add("c");
            aList.add("d");

            String almacen_string = String.valueOf(almacen.get(0).get(0)) + ", " + String.valueOf(almacen.get(0).get(1) ) + ", " + String.valueOf(almacen.get(0).get(2)) + ", " + String.valueOf(almacen.get(0).get(3));
            boolean state_of_response = aList.contains(respuesta_correcta);

            while (!state_of_response) {
                System.out.println("La respuesta correcta debe ser una de las siguientes: a, b, c, d \n" + "Indique cual va a ser la respuesta correcta: (a, b, c, d)");
                respuesta_correcta = sc.nextLine();
                state_of_response = aList.contains(respuesta_correcta);
            }
            Integer position_leter = aList.indexOf(respuesta_correcta);
            String respuesta_definitiva = almacen.get(1).get(position_leter);
            preguntasDAO.addPregunta(pregunta.texto, almacen_string, respuesta_definitiva, respuesta_correcta);

            System.out.println("Desea continuar generando preguntas? (s/n)");
            cont = sc.nextLine();
        }
    }   
}
