package quiz;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;

import quiz.controller.CrearPreguntas;

//import static org.mockito.Mockito.*;
//import quiz.controller.CrearPreguntas;
//import static org.mockito.Mockito.verify;

import java.sql.*;

public class CrearPreguntasTest {

    @Test
    public void setCorrectaMySqlPregunta(){
        CrearPreguntas crearPreguntas = Mockito.mock(CrearPreguntas.class);
        Mockito.when(crearPreguntas.addPregunta("admin", "1", "1","adaa")).thenReturn(true);
        Boolean resultado = crearPreguntas.addPregunta("admin", "1", "1","adaa");

        Assert.assertEquals(true, resultado);
    }

    @Test
    public void setCorrectaMySqlResultados(){
        CrearPreguntas crearPreguntas = Mockito.mock(CrearPreguntas.class);
        Mockito.when(crearPreguntas.addResultado("usuario", "1", "1")).thenReturn(true);
        Boolean resultado = crearPreguntas.addResultado("usuario", "1", "1");

        Assert.assertEquals(true, resultado);
    }


    @Test
    public void getCorrectaMySqlPregunta(){
        CrearPreguntas crearPreguntas = Mockito.mock(CrearPreguntas.class);
        Mockito.when(crearPreguntas.getPreguntas()).thenReturn(null);
        ResultSet resultado = crearPreguntas.getPreguntas();

        Assert.assertEquals(null, resultado);
    }   
    
}
