import com.sun.org.apache.xml.internal.utils.SystemIDResolver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null; //Sentencia para la insercion de datos
            try{
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?);";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje()); //dado que la consulta tiene dos parametros se debe especifica. Son string
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            }catch(SQLException e){
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public static void leerMensajesBD(){
        Conexion db_connect = new Conexion(); //valida la conexión
        PreparedStatement ps = null;
        ResultSet rs = null; //trae la información organizada
        try(Connection conexion = db_connect.get_connection()){
            String query ="SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs=ps.executeQuery(); //realiza la consulta
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("No se pudieron obtener los datos");
        }
    }

    public static void borrarMensajesDB(int id_mensaje){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.get_connection()) {
            PreparedStatement ps = null;
            try{
                String query="DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("El mensaje se borró de manera exitosa");

            }catch(SQLException e){
                System.out.println(e);
                System.out.println("No se pudo borrar el mensaje");
            }
        }catch(SQLException e){

        }
    }

    public static void actualizarMensajesDB(Mensajes mensaje){

    }

}
