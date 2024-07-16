package org.jpaexp.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.jpaexp.ecommerce.model.Produto;

public class IniciarUnidadeDePersistencia {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Produto produto = entityManager.find(Produto.class, 1);

        System.out.println(produto);

        entityManager.close();
        entityManagerFactory.close();

    }
}
