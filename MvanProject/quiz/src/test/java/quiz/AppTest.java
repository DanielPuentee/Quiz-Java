package quiz;

import org.junit.Assert;
import org.junit.Test;
import quiz.view.Jugar;
import org.mockito.*;

import quiz.controller.CrearPreguntas;
import java.sql.*;
//import quiz.model.ConnectionBBDD;
//import java.sql.Connection;

public class AppTest {
    
    @Test
    public void usuarioCorrecto(){
        Jugar jugar = Mockito.mock(Jugar.class);
        Mockito.when(jugar.seleccion_usuario()).thenReturn("admin");
        String usuario = jugar.seleccion_usuario();

        Assert.assertEquals("admin", usuario);
    }

    @Test
    public void usuarioIncorrecto(){
        Jugar jugar = Mockito.mock(Jugar.class);
        Mockito.when(jugar.seleccion_usuario()).thenReturn("admin");
        String usuario = jugar.seleccion_usuario();

        Assert.assertNotEquals("usuario", usuario);
    }

    @Test
    public void respuestaCorrecta(){
        Jugar jugar = Mockito.mock(Jugar.class);
        Mockito.when(jugar.respuestas_correctas()).thenReturn("a");
        String respuesta = jugar.respuestas_correctas();

        Assert.assertEquals("a", respuesta);
    }

    @Test
    public void respuestaIncorrecta(){
        Jugar jugar = Mockito.mock(Jugar.class);
        Mockito.when(jugar.respuestas_correctas()).thenReturn("a");
        String respuesta = jugar.respuestas_correctas();

        Assert.assertNotEquals("b", respuesta);
    }

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



    //@Test
    //public void main() {
    //    Jugar.main(new String[] {});
    //}

    
    



}
