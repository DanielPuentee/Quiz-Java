package quiz;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import quiz.PreguntasDAO;

public class PreguntasDAOTest {

    PreguntasDAO preguntasDAO = Mockito.mock(PreguntasDAO.class);

    @Test                                               
    @DisplayName("Add preguntas simple test")
    public void addPreguntaTest() {

        PreguntasDAO preguntasDAONoMock = new PreguntasDAO();

        ArrayList<String> almacenPregunta = new ArrayList<String>(Arrays.asList("\nCual es el resultado de 8x2?", "\nQue pais tiene la mayor cantidad de islas en el mundo?"));
        ArrayList<String> almacenTodasRespuestas = new ArrayList<String>(Arrays.asList("a) 16, b) 18, c) 20, d) 22", "a) Australia, b) Indonesia, c) Suecia, d) Rusia"));
        ArrayList<String> almacenRespuesta = new ArrayList<String>(Arrays.asList("16", "Suecia"));
        ArrayList<String> almacenRespuestaLetra = new ArrayList<String>(Arrays.asList("a", "c"));
        ArrayList<ArrayList<String>> almacen = new ArrayList<ArrayList<String>>(Arrays.asList(almacenPregunta, almacenTodasRespuestas, almacenRespuesta, almacenRespuestaLetra));

        almacen.get(0).add(2, "...");
        almacen.get(1).add(2, "...");
        almacen.get(2).add(2, "...");
        almacen.get(3).add(2, "...");

        preguntasDAONoMock.addPregunta("...", "...", "...","...", almacen);
        ArrayList<ArrayList<String>> resultado = preguntasDAONoMock.getPreguntas();
        assertEquals(almacen, resultado);

    }

    @Test                                               
    @DisplayName("Get preguntas simple test")
    public void getPreguntasTest() {

        PreguntasDAO preguntasDAONoMock = new PreguntasDAO();

        ArrayList<String> almacenPregunta = new ArrayList<String>(Arrays.asList("\nCual es el resultado de 8x2?", "\nQue pais tiene la mayor cantidad de islas en el mundo?"));
        ArrayList<String> almacenTodasRespuestas = new ArrayList<String>(Arrays.asList("a) 16, b) 18, c) 20, d) 22", "a) Australia, b) Indonesia, c) Suecia, d) Rusia"));
        ArrayList<String> almacenRespuesta = new ArrayList<String>(Arrays.asList("16", "Suecia"));
        ArrayList<String> almacenRespuestaLetra = new ArrayList<String>(Arrays.asList("a", "c"));
        ArrayList<ArrayList<String>> almacen = new ArrayList<ArrayList<String>>(Arrays.asList(almacenPregunta, almacenTodasRespuestas, almacenRespuesta, almacenRespuestaLetra));
        
        ArrayList<ArrayList<String>> resultado = preguntasDAONoMock.getPreguntas();
        assertEquals(almacen, resultado);
    }

}
