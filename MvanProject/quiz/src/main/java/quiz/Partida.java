package quiz;

import java.util.Scanner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Partida {

    EntityManagerFactory em = null;
    EntityManager en = null;

    private Scanner sc = new Scanner(System.in);
    private Integer respuestasIncorrectaPuntuacion = 0;
    private Integer respuestasCorrectasPuntuacion = 0;

    public Partida(String usuario) {
    }

    public boolean verificarRespuesta(String respuesta, String preguntas) {
        if (respuesta.equalsIgnoreCase(preguntas)) { return true; } 
        else { return false; }

    }
    public void mostrarPuntuacion(){
        System.out.println("\nAciertos: " + respuestasCorrectasPuntuacion + "\nFallos: " + respuestasIncorrectaPuntuacion);
    }
    public void hacerPreguntas() { 
        EntityManager em = conexion();
        em.getTransaction().begin();
        List<Object[]> q = (List<Object[]>) em.createNativeQuery("SELECT p.pregunta, p.todasLasRespuestas, p.respuesta, p.respuestaLetras FROM jpa_prueba p").getResultList();
        for (Object[] o : q) {
            System.out.println("\nPregunta   --> " + (String)o[0]);
            System.out.println("Respuestas --> " + (String)o[1]);
            System.out.println("Escribe la respuesta correcta (a,b,c,d): ");
            String respuesta = sc.nextLine();

            if (verificarRespuesta(respuesta, (String)o[3])) { respuestasCorrectasPuntuacion++; } 
            else { respuestasIncorrectaPuntuacion++; }

        }
        em.getTransaction().commit();
        em.close();
    }
    private static EntityManager conexion(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("quiz01");
        return emf.createEntityManager();
    }

    public void jugar(){
        hacerPreguntas();
        mostrarPuntuacion();
    }
}
