package quiz;

import java.util.Scanner;
import java.util.ArrayList;



public class Partida {

    private Scanner sc = new Scanner(System.in);
    private PreguntasDAO preguntasDAO = new PreguntasDAO();
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

        ArrayList<ArrayList<String>> preguntas = preguntasDAO.getPreguntas();

        for (int i = 0; i < preguntas.get(0).size(); i++) {
            System.out.println(preguntas.get(0).get(i));
            System.out.println(preguntas.get(1).get(i));
            System.out.println("\n" + "Escribe la respuesta correcta (a,b,c,d): ");
            String respuesta = sc.nextLine();
            if (verificarRespuesta(respuesta, preguntas.get(3).get(i))) {
                respuestasCorrectasPuntuacion++;
            } else {
                respuestasIncorrectaPuntuacion++;
            }
        }
    }

    public void jugar(){
        hacerPreguntas();
        mostrarPuntuacion();
    }
}
