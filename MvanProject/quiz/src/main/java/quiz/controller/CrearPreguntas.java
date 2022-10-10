package quiz.controller;

import quiz.model.ConnectionBBDD;
import java.sql.*;
import java.sql.Connection;

public class CrearPreguntas {

    public CrearPreguntas(){}

    public boolean addPregunta(String pregunta, String todas_respuestas, String respuesta, String respuesta_letra){

        ConnectionBBDD conexion = new ConnectionBBDD();
        boolean state = false;
        try {
            Connection con = conexion.conexion();
            Statement myStatement = con.createStatement();
            String sql_Query = "INSERT INTO pruebas (pregunta, todas_respuestas, respuesta, respuesta_letra) VALUES ('" + pregunta + "', '" + todas_respuestas + "', '" + respuesta + "', '" + respuesta_letra + "')";
            myStatement.executeUpdate(sql_Query);
            state = true;

        } catch (Exception e) {
            System.out.println("Error al insertar pregunta");
        }
        return state;
    }

    public ResultSet getPreguntas(){

        ConnectionBBDD conexion = new ConnectionBBDD();
        try {
            Connection con = conexion.conexion();
            Statement myStatement = con.createStatement();
            String sql_Query = "SELECT * FROM pruebas";
            ResultSet rs = myStatement.executeQuery(sql_Query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error al mostrar preguntas");
        }
        return null;
    }

    public boolean addResultado(String usuario, String correctas, String fallos){
            
            ConnectionBBDD conexion = new ConnectionBBDD();
            boolean state = false;
            try {
                Connection con = conexion.conexion();
                Statement myStatement = con.createStatement();
                String sql_Query = "INSERT INTO resultados (usuario, correctas, fallos) VALUES ('" + usuario + "', " + correctas + ", " + fallos + ")";
                myStatement.executeUpdate(sql_Query);
                state = true;
    
            } catch (Exception e) {
                System.out.println("Error al insertar resultado");
            }
            return state;
    }    
}
