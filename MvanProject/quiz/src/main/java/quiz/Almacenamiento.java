package quiz;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class Almacenamiento extends CrearPreguntas implements SeleccionUsuario{

    public Almacenamiento(){} 
    
    public void creacion_preguntas(){

        CrearPreguntas p = new CrearPreguntas();
        String cont = "s";
        String respuesta_definitiva = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz01", "root", "123456789");

            while (!cont.equalsIgnoreCase("n")) {

                String pregunta = p.preguntas();
                String respuesta_correcta = p.respuestas_correctas();
                ArrayList<ArrayList<String>> almacen = p.respuestas();
                String almacen_string = String.valueOf(almacen.get(0).get(0)) + ", " + String.valueOf(almacen.get(0).get(1) ) + ", " + String.valueOf(almacen.get(0).get(2)) + ", " + String.valueOf(almacen.get(0).get(3));
                if (respuesta_correcta.equalsIgnoreCase("a")){
                    respuesta_definitiva = almacen.get(1).get(0);
                } else if (respuesta_correcta.equalsIgnoreCase("b")){
                    respuesta_definitiva = almacen.get(1).get(1);
                } else if (respuesta_correcta.equalsIgnoreCase("c")){
                    respuesta_definitiva = almacen.get(1).get(2);
                } else {
                    respuesta_definitiva = almacen.get(1).get(3);
                }
                Statement myStatement = con.createStatement();
                String sql_Query = "INSERT INTO pruebas (pregunta, todas_respuestas, respuesta, respuesta_letra) VALUES ('" + pregunta + "', '" + almacen_string + "', '" + respuesta_definitiva + "', '" + respuesta_correcta + "')";
                myStatement.executeUpdate(sql_Query);
                cont = continuar();
            }
    
        } 
        catch (Exception e) {
            System.out.println("\n" + e);
        }

    }

    public String seleccion_usuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige el tipo de usuario que quiera ser: (usuario/admin)");
        String operacion = sc.nextLine();
        return operacion;
    }

    public static String continuar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Desea continuar generando preguntas? (s/n)");
        String operacion = sc.nextLine();
        return operacion;
    }
}
