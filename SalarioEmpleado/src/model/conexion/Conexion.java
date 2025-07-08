package model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String DB = "empleados_db";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DB;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection conn = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            if (conn != null) {
                System.out.println("☑️ Conexión a Base de Datos Exitosa: " + DB);
            }

        } catch (SQLException e) {
            System.err.println("✖️ Error al conectar a la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("✖️ Driver JDBC no encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("✖️ Error inesperado al conectar a la base de datos: " + e.getMessage());
        }

        return conn;
    }

    public void desconectar() {
        conn = null;
    }
}
