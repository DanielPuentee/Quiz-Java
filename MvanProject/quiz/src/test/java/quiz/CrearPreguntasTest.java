package quiz;

import org.junit.Assert;
import org.junit.Test;
//import org.mockito.*;

import quiz.controller.CrearPreguntas;

import static org.mockito.Mockito.*;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import quiz.controller.CrearPreguntas;
//import static org.mockito.Mockito.verify;

//import java.sql.*;

public class CrearPreguntasTest {

    private String pregunta = "¿Cuál es el nombre del profesor?";
    private String todas_respuestas = "a) Juan b) Pedro c) José d) Manuel";
    private String respuesta = "Juan";
    private String respuesta_letra = "a";
    private String usuario = "admin";
    private String correctas = "8";
    private String fallos = "2";

    @Mock
    CrearPreguntas CrearPreguntasMock;

    /**
     * 
     */
    @Test
    public void setCorrectaMySqlPregunta(){
        assertNotNull(CrearPreguntasMock);
        when(CrearPreguntasMock.addPregunta(pregunta, todas_respuestas, respuesta, respuesta_letra)).thenReturn(true);
        Assert.assertEquals(true, CrearPreguntasMock.addPregunta(pregunta, todas_respuestas, respuesta, respuesta_letra));
    }

    @Test
    public void setCorrectaMySqlResultados(){
        assertNotNull(CrearPreguntasMock);
        when(CrearPreguntasMock.addResultado(usuario, correctas, fallos)).thenReturn(true);
        Assert.assertEquals(true, CrearPreguntasMock.addResultado(usuario, correctas, fallos));
    }


    //@Test
    //public void getCorrectaMySqlPregunta(){
        
        //when(CrearPreguntasMock.getPreguntas().thenReturn(rs));
        //Assert.assertEquals(rs, CrearPreguntasMock.getPreguntas());
    //}   
    
}
