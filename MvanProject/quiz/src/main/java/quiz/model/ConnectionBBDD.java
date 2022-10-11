package quiz.model;

//import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionBBDD {

    public Connection conexion(){
        Connection conexion = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz01", "root", "123456789");
        }catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
            conexion = null;
        }
        return conexion;
    }    


}
