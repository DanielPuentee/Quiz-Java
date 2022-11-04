package quiz;

import java.util.ArrayList;
import java.util.Arrays;

public class PreguntasDAO {

    public static ArrayList<String> almacenPregunta = new ArrayList<String>(Arrays.asList("\nCual es el resultado de 8x2?", "\nQue pais tiene la mayor cantidad de islas en el mundo?"));
    public static ArrayList<String> almacenTodasRespuestas = new ArrayList<String>(Arrays.asList("a) 16, b) 18, c) 20, d) 22", "a) Australia, b) Indonesia, c) Suecia, d) Rusia"));
    public static ArrayList<String> almacenRespuesta = new ArrayList<String>(Arrays.asList("16", "Suecia"));
    public static ArrayList<String> almacenRespuestaLetra = new ArrayList<String>(Arrays.asList("a", "c"));
    public static ArrayList<ArrayList<String>> almacen = new ArrayList<ArrayList<String>>(Arrays.asList(almacenPregunta, almacenTodasRespuestas, almacenRespuesta, almacenRespuestaLetra));
    
    public PreguntasDAO() {
    }

    public void addPregunta(String pregunta, String todasRespuestas, String respuesta, String respuestaLetra, ArrayList<ArrayList<String>> almacen){
        Integer cantidadElementos = almacen.get(0).size();
        almacen.get(0).add(cantidadElementos, pregunta);
        almacen.get(1).add(cantidadElementos, todasRespuestas);
        almacen.get(2).add(cantidadElementos, respuesta);
        almacen.get(3).add(cantidadElementos, respuestaLetra);
        PreguntasDAO.almacen = almacen;
    }

    public ArrayList<ArrayList<String>> getPreguntas(){
        return almacen;    
    }
}
