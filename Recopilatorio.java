

import java.util.ArrayList;
import java.util.Scanner;

public class Recopilatorio extends CrearPreguntas{

    public Recopilatorio() {}

    public ArrayList<String> almacen_preguntas_iniciales(){

        ArrayList<String> preguntas = new ArrayList<String>();

        preguntas.add("Cual es el resultado de 8x2?");
        preguntas.add("Que pais tiene la mayor cantidad de islas en el mundo?");
        preguntas.add("Cual es la capital de Canada?");
        preguntas.add("Cual es el pais mas pequeno del mundo?");
        preguntas.add("Cuantas zonas horarias tiene en Rusia?");

        return preguntas;
    }

    public ArrayList<String> almacen_respuestas_iniciales(){
            
            ArrayList<String> respuestas = new ArrayList<String>();
    
            respuestas.add("a) 16, b) 18, c) 20, d) 22");
            respuestas.add("a) Indonesia, b) Japon, c) Suecia, d) Rusia");
            respuestas.add("a) Ottawa, b) Toronto, c) Montreal, d) Vancouver");
            respuestas.add("a) Monaco, b) Vaticano, c) San Marino, d) Liechtenstein");
            respuestas.add("a) 14, b) 12, c) 13, d) 11");
    
            return respuestas;
    }

    public ArrayList<String> almacen_respuestas_correctas(){

        ArrayList<String> respuestas = new ArrayList<String>();

        respuestas.add("a");
        respuestas.add("c");
        respuestas.add("a");
        respuestas.add("b");
        respuestas.add("d");

        return respuestas;

    }
}
