package model.dao;

import model.conexion.Conexion;
import model.dto.EmpleadoDTO;
import java.sql.*;

public class EmpleadoDAO {

    public void registrarEmpleado(EmpleadoDTO dto) {
        String sql = "INSERT INTO empleado (documento, nombre, telefono, tipo, horas, salario, aumento, total) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Conexion conexion = new Conexion();
        Connection conn = conexion.getConexion();

        if (conn == null) {
            System.err.println("❌ No se pudo establecer la conexión con la base de datos.");
            return;
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(dto.getDocumento()));
            stmt.setString(2, dto.getNombre());
            stmt.setString(3, dto.getTelefono());
            stmt.setString(4, dto.getTipoEmp());
            stmt.setInt(5, dto.getHoras());
            stmt.setDouble(6, dto.getSalario());
            stmt.setDouble(7, dto.getAumento());
            stmt.setDouble(8, dto.getTotal());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Empleado guardado correctamente");
            } else {
                System.out.println("⚠️ No se insertó ningún dato");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al guardar empleado: " + e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("⚠️ Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
