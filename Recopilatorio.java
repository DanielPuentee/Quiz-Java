

import java.util.ArrayList;

public class Recopilatorio extends CrearPreguntas{

    public ArrayList<String> almacen_preguntas_iniciales;
    public ArrayList<String> almacen_respuestas_iniciales;
    public ArrayList<String> almacen_respuestas_correctas;

    public Recopilatorio() {

        this.almacen_preguntas_iniciales = new ArrayList<String>();
        this.almacen_respuestas_iniciales = new ArrayList<String>();
        this.almacen_respuestas_correctas = new ArrayList<String>();

        this.almacen_preguntas_iniciales.add("Cual es el resultado de 8x2?");
        this.almacen_preguntas_iniciales.add("Que pais tiene la mayor cantidad de islas en el mundo?");
        this.almacen_preguntas_iniciales.add("Cual es la capital de Canada?");
        this.almacen_preguntas_iniciales.add("Cual es el pais mas pequeno del mundo?");
        this.almacen_preguntas_iniciales.add("Cuantas zonas horarias tiene en Rusia?");

        this.almacen_respuestas_iniciales.add("a) 16, b) 18, c) 20, d) 22");
        this.almacen_respuestas_iniciales.add("a) Indonesia, b) Japon, c) Suecia, d) Rusia");
        this.almacen_respuestas_iniciales.add("a) Ottawa, b) Toronto, c) Montreal, d) Vancouver");
        this.almacen_respuestas_iniciales.add("a) Monaco, b) Vaticano, c) San Marino, d) Liechtenstein");
        this.almacen_respuestas_iniciales.add("a) 14, b) 12, c) 13, d) 11");

        this.almacen_respuestas_correctas.add("a");
        this.almacen_respuestas_correctas.add("c");
        this.almacen_respuestas_correctas.add("a");
        this.almacen_respuestas_correctas.add("b");
        this.almacen_respuestas_correctas.add("d");

    }

}
