/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jorge.rodriguez
 */
public class Conexion {

    

    // Librería de MySQL
    // public String driver = "com.mysql.jdbc.Driver";
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    // public String database = "anacond1_Pet";
    public String database = "banco";

    // Host
    public String hostname = "localhost";
    //  public String hostname = "mysql3000.mochahost.com";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true";

    // Nombre de usuario
    public String username = "root";
    //  public String username = "anacond1_petsky";

    // Clave de usuario
    //public String password = "pochon.21";
    //public String password = "pruebas5";


  public String password = "pochon";
 


    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
    
    
    
    private static Statement statement;
    private static Conexion conection;
    public static int ejecutarSentencia(String sql) throws SQLException{
        statement = conection.conectarMySQL().createStatement();
        return statement.executeUpdate(sql);
    }

}
