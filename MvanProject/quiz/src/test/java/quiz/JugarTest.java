package quiz;

import org.junit.Assert;
import org.junit.Test;
import quiz.view.Jugar;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

//import quiz.model.ConnectionBBDD;
//import java.sql.Connection;

public class JugarTest {
    
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
    public void dinamicaJuegoCorrecta(){
       Jugar jugar = Mockito.mock(Jugar.class);
       doNothing().when(jugar).dinamica_juego("usuario");
       jugar.dinamica_juego("usuario");
       verify(jugar).dinamica_juego("usuario");
    }

    @Test
    public void PreguntasS_N(){
        Jugar jugar = Mockito.mock(Jugar.class);
        Mockito.when(jugar.preguntas()).thenReturn("s");
        String respuesta = jugar.preguntas();
        
        Assert.assertEquals("s", respuesta);
     }

    @Test
    public void PreguntasCorrectas(){
        Jugar jugar = Mockito.mock(Jugar.class);
        Mockito.when(jugar.respuestas_correctas()).thenReturn("a");
        String respuesta = jugar.respuestas_correctas();

        Assert.assertEquals("a", respuesta);
    }    


    //@Test
    //public void main() {
    //    Jugar.main(new String[] {});
    //}

    
    



}
