package quiz;

//import org.junit.Assert;
import org.junit.Test;
import quiz.view.Jugar;
import org.mockito.*;

import static org.mockito.Mockito.*;
import java.util.ArrayList;

import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//import quiz.model.ConnectionBBDD;
//import java.sql.Connection;

// then return excepcion
public class JugarTest {

    @Mock
    Jugar JugarMock;
    private ArrayList<String> almacen_resultados = new ArrayList<String>();
    private ArrayList<String> almacen_operacion = new ArrayList<String>();
    private ArrayList<ArrayList<String>> return_values = new ArrayList<ArrayList<String>>();
    
    @Test
    public void respuestasTest(){
        assertNotNull(JugarMock);
        almacen_operacion.add("a");
        almacen_operacion.add("b");
        almacen_operacion.add("c");
        almacen_operacion.add("d");

        almacen_resultados.add("1");
        almacen_resultados.add("2");
        almacen_resultados.add("3");
        almacen_resultados.add("4");

        return_values.add(almacen_resultados);
        return_values.add(almacen_operacion);

        when(JugarMock.respuestas()).thenReturn(return_values);
        Assert.assertEquals(return_values, JugarMock.respuestas());
        //Assert.assertEquals(true, JugarMock.respuestas(i));


    }


    //public void usuarioCorrecto(){
      //  Scanner sc = Mockito.mock(Scanner.class);
        //Mockito.when(sc.nextLine()).thenReturn("admin");
    //}

}
