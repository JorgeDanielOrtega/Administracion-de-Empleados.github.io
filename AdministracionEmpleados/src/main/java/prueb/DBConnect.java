package prueb;

import java.sql.*;

public class DBConnect {

    Connection connection = null;
    private String database = "pruebita";
    private long port = 3306;
    private String host = "localhost";
    private String usuario = "root";
    private String password = "";
    String url = "jdbc:mysql://" + host + ':' + port + '/' + database;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, usuario, password);
            System.out.println("conexion EXITOSA");
        } catch (Exception e) {
            System.err.println("Error:" + e.getMessage());
            System.out.println("no se conecto");
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
