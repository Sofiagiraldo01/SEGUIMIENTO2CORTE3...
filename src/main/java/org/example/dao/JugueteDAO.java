package org.example.dao;

import org.example.model.Juguete;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JugueteDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("TiendaPU");

    public void guardar(Juguete producto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
    }

    public List<Juguete> obtenerProductos() {
        EntityManager em = emf.createEntityManager();
        List<Juguete> productos = em.createQuery("SELECT p FROM Producto p", Juguete.class).getResultList();
        em.close();
        return productos;
    }
}
