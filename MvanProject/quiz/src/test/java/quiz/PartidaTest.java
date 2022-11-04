package quiz;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PartidaTest {
    Partida PartidaMock = Mockito.mock(Partida.class);

    /**
     * 
     */
    @Test
    public void jugarTest(){
        
        assertNotNull(PartidaMock);
        verify(PartidaMock, times(1)).hacerPreguntas();
    }

    @Test
    public void mostrarPuntuacionTest(){
        
        assertNotNull(PartidaMock);
        verify(PartidaMock, times(1)).mostrarPuntuacion();
    }
}
