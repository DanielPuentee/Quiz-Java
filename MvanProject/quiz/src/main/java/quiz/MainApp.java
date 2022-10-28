package quiz;

import java.util.Scanner;

public class MainApp {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String usuario = seleccionarUsuario();
        
        while (!usuario.equalsIgnoreCase("exit")) {
            
            PreguntasFactory preguntasFactory = new PreguntasFactory();
            if (usuario.equalsIgnoreCase("admin")) {
                Partida partida = new Partida(usuario);
                preguntasFactory.CrearPreguntas();
                partida.jugar();
            } else {
                Partida partida = new Partida(usuario);
                partida.jugar();
            }
            usuario = seleccionarUsuario();
        }
        System.out.println("\n ****************** ¡¡¡ GRACIAS POR JUGAR !!! ****************** \n");
    }

    public static String seleccionarUsuario() {
        System.out.println("Escribe tu nombre de usuario: (user/admin o exit para salir)");
        String usuario = sc.nextLine();
        return usuario;
    }


    
}
