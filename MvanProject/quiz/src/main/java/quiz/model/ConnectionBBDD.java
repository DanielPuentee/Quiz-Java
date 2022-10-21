package quiz.model;

//import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionBBDD {

    private String url = "jdbc:mysql://localhost:3306/quiz01";
    private String user = "root";
    private String password = "123456789";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String error = "Error al conectar con la base de datos";
    private Connection conexion = null;

    public Connection conexion() {

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
        }
        catch(Exception e) { System.out.println(error); }
        return conexion;
    }    


}
