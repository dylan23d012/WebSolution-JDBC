package com.websolution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicioDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3307/websolution?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "DYLAN334";

    public void insertarServicio(Servicio servicio) {

        String sql = "INSERT INTO servicios "
                + "(nombre, descripcion, precio) "
                + "VALUES (?, ?, ?)";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setString(1, servicio.getNombre());
            sentencia.setString(2, servicio.getDescripcion());
            sentencia.setDouble(3, servicio.getPrecio());

            sentencia.executeUpdate();

            System.out.println("Servicio registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar el servicio.");
            e.printStackTrace();
        }
    }

    public void listarServicios() {

        String sql = "SELECT id_servicio, nombre, descripcion, precio "
                + "FROM servicios";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql);
             ResultSet resultado =
                     sentencia.executeQuery()) {

            while (resultado.next()) {

                System.out.println(
                        resultado.getInt("id_servicio")
                        + " | "
                        + resultado.getString("nombre")
                        + " | "
                        + resultado.getString("descripcion")
                        + " | $"
                        + resultado.getDouble("precio")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar los servicios.");
            e.printStackTrace();
        }
    }

    public void actualizarServicio(Servicio servicio) {

        String sql =
                "UPDATE servicios SET "
                + "nombre = ?, "
                + "descripcion = ?, "
                + "precio = ? "
                + "WHERE id_servicio = ?";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setString(1, servicio.getNombre());
            sentencia.setString(2, servicio.getDescripcion());
            sentencia.setDouble(3, servicio.getPrecio());
            sentencia.setInt(4, servicio.getIdServicio());

            int filasActualizadas = sentencia.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Servicio actualizado correctamente.");
            } else {
                System.out.println("No se encontró el servicio.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el servicio.");
            e.printStackTrace();
        }
    }

    public void eliminarServicio(int idServicio) {

        String sql =
                "DELETE FROM servicios WHERE id_servicio = ?";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idServicio);

            int filasEliminadas = sentencia.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Servicio eliminado correctamente.");
            } else {
                System.out.println("No se encontró el servicio.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el servicio.");
            e.printStackTrace();
        }
    }
}
