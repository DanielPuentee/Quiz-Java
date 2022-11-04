package quiz;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import quiz.Partida;
public class PartidaTest {

    Partida partida = Mockito.mock(Partida.class);

    @Test
    public void jugarTest(){
        
        assertNotNull(partida);
        verify(partida, never()).hacerPreguntas();
    }

    @Test
    public void mostrarPuntuacionTest(){
        
        assertNotNull(partida);
        verify(partida, never()).mostrarPuntuacion();
    }

    @Test
    public void verificarRespuestaCorrectaTest(){
        Partida partidaNoMock = new Partida("user");
        boolean resultado;
        resultado = partidaNoMock.verificarRespuesta("a", "a");
        assertEquals(true, resultado);
    }

    @Test
    public void verificarRespuestaInorrectaTest(){
        Partida partidaNoMock = new Partida("user");
        boolean resultado;
        resultado = partidaNoMock.verificarRespuesta("b", "a");
        assertEquals(false, resultado);
    }
}
