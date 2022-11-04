package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PreguntasFactory {

    private String cont = "s";
    private Scanner sc = new Scanner(System.in);
    private String[] letras = {"a) ", "b) ", "c) ", "d) "};
    private ArrayList<String> almacen_resultados = new ArrayList<String>();
    private ArrayList<String> almacen_operacion = new ArrayList<String>();
    private ArrayList<ArrayList<String>> almacen = new ArrayList<ArrayList<String>>();
    private PreguntasDAO preguntasDAO = new PreguntasDAO();
    private Pregunta pregunta = new Pregunta();
    private ArrayList<String> aList = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));

    public PreguntasFactory(){}

    public void crearPreguntas(){

        while (!cont.equalsIgnoreCase("n")) {

            privateSetTextAndRespuestasCorrectas();
            Integer position_leter = aList.indexOf(pregunta.getRespuestasCorrectas());
            almacen = privateSetRespuestasCorrectasTexto();
            String respuesta_definitiva = almacen.get(1).get(position_leter);
            preguntasDAO.addPregunta(pregunta.getTexto(), pregunta.getrespuestasCorrectasTexto(), respuesta_definitiva, pregunta.getRespuestasCorrectas(), PreguntasDAO.almacen);
            System.out.println("Desea continuar generando preguntas? (s/n)");
            cont = sc.nextLine();
        }
    }   

    private void privateSetTextAndRespuestasCorrectas(){

        // * Metodo para almacenar preguntas y respuestas * //

        System.out.println("Realice la pregunta: ");
        pregunta.setTexto(sc.nextLine());

        System.out.println("Indique cual va a ser la respuesta correcta: (a, b, c, d)");
        pregunta.setRespuestasCorrectas(sc.nextLine());

        boolean stateOfResponse = aList.contains(pregunta.getRespuestasCorrectas());
        while (!stateOfResponse) {
            System.out.println("La respuesta correcta debe ser una de las siguientes: a, b, c, d \n" + "Indique cual va a ser la respuesta correcta: (a, b, c, d)");
            pregunta.setRespuestasCorrectas(sc.nextLine());
            stateOfResponse = aList.contains(pregunta.getRespuestasCorrectas());
        }
    }

    private ArrayList<ArrayList<String>> privateSetRespuestasCorrectasTexto(){

        // * Metodo para hacer Set de las respuestas correctas en texto * //

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
        pregunta.setrespuestasCorrectasTexto(almacen_string);
        return almacen;

    }
}
