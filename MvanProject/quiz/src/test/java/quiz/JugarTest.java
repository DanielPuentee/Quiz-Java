package quiz;

//import org.junit.Assert;
import org.junit.Test;
import quiz.view.Jugar;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

//import quiz.model.ConnectionBBDD;
//import java.sql.Connection;

public class JugarTest {
    
    @Test
    public void dinamicaCorrecta(){
        Jugar jugar = Mockito.mock(Jugar.class);
        doNothing().when(jugar).dinamica_juego("admin");
        jugar.dinamica_juego("admin");
        verify(jugar).dinamica_juego("admin");
    }


    //public void usuarioCorrecto(){
      //  Scanner sc = Mockito.mock(Scanner.class);
        //Mockito.when(sc.nextLine()).thenReturn("admin");
    //}

    
    



}
