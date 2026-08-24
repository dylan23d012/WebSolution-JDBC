package com.websolution; 
 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
public class ClienteDAO { 
 
    private static final String URL = 
            "jdbc:mysql://localhost:3307/websolution?useSSL=false&serverTimezone=UTC"; 
 
    private static final String USER = "root"; 
 
    private static final String PASSWORD = "DYLAN334"; 
 
    public void insertarCliente(Cliente cliente) { 
 
        String sql = "INSERT INTO clientes (nombre, email, telefono, empresa) VALUES (?, ?, ?, ?)"; 
 
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD); 
             PreparedStatement statement = conexion.prepareStatement(sql)) { 
 
            statement.setString(1, cliente.getNombre()); 
            statement.setString(2, cliente.getEmail()); 
            statement.setString(3, cliente.getTelefono()); 
            statement.setString(4, cliente.getEmpresa()); 
 
            statement.executeUpdate(); 
 
            System.out.println("Cliente registrado correctamente."); 
 
        } catch (SQLException e) { 
            System.out.println("Error al registrar el cliente."); 
            e.printStackTrace(); 
        } 
    } 
 
    public void listarClientes() { 
 
        String sql = "SELECT * FROM clientes"; 
 
        try (Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD); 
             PreparedStatement statement = conexion.prepareStatement(sql); 
             ResultSet resultado = statement.executeQuery()) { 
 
            System.out.println("\n===== CLIENTES ====="); 
 
            while (resultado.next()) { 
 
                System.out.println( 
                        resultado.getInt("id_cliente") + " | " + 
                        resultado.getString("nombre") + " | " + 
                        resultado.getString("email") + " | " + 
                        resultado.getString("telefono") + " | " + 
                        resultado.getString("empresa") 
                ); 
            } 
 
        } catch (SQLException e) { 
            System.out.println("Error al consultar los clientes."); 
            e.printStackTrace(); 
        } 
    } 
    public void actualizarCliente(Cliente cliente) {

    String sql = "UPDATE clientes SET nombre = ?, email = ?, telefono = ?, empresa = ? " +
                 "WHERE id_cliente = ?";

    try (Connection conexion =
                 java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement sentencia =
                 conexion.prepareStatement(sql)) {

        sentencia.setString(1, cliente.getNombre());
        sentencia.setString(2, cliente.getEmail());
        sentencia.setString(3, cliente.getTelefono());
        sentencia.setString(4, cliente.getEmpresa());
        sentencia.setInt(5, cliente.getIdCliente());

        int filasActualizadas = sentencia.executeUpdate();

        if (filasActualizadas > 0) {
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("No se encontró el cliente.");
        }

    } catch (SQLException e) {
        System.out.println("Error al actualizar el cliente.");
        e.printStackTrace();
    }
}
public void eliminarCliente(int idCliente) {

    String sql = "DELETE FROM clientes WHERE id_cliente = ?";

    try (Connection conexion =
                 java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement sentencia =
                 conexion.prepareStatement(sql)) {

        sentencia.setInt(1, idCliente);

        int filasEliminadas = sentencia.executeUpdate();

        if (filasEliminadas > 0) {
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No se encontró el cliente.");
        }

    } catch (SQLException e) {
        System.out.println("Error al eliminar el cliente.");
        e.printStackTrace();
    }
}
}
