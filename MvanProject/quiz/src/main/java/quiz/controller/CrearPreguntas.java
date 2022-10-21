package quiz.controller;

import quiz.model.ConnectionBBDD;
import java.sql.*;
import java.sql.Connection;

public class CrearPreguntas {

    ConnectionBBDD conexion = new ConnectionBBDD();
    private Connection con = conexion.conexion();
    private boolean state = false;
    private String insert_query_respuestas = "INSERT INTO preguntas (pregunta, todas_respuestas, respuesta, respuesta_letra) VALUES (?, ?, ?, ?)";
    private String insert_query_resultados = "INSERT INTO resultados (usuario, correctas, fallos) VALUES (?, ?, ?)";
    private String select_query = "SELECT * FROM pruebas";
    private String error_insert_pregunta = "Error al insertar la pregunta";
    private String error_insert_resultado = "Error al insertar el resultado";
    private String error_select = "Error al seleccionar las preguntas";
    
    
    public CrearPreguntas(){}

    public boolean addPregunta(String pregunta, String todas_respuestas, String respuesta, String respuesta_letra){

        try {

            PreparedStatement myPreparedStatement = con.prepareStatement(insert_query_respuestas);
            myPreparedStatement.setString(1, pregunta);
            myPreparedStatement.setString(2, todas_respuestas);
            myPreparedStatement.setString(3, respuesta);
            myPreparedStatement.setString(4, respuesta_letra);
            state = true;

        } 
        catch (Exception e) { System.out.println(error_insert_pregunta); }
        return state;
    }

    public ResultSet getPreguntas(){
        try {

            Statement myStatement = con.createStatement();
            ResultSet rs = myStatement.executeQuery(select_query);
            return rs;
            
        } catch (Exception e) { System.out.println(error_select); }
        return null;
    }

    public boolean addResultado(String usuario, String correctas, String fallos){
            
            try {

                PreparedStatement myPreparedStatement = con.prepareStatement(insert_query_resultados);
                myPreparedStatement.setString(1, usuario);
                myPreparedStatement.setString(2, correctas);
                myPreparedStatement.setString(3, fallos);
                state = true;

            } catch (Exception e) { System.out.println(error_insert_resultado); }
            return state;
    }    
}
