package quiz;

import java.sql.*;

public class PreguntasDAO {

    private static Connection conexion = null;
    private static Connection conexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz01", "root", "123456789");
        }
        catch(Exception e) { System.out.println("Error al conectar con la base de datos"); }
        return conexion;
    }
    
    public void addPregunta(String pregunta, String todas_respuestas, String respuesta, String respuesta_letra){

        try {
            Connection con = conexion();
            PreparedStatement myPreparedStatement = con.prepareStatement("INSERT INTO preguntas (pregunta, todas_respuestas, respuesta, respuesta_letra) VALUES (?, ?, ?, ?)");
            myPreparedStatement.setString(1, pregunta);
            myPreparedStatement.setString(2, todas_respuestas);
            myPreparedStatement.setString(3, respuesta);
            myPreparedStatement.setString(4, respuesta_letra);

        } 
        catch (Exception e) { System.out.println("Error al insertar la pregunta"); }
    }

    public ResultSet getPreguntas(){
        
        try {
            Connection con = conexion();
            Statement myStatement = con.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM pruebas");
            return rs;
            
        } catch (Exception e) { System.out.println("Error al seleccionar las preguntas"); }
        return null;
    }

    public static void addResultado(String usuario, String correctas, String fallos){
            
        try {
            Connection con = conexion();
            PreparedStatement myPreparedStatement = con.prepareStatement("INSERT INTO resultados (usuario, correctas, fallos) VALUES (?, ?, ?)");
            myPreparedStatement.setString(1, usuario);
            myPreparedStatement.setString(2, correctas);
            myPreparedStatement.setString(3, fallos);

        } catch (Exception e) { System.out.println("Error al insertar el resultado"); }
}   

}
