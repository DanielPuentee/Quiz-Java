
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
    public ArrayList<String> respuestas(){
        String[] letras = {"a) ", "b) ", "c) ", "d) "};
        ArrayList<String> almacen = new ArrayList<String>();

        for (int i = 0; i < 4; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese la respuesta " + letras[i]);
            String operacion = sc.nextLine();
            String resultado = letras[i] + operacion;
            almacen.add(resultado);
        }
        return almacen;
    }

    public String respuestas_correctas(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique cual es la respuesta correcta: (a,b,c,d)");
        String operacion = sc.nextLine();
        return operacion;
    }


    
}
