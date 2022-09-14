import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.get_connection()){

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
