package quiz;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// import static org.mockito.Mockito.*;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;

public class PreguntaTest {

    // prepare test for get a set methods
    Pregunta preguntaMock = Mockito.mock(Pregunta.class);


    @Test
    public void getTextoTest(){
        
        assertNotNull(preguntaMock);
        when(preguntaMock.getTexto()).thenReturn("...");
        assertEquals(preguntaMock.getTexto(), "...");
    }

    @Test
    public void setTextoTest(){
        
        assertNotNull(preguntaMock);
        doNothing().when(preguntaMock).setTexto("texto");
    }


    @Test
    public void getrespuestasCorrectasTextoTest(){
        
        assertNotNull(preguntaMock);
        when(preguntaMock.getrespuestasCorrectasTexto()).thenReturn("...");
        assertEquals(preguntaMock.getrespuestasCorrectasTexto(), "...");
    }


    @Test
    public void setrespuestasCorrectasTextoTest(){
        
        assertNotNull(preguntaMock);
        doNothing().when(preguntaMock).setrespuestasCorrectasTexto("respuestasCorrectasTexto");
    }


    @Test
    public void respuestasCorrectasTest(){
        
        assertNotNull(preguntaMock);
        when(preguntaMock.getRespuestasCorrectas()).thenReturn("...");
        assertEquals(preguntaMock.getRespuestasCorrectas(), "...");
    }

    @Test
    public void setRespuestasCorrectasTest(){
        
        assertNotNull(preguntaMock);
        doNothing().when(preguntaMock).setRespuestasCorrectas("respuestasCorrectas");
    }
    
    
}
