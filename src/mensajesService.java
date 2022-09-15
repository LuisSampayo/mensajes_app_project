import com.sun.org.apache.xml.internal.utils.SystemIDResolver;

import java.util.Scanner;

public class mensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Su nombre");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
    }
    public static void listarMensaje(){
        MensajesDAO.leerMensajesBD();
    }
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt(); //toma valores numéricos
        MensajesDAO.borrarMensajesDB(id_mensaje);
    }
    public static void editarMensaje(){

    }

    //metodos que va a recibir el menu y que se va a conectar con DAO para enviar a bd


}

