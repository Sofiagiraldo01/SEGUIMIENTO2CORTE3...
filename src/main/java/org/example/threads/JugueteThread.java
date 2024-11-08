package org.example.threads;

import org.example.model.Juguete;

public class JugueteThread<T extends Juguete> extends Thread {
    private final T producto;

    public JugueteThread(T producto) {
        this.producto = producto;
    }

    @Override
    public void run() {
        System.out.println("Simulando operación en la tienda con el juguete: " + producto.getNombre());
        try {
            Thread.sleep(2000); // Simulación de tiempo de operación
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Operación completada con el juguete: " + producto.getNombre());
    }
}
