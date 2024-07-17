package org.jpaexp.ecommerce.model;

import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaTest extends EntityManagerTest {

    @Test
    @Order(1)
    public void test_estrategia_chave_primaria() {

        Categoria categoria = new Categoria();

        categoria.setNome("Celular");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(categoria);
        entityManager.clear();
        transaction.commit();



    }

    @Test
    @Order(2)
    public void test_consulta(){
        Categoria categoria = entityManager.find(Categoria.class, 1);
        Assertions.assertEquals(1, categoria.getId());

    }

}