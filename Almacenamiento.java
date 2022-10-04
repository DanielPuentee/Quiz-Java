
import java.util.ArrayList;
import java.util.Scanner;

public class Almacenamiento extends Recopilatorio implements SeleccionUsuario{

    public Almacenamiento(){} 
    
    public ArrayList<ArrayList<String>> creacion_preguntas(){

        Recopilatorio p = new Recopilatorio();
        
        ArrayList<String> almacen_preguntas = p.almacen_preguntas_iniciales();
        ArrayList<String> almacen_respuestas = p.almacen_respuestas_iniciales();
        ArrayList<String> almacen_respuestas_correctas = p.almacen_respuestas_correctas();
        ArrayList<ArrayList<String>> almacen_return = new ArrayList();
        String cont = "s";

        while (!cont.equalsIgnoreCase("n")) {

            String pregunta = p.preguntas();
            ArrayList<String> almacen = p.respuestas();
            String respuesta_correcta = p.respuestas_correctas();

            almacen_preguntas.add(pregunta);
            almacen_respuestas.add(String.valueOf(String.valueOf(almacen)));
            almacen_respuestas_correctas.add(respuesta_correcta);
            cont = continuar();
        }

        almacen_return.add(almacen_preguntas);
        almacen_return.add(almacen_respuestas);
        almacen_return.add(almacen_respuestas_correctas);

        return almacen_return;

    }

    public String seleccion_usuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige el tipo de usuario que quiera ser: (usuario/admin)");
        String operacion = sc.nextLine();
        return operacion;
    }

    public static String continuar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Desea continuar generando preguntas? (s/n)");
        String operacion = sc.nextLine();
        return operacion;
    }
}
