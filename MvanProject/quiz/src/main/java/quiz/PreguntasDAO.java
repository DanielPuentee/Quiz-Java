package quiz;

import java.io.Serializable;

//import java.util.ArrayList;
//import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jpa_prueba")
public class PreguntasDAO implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "pregunta")
    private String pregunta;
 
    @Column(name = "todasLasRespuestas")
    private String todasLasRespuestas;
 
    @Column(name = "respuesta")
    private String respuesta;
 
    @Column(name = "respuestaLetras")
    private String respuestaLetras;

    //public static ArrayList<String> almacenPregunta = new ArrayList<String>(Arrays.asList("\nCual es el resultado de 8x2?", "\nQue pais tiene la mayor cantidad de islas en el mundo?"));
    //public static ArrayList<String> almacenTodasRespuestas = new ArrayList<String>(Arrays.asList("a) 16, b) 18, c) 20, d) 22", "a) Australia, b) Indonesia, c) Suecia, d) Rusia"));
    //public static ArrayList<String> almacenRespuesta = new ArrayList<String>(Arrays.asList("16", "Suecia"));
    //public static ArrayList<String> almacenRespuestaLetra = new ArrayList<String>(Arrays.asList("a", "c"));
    //public static ArrayList<ArrayList<String>> almacen = new ArrayList<ArrayList<String>>(Arrays.asList(almacenPregunta, almacenTodasRespuestas, almacenRespuesta, almacenRespuestaLetra));
    
    public PreguntasDAO() { }

    public PreguntasDAO(Integer id, String pregunta, String todasLasRespuestas, String respuesta, String respuestaLetras) {
        this.id = id;
        this.pregunta = pregunta;
        this.todasLasRespuestas = todasLasRespuestas;
        this.respuesta = respuesta;
        this.respuestaLetras = respuestaLetras;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTodasLasRespuestas() {
        return todasLasRespuestas;
    }

    public void setTodasLasRespuestas(String todasLasRespuestas) {
        this.todasLasRespuestas = todasLasRespuestas;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuestaLetras() {
        return respuestaLetras;
    }

    public void setRespuestaLetras(String respuestaLetras) {
        this.respuestaLetras = respuestaLetras;
    }
    

    //public void addPregunta(String pregunta, String todasRespuestas, String respuesta, String respuestaLetra, ArrayList<ArrayList<String>> almacen){
        //Integer cantidadElementos = almacen.get(0).size();
        //almacen.get(0).add(cantidadElementos, pregunta);
        //almacen.get(1).add(cantidadElementos, todasRespuestas);
        //almacen.get(2).add(cantidadElementos, respuesta);
        //almacen.get(3).add(cantidadElementos, respuestaLetra);
        //PreguntasDAO.almacen = almacen;
    //}

    //public ArrayList<ArrayList<String>> getPreguntas(){
        //return almacen;    
    //}
    
}
