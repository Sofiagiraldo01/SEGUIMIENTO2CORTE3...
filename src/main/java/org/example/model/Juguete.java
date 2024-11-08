package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Juguete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public Juguete() {}

    public Juguete(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Juguete{id=" + id + ", nombre='" + nombre + "'}";
    }
}
