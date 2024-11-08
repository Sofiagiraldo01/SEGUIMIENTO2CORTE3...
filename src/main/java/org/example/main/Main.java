package org.example.main;

import org.example.dao.JugueteDAO;
import org.example.model.Juguete;
import org.example.threads.JugueteThread;

import java.util.Scanner;

public class Main {
    private static JugueteDAO productoDAO = new JugueteDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== TIENDA SIMULACIÓN ===");
            System.out.println("1. Iniciar simulación");
            System.out.println("2. Ver productos guardados");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> iniciarSimulacion();
                case 2 -> verProductosGuardados();
                case 3 -> {
                    System.out.println("Saliendo de la simulación...");
                    exit = true;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    private static void iniciarSimulacion() {
        // Usando generics con la clase TiendaThread
        JugueteThread<Juguete> hiloProducto = new JugueteThread<>(new Juguete("Producto Genérico"));
        hiloProducto.start();
        productoDAO.guardar(new Juguete("Producto de ejemplo"));
    }

    private static void verProductosGuardados() {
        productoDAO.obtenerProductos().forEach(System.out::println);
    }
}
