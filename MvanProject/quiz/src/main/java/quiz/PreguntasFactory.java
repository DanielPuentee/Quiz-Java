package quiz;

import quiz.PreguntasDAO;
import quiz.PreguntasDAORepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PreguntasFactory implements PreguntasDAORepository {

    private String cont = "s";
    private Scanner sc = new Scanner(System.in);
    private String[] letras = {"a) ", "b) ", "c) ", "d) "};
    private ArrayList<String> almacen_resultados = new ArrayList<String>();
    private ArrayList<String> almacen_operacion = new ArrayList<String>();
    private ArrayList<ArrayList<String>> almacen = new ArrayList<ArrayList<String>>();
    private Pregunta pregunta = new Pregunta();
    private ArrayList<String> aList = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
    private List<PreguntasDAO> tutorials = new ArrayList<>();

    public PreguntasFactory(){}

    public void crearPreguntas(){
        
        tutorials = findAll();
        while (!cont.equalsIgnoreCase("n")) {


            privateSetTextAndRespuestasCorrectas();
            almacen = privateSetRespuestasCorrectasTexto();
            Random random = new Random();
            Integer number = random.nextInt(1000);
            integrateResults(number, pregunta.getTexto(), pregunta.getrespuestasCorrectasTexto(), "##################", pregunta.getRespuestasCorrectas());
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

    @Override
    public <S extends PreguntasDAO> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends PreguntasDAO> Iterable<S> save(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PreguntasDAO findOne(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean exists(Integer id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Iterable<PreguntasDAO> findAll(Iterable<Integer> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(PreguntasDAO entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Iterable<? extends PreguntasDAO> entities) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<PreguntasDAO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void saveAll(List<PreguntasDAO> preguntasDAO) {
        // TODO Auto-generated method stub
        
    }
}
