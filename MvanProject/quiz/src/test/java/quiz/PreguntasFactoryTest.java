package quiz;

import static org.mockito.Mockito.*;

// import org.mockito.junit.MockitoJUnitRunner;
// import quiz.PreguntasFactory;

// @RunWith(MockitoJUnitRunner.class)
// @ExtendWith(MockitoExtension.class)


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
public class PreguntasFactoryTest {
    
    
    PreguntasFactory preguntasFactoryMock = Mockito.mock(PreguntasFactory.class);

    @Test
    public void CrearPreguntasTest(){
        
        assertNotNull(preguntasFactoryMock);
        doNothing().when(preguntasFactoryMock).crearPreguntas();
        verify(preguntasFactoryMock, never()).crearPreguntas();
    }

    
}
