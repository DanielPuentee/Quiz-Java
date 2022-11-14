package quiz;

// import quiz.PreguntasDAO;
// import quiz.PreguntasDAORepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class PreguntasFactory  {

    private String cont = "s";
    private Scanner sc = new Scanner(System.in);
    private String[] letras = {"a) ", "b) ", "c) ", "d) "};
    private ArrayList<String> almacen_resultados = new ArrayList<String>();
    private ArrayList<String> almacen_operacion = new ArrayList<String>();
    private ArrayList<ArrayList<String>> almacen = new ArrayList<ArrayList<String>>();
    private PreguntasDAO pregunta = new PreguntasDAO();
    private ArrayList<String> aList = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
    // private List<PreguntasDAO> tutorials = new ArrayList<>();

    public PreguntasFactory(){}

    public void crearPreguntas(){
        
        while (!cont.equalsIgnoreCase("n")) {


            privateSetTextAndRespuestasCorrectas();
            almacen = privateSetRespuestasCorrectasTexto();
            Random random = new Random();
            Integer number = random.nextInt(1000);
            integrateResults(number, pregunta.getPregunta(), pregunta.getTodasLasRespuestas(), "##################", pregunta.getRespuestaLetras());
            System.out.println("Desea continuar generando preguntas? (s/n)");
            cont = sc.nextLine();
        }
    }   
    private static void integrateResults(Integer id, String pregunta, String todasLasRespuestas, String respuesta, String respuestaLetras) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("quiz01");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();        
            PreguntasDAO preguntasDAO = new PreguntasDAO(id, pregunta, todasLasRespuestas, respuesta, respuestaLetras);
            em.persist(preguntasDAO);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
    private void privateSetTextAndRespuestasCorrectas(){

        // * Metodo para almacenar preguntas y respuestas * //

        System.out.println("Realice la pregunta: ");
        //pregunta.setTexto(sc.nextLine());
        pregunta.setPregunta(sc.nextLine());

        System.out.println("Indique cual va a ser la respuesta correcta: (a, b, c, d)");
        //pregunta.setRespuestasCorrectas(sc.nextLine());
        pregunta.setRespuestaLetras(sc.nextLine());

        boolean stateOfResponse = aList.contains(pregunta.getRespuestaLetras());
        while (!stateOfResponse) {
            System.out.println("La respuesta correcta debe ser una de las siguientes: a, b, c, d \n" + "Indique cual va a ser la respuesta correcta: (a, b, c, d)");
            pregunta.setRespuestaLetras(sc.nextLine());
            stateOfResponse = aList.contains(pregunta.getRespuestaLetras());
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
        //pregunta.setrespuestasCorrectasTexto(almacen_string);
        pregunta.setTodasLasRespuestas(almacen_string);
        
        return almacen;

    }
}
