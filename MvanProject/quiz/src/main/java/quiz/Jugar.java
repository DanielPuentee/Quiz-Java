package quiz;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;


public class Jugar extends Almacenamiento {

    public Jugar() {}
    
    public void run(){   
        
        Almacenamiento p = new Almacenamiento();
        String usuario = p.seleccion_usuario();
        
        if (usuario.equalsIgnoreCase("admin")) {
            p.creacion_preguntas();
            juego(usuario);
        } else {
            juego(usuario);
        }
    }

    public static void juego(String usuario){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz01", "root", "123456789");
            System.out.println("\n ****** Connection Successful ******");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM pruebas");
            ResultSet result = statement.executeQuery();

            Integer aciertos = 0;
            Integer fallos = 0;
            while (result.next()) {
                System.out.println("\n" + result.getString("pregunta"));
                System.out.println("\n" + result.getString("todas_respuestas"));
                System.out.println("\n" + "Escribe la respuesta correcta: ");
                Scanner sc = new Scanner(System.in);
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase(result.getString("respuesta_letra"))) {
                    aciertos++;
                } else {
                    fallos++;
                }
            }
            Statement myStatement = con.createStatement();
            String sql_Query = "INSERT INTO resultados (usuario, correctas, fallos)  VALUES('" + usuario + "', " + aciertos + ", " + fallos + ")";
            myStatement.executeUpdate(sql_Query);
            System.out.println("\n" + "Aciertos: " + aciertos);
            System.out.println("\n" + "Fallos: " + fallos);
            

        } 
        catch (Exception e) {
            System.out.println("\n" + e);
        }





    }
    
}
