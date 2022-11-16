package com.quiz.model;

import java.io.Serializable;
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
    
}
