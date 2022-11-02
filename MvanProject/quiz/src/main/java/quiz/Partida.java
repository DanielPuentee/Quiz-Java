package quiz;

import java.util.Scanner;

import java.sql.*;


public class Partida {

    private Scanner sc = new Scanner(System.in);
    private String usuario;
    private PreguntasDAO preguntasDAO = new PreguntasDAO();
    private Integer respuestasIncorrectaPuntuacion = 0;
    private Integer respuestasCorrectasPuntuacion = 0;
    private ResultSet preguntas = preguntasDAO.getPreguntas();

    public Partida(String usuario) {
        this.usuario = usuario;
    }

    public boolean verificarRespuesta(String respuesta, ResultSet preguntas) throws SQLException {
        if (respuesta.equalsIgnoreCase(preguntas.getString("respuesta_letra"))) {  return true; } 
        else { return false; }

    }
    public void mostrarPuntuacion(){
        System.out.println("\nAciertos: " + respuestasCorrectasPuntuacion + "\nFallos: " + respuestasIncorrectaPuntuacion);
    }
    public void hacerPreguntas() {   
        try {
            
            while (preguntas.next()) {
                System.out.println("\n" + preguntas.getString("pregunta"));
                System.out.println("\n" + preguntas.getString("todas_respuestas"));
                System.out.println("\n" + "Escribe la respuesta correcta: ");
                String respuesta = sc.nextLine();

                if (verificarRespuesta(respuesta, preguntas)) { respuestasCorrectasPuntuacion++; } 
                else { respuestasIncorrectaPuntuacion++; }
            }

            PreguntasDAO.addResultado(usuario, String.valueOf(respuestasCorrectasPuntuacion), String.valueOf(respuestasIncorrectaPuntuacion));

        } catch (Exception e) { System.out.println("\n" + e);}
    }

    public void jugar(){
        hacerPreguntas();
        mostrarPuntuacion();
    }
}
