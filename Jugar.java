
import java.util.ArrayList;
import java.util.Scanner;

public class Jugar extends Almacenamiento {

    public Jugar() {}

    public void run(){
        Almacenamiento p = new Almacenamiento();
        String usuario = p.seleccion_usuario();
        
        if (usuario.equalsIgnoreCase("admin")) {
            ArrayList<ArrayList<String>> almacen = p.creacion_preguntas();
            juego(almacen);
        } else {
            ArrayList<String> almacen_preguntas = p.almacen_preguntas_iniciales();
            ArrayList<String> almacen_respuestas = p.almacen_respuestas_iniciales();
            ArrayList<String> almacen_respuestas_correctas = p.almacen_respuestas_correctas();

            ArrayList<ArrayList<String>> almacen = new ArrayList();
            almacen.add(almacen_preguntas);
            almacen.add(almacen_respuestas);
            almacen.add(almacen_respuestas_correctas);
            juego(almacen);
        }
    }

    public static void juego(ArrayList<ArrayList<String>> almacen){

        ArrayList<String> respuestas_respondidas = new ArrayList();
        Integer contador = 0;

        for (int i = 0; i < almacen.get(0).size(); i++) {
            System.out.println(almacen.get(0).get(i));
            System.out.println(almacen.get(1).get(i) + "\n");

            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la respuesta (a, b, c, d)" );
            String operacion = sc.nextLine();
            System.out.println("================================== \n" );
            respuestas_respondidas.add(operacion);

            if (operacion.equals(almacen.get(2).get(i))) {
                contador++;}
        }
        System.out.println("Respuestas correctas: " + contador + "/" + almacen.get(0).size());

    }
    
}
