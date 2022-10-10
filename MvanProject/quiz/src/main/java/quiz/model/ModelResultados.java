package quiz.model;

public class ModelResultados {

    private String usuario;
    private String correctas;
    private String fallos;

    public ModelResultados(){}

    public ModelResultados(String usuario, String correctas, String fallos){
        this.usuario = usuario;
        this.correctas = correctas;
        this.fallos = fallos;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public String getCorrectas(){
        return this.correctas;
    }
    public String getFallos(){
        return this.fallos;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setCorrectas(String correctas){
        this.correctas = correctas;
    }
    public void setFallos(String fallos){
        this.fallos = fallos;
    }
    
    
}
