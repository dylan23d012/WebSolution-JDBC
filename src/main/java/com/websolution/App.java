package com.websolution;

public class App {

    public static void main(String[] args) {

        // =====================================================
        // CRUD DE SERVICIOS
        // =====================================================

        ServicioDAO servicioDAO = new ServicioDAO();

        // =====================================================
        // CREATE - INSERTAR SERVICIO
        // =====================================================

        Servicio servicioPrueba = new Servicio();

        servicioPrueba.setNombre("Servicio CRUD Prueba");
        servicioPrueba.setDescripcion(
                "Servicio creado para probar el CRUD completo"
        );
        servicioPrueba.setPrecio(500000);

        servicioDAO.insertarServicio(servicioPrueba);

        // =====================================================
        // READ - CONSULTAR SERVICIOS
        // =====================================================

        System.out.println();
        System.out.println("===== SERVICIOS DESPUÉS DE CREAR =====");

        servicioDAO.listarServicios();

        // =====================================================
        // UPDATE - ACTUALIZAR SERVICIO
        // =====================================================

        Servicio servicioActualizado = new Servicio();

        servicioActualizado.setIdServicio(3);
        servicioActualizado.setNombre("Servicio CRUD Actualizado");
        servicioActualizado.setDescripcion(
                "Servicio modificado mediante UPDATE"
        );
        servicioActualizado.setPrecio(750000);

        servicioDAO.actualizarServicio(servicioActualizado);

        // =====================================================
        // READ - CONSULTAR DESPUÉS DE ACTUALIZAR
        // =====================================================

        System.out.println();
        System.out.println("===== SERVICIOS DESPUÉS DE ACTUALIZAR =====");

        servicioDAO.listarServicios();

        // =====================================================
        // DELETE - ELIMINAR SERVICIO
        // =====================================================

        servicioDAO.eliminarServicio(3);

        // =====================================================
        // READ - CONSULTAR DESPUÉS DE ELIMINAR
        // =====================================================

        System.out.println();
        System.out.println("===== SERVICIOS DESPUÉS DE ELIMINAR =====");

        servicioDAO.listarServicios();
    }
}

