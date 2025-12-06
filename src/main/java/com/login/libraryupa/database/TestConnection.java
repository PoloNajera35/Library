package com.login.libraryupa.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Clase para probar la conexión a la base de datos bibliotecaupa
 */
public class TestConnection {

    public static void main(String[] args) {
        System.out.println("PRUEBA DE CONEXIÓN A BASE DE DATOS");

        // Probar la conexión
        Connection conn = DatabaseConnection.getConnection();

        if (conn != null) {
            System.out.println("¡Conexión establecida correctamente!\n");

            try {
                // Mostrar información de la base de datos
                System.out.println("INFORMACIÓN DE LA CONEXIÓN:");
                System.out.println("Base de datos: " + conn.getCatalog());
                System.out.println("Usuario: " + conn.getMetaData().getUserName());
                System.out.println("URL: " + conn.getMetaData().getURL());
                System.out.println("Driver: " + conn.getMetaData().getDriverName());
                System.out.println("Versión MySQL: " + conn.getMetaData().getDatabaseProductVersion());

                System.out.println("\nCONSULTANDO TABLAS:");

                // Probar consulta en tabla t_usuarios
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as total FROM t_usuarios");

                if (rs.next()) {
                    int total = rs.getInt("total");
                    System.out.println("Total de usuarios: " + total);
                }

                // Contar libros
                rs = stmt.executeQuery("SELECT COUNT(*) as total FROM t_libros");
                if (rs.next()) {
                    int total = rs.getInt("total");
                    System.out.println("Total de libros: " + total);
                }

                // Contar alumnos
                rs = stmt.executeQuery("SELECT COUNT(*) as total FROM t_alumnos");
                if (rs.next()) {
                    int total = rs.getInt("total");
                    System.out.println("Total de alumnos: " + total);
                }

                rs.close();
                stmt.close();

                System.out.println("\nTODAS LAS PRUEBAS PASARON EXITOSAMENTE");

            } catch (Exception e) {
                System.err.println("\nERROR AL EJECUTAR CONSULTAS:");
                System.err.println("   " + e.getMessage());
                e.printStackTrace();
            }

        } else {
            System.err.println("NO SE PUDO ESTABLECER LA CONEXIÓN");
            System.err.println("\nVERIFICA:");
            System.err.println("   1. XAMPP está corriendo (MySQL iniciado)");
            System.err.println("   2. La base de datos 'bibliotecaupa' existe");
            System.err.println("   3. El usuario 'polo' tiene permisos");
            System.err.println("   4. La contraseña 'root' es correcta");
        }

        // Cerrar la conexión
        DatabaseConnection.closeConnection();
        System.out.println("PRUEBA FINALIZADA");
    }
}