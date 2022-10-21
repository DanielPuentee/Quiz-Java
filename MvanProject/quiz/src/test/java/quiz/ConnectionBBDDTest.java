package quiz;

import org.junit.Assert;
import org.junit.Test;
//import org.mockito.*;

import quiz.model.ConnectionBBDD;
//import java.sql.*;

import static org.mockito.Mockito.*;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionBBDDTest {


    @Mock
    ConnectionBBDD connectionBBDDMock;


    @Test
    public void conexionCorrecta(){
        assertNotNull(connectionBBDDMock);
        when(connectionBBDDMock.conexion()).thenReturn(null);
        Assert.assertEquals(null, connectionBBDDMock.conexion());
        
    }



    
}
