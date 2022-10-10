package quiz.model;


public class ModelPreguntasRespuesta{

    private String pregunta;
    private String todas_respuestas;
    private String respuesta;
    private String respuesta_letra;

    public ModelPreguntasRespuesta(){} 

    public ModelPreguntasRespuesta(String pregunta, String todas_respuestas, String respuesta, String respuesta_letra){
        this.pregunta = pregunta;
        this.todas_respuestas = todas_respuestas;
        this.respuesta = respuesta;
        this.respuesta_letra = respuesta_letra;

    }
    public String getPregunta(){
        return this.pregunta;
    }
    public String getTodas_respuestas(){
        return this.todas_respuestas;
    }
    public String getRespuesta(){
        return this.respuesta;
    }
    public String getRespuesta_letra(){
        return this.respuesta_letra;
    }
    public void setPregunta(String pregunta){
        this.pregunta = pregunta;
    }
    public void setTodas_respuestas(String todas_respuestas){
        this.todas_respuestas = todas_respuestas;
    }
    public void setRespuesta(String respuesta){
        this.respuesta = respuesta;
    }
    public void setRespuesta_letra(String respuesta_letra){
        this.respuesta_letra = respuesta_letra;
    }

    

}
