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

            aList.add("a");
            aList.add("b");
            aList.add("c");
            aList.add("d");

            System.out.println("Realice la pregunta: ");
            pregunta.setTexto(sc.nextLine());

            System.out.println("Indique cual va a ser la respuesta correcta: (a, b, c, d)");
            pregunta.setRespuestasCorrectas(sc.nextLine());

            boolean state_of_response = aList.contains(pregunta.getRespuestasCorrectas());
            while (!state_of_response) {
                System.out.println("La respuesta correcta debe ser una de las siguientes: a, b, c, d \n" + "Indique cual va a ser la respuesta correcta: (a, b, c, d)");
                pregunta.setRespuestasCorrectas(sc.nextLine());
                state_of_response = aList.contains(pregunta.getRespuestasCorrectas());
            }
            Integer position_leter = aList.indexOf(pregunta.getRespuestasCorrectas());

            for (int i = 0; i < 4; i++) {
                System.out.println("Ingrese la respuesta " + letras[i]);
                String operacion = sc.nextLine();
                String resultado = letras[i] + operacion;
    
                almacen_resultados.add(resultado);
                almacen_operacion.add(operacion);
            }
    
            almacen.add(almacen_resultados);
            almacen.add(almacen_operacion);
        
            String almacen_string = String.valueOf(almacen.get(0).get(0)) + ", " + String.valueOf(almacen.get(0).get(1) ) + ", " + String.valueOf(almacen.get(0).get(2)) + ", " + String.valueOf(almacen.get(0).get(3));
            String respuesta_definitiva = almacen.get(1).get(position_leter);
            
            pregunta.setrespuestasCorrectasTexto(almacen_string);
            preguntasDAO.addPregunta(pregunta.getTexto(), pregunta.getrespuestasCorrectasTexto(), respuesta_definitiva, pregunta.getRespuestasCorrectas());

            System.out.println("Desea continuar generando preguntas? (s/n)");
            cont = sc.nextLine();
        }
    }   
}
