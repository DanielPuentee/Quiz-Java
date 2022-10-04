
import java.util.ArrayList;
import java.util.Scanner;


public class CrearPreguntas implements Preguntas {

    public CrearPreguntas(){}

    public String preguntas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Realice la pregunta: ");
        String operacion = sc.nextLine();
        return operacion;
    }

    public String respuestas(){

        String[] letras = {"a) ", "b) ", "c) ", "d) "};
        ArrayList<String> almacen = new ArrayList<String>();

        for (int i = 0; i < 4; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la respuesta " + letras[i]);
            String operacion = sc.nextLine();
            String resultado = letras[i] + operacion;
            almacen.add(resultado);
        }
        String almacen_string = String.valueOf(almacen.get(0)) + String.valueOf(almacen.get(1) )+ String.valueOf(almacen.get(2)) + String.valueOf(almacen.get(3));
        return almacen_string;
    }

    public String respuestas_correctas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique cual es la respuesta correcta: (a,b,c,d)");
        String operacion = sc.nextLine();
        return operacion;
    }


    
}
