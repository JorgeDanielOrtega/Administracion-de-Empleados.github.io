package prueb;

import java.sql.*;

public class DBConnect {

    Connection connection = null;
    private String database = "d3iqjvqiocgmtu";
    private long port = 5432;
    private String host = "ec2-3-224-8-189.compute-1.amazonaws.com";
    private String usuario = "tccfapvzvqwuqu";
    private String password = "c95e2138da8bc17d32e87bbb0ba155ae9a1b45af30ef676a98a9ce86d1392496";
    String url = "jdbc:postgresql://" + host + ':' + port + '/' + database;

    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, usuario, password);
            System.out.println("conexion EXITOSA");
        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
            System.out.println("No se conecto");
        } finally {
            return connection;
        }
    }
    
    public void desconectar(){
        try {
            connection.close();
        } catch (SQLException ex) {
            System.err.println("Hubo un error al cerrar la conexion");
        }
    }

}
