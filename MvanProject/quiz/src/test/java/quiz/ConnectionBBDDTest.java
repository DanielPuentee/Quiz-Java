package quiz;

import org.junit.Assert;
import org.junit.Test;
//import org.mockito.*;

import quiz.model.ConnectionBBDD;
import java.sql.*;

public class ConnectionBBDDTest {


    ConnectionBBDD connectionBBDD = new ConnectionBBDD();

    @Test
    public void conexionCorrecta(){
        Connection conexion = connectionBBDD.conexion();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz01", "root", "123456789");
            Assert.assertNotEquals(conn, conexion);
        }catch(Exception e){System.out.println(e);}
        
    }

    @Test 
    public void conexionIncorrecta(){
        Connection conexion = connectionBBDD.conexion();
        Assert.assertNotEquals(null, conexion);
    }


    
}
