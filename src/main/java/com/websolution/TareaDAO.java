package com.websolution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TareaDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3307/websolution?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "DYLAN334";

    // =========================
    // CREATE
    // =========================

    public void insertarTarea(Tarea tarea) {

        String sql = "INSERT INTO tareas "
                + "(nombre, descripcion, estado, fecha_limite, id_proyecto) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setString(1, tarea.getNombre());
            sentencia.setString(2, tarea.getDescripcion());
            sentencia.setString(3, tarea.getEstado());

            if (tarea.getFechaLimite() != null) {
                sentencia.setDate(4,
                        java.sql.Date.valueOf(tarea.getFechaLimite()));
            } else {
                sentencia.setDate(4, null);
            }

            sentencia.setInt(5, tarea.getIdProyecto());

            sentencia.executeUpdate();

            System.out.println("Tarea registrada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar la tarea.");
            e.printStackTrace();
        }
    }

    // =========================
    // READ
    // =========================

    public void listarTareas() {

        String sql =
                "SELECT t.id_tarea, t.nombre, t.descripcion, "
                + "t.estado, t.fecha_limite, "
                + "p.nombre AS proyecto "
                + "FROM tareas t "
                + "INNER JOIN proyectos p "
                + "ON t.id_proyecto = p.id_proyecto";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql);
             ResultSet resultado =
                     sentencia.executeQuery()) {

            while (resultado.next()) {

                System.out.println(
                        resultado.getInt("id_tarea")
                        + " | "
                        + resultado.getString("nombre")
                        + " | "
                        + resultado.getString("descripcion")
                        + " | "
                        + resultado.getString("estado")
                        + " | "
                        + resultado.getDate("fecha_limite")
                        + " | Proyecto: "
                        + resultado.getString("proyecto")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar las tareas.");
            e.printStackTrace();
        }
    }

    // =========================
    // UPDATE
    // =========================

    public void actualizarTarea(Tarea tarea) {

        String sql =
                "UPDATE tareas SET "
                + "nombre = ?, "
                + "descripcion = ?, "
                + "estado = ?, "
                + "fecha_limite = ?, "
                + "id_proyecto = ? "
                + "WHERE id_tarea = ?";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setString(1, tarea.getNombre());
            sentencia.setString(2, tarea.getDescripcion());
            sentencia.setString(3, tarea.getEstado());

            if (tarea.getFechaLimite() != null) {
                sentencia.setDate(4,
                        java.sql.Date.valueOf(tarea.getFechaLimite()));
            } else {
                sentencia.setDate(4, null);
            }

            sentencia.setInt(5, tarea.getIdProyecto());
            sentencia.setInt(6, tarea.getIdTarea());

            int filasActualizadas = sentencia.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Tarea actualizada correctamente.");
            } else {
                System.out.println("No se encontró la tarea.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar la tarea.");
            e.printStackTrace();
        }
    }

    // =========================
    // DELETE
    // =========================

    public void eliminarTarea(int idTarea) {

        String sql =
                "DELETE FROM tareas WHERE id_tarea = ?";

        try (Connection conexion =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement sentencia =
                     conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idTarea);

            int filasEliminadas = sentencia.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Tarea eliminada correctamente.");
            } else {
                System.out.println("No se encontró la tarea.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar la tarea.");
            e.printStackTrace();
        }
    }
}
