package com.websolution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProyectoDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3307/websolution?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "DYLAN334";

    // =========================
    // CREATE
    // =========================

    public void insertarProyecto(Proyecto proyecto) {

        String sql = "INSERT INTO proyectos "
                + "(nombre, descripcion, fecha_inicio, fecha_fin, estado, id_cliente) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setString(1, proyecto.getNombre());
            sentencia.setString(2, proyecto.getDescripcion());

            if (proyecto.getFechaInicio() != null) {
                sentencia.setDate(3,
                        java.sql.Date.valueOf(proyecto.getFechaInicio()));
            } else {
                sentencia.setDate(3, null);
            }

            if (proyecto.getFechaFin() != null) {
                sentencia.setDate(4,
                        java.sql.Date.valueOf(proyecto.getFechaFin()));
            } else {
                sentencia.setDate(4, null);
            }

            sentencia.setString(5, proyecto.getEstado());
            sentencia.setInt(6, proyecto.getIdCliente());

            sentencia.executeUpdate();

            System.out.println("Proyecto registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar el proyecto.");
            e.printStackTrace();
        }
    }

    // =========================
    // READ
    // =========================

    public void listarProyectos() {

        String sql =
                "SELECT p.id_proyecto, p.nombre, "
                + "c.nombre AS cliente, p.estado "
                + "FROM proyectos p "
                + "INNER JOIN clientes c "
                + "ON p.id_cliente = c.id_cliente";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql);
             ResultSet resultado =
                     sentencia.executeQuery()) {

            while (resultado.next()) {

                System.out.println(
                        resultado.getInt("id_proyecto")
                        + " | "
                        + resultado.getString("nombre")
                        + " | Cliente: "
                        + resultado.getString("cliente")
                        + " | Estado: "
                        + resultado.getString("estado")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar los proyectos.");
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE
    // =========================

    public void actualizarProyecto(Proyecto proyecto) {

        String sql =
                "UPDATE proyectos SET "
                + "nombre = ?, "
                + "descripcion = ?, "
                + "fecha_inicio = ?, "
                + "fecha_fin = ?, "
                + "estado = ?, "
                + "id_cliente = ? "
                + "WHERE id_proyecto = ?";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setString(1, proyecto.getNombre());
            sentencia.setString(2, proyecto.getDescripcion());

            if (proyecto.getFechaInicio() != null) {
                sentencia.setDate(3,
                        java.sql.Date.valueOf(proyecto.getFechaInicio()));
            } else {
                sentencia.setDate(3, null);
            }

            if (proyecto.getFechaFin() != null) {
                sentencia.setDate(4,
                        java.sql.Date.valueOf(proyecto.getFechaFin()));
            } else {
                sentencia.setDate(4, null);
            }

            sentencia.setString(5, proyecto.getEstado());
            sentencia.setInt(6, proyecto.getIdCliente());
            sentencia.setInt(7, proyecto.getIdProyecto());

            int filasActualizadas = sentencia.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Proyecto actualizado correctamente.");
            } else {
                System.out.println("No se encontró el proyecto.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el proyecto.");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE
    // =========================

    public void eliminarProyecto(int idProyecto) {

        String sql =
                "DELETE FROM proyectos WHERE id_proyecto = ?";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idProyecto);

            int filasEliminadas = sentencia.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Proyecto eliminado correctamente.");
            } else {
                System.out.println("No se encontró el proyecto.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el proyecto.");
            e.printStackTrace();
        }
    }
}