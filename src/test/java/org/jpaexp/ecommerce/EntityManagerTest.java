package org.jpaexp.ecommerce;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public abstract class EntityManagerTest {
    private static EntityManagerFactory entityManagerFactory;

    protected static EntityManager entityManager;

    @BeforeAll
    protected static void setUpBeforeClass(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterAll
    public static void tearDownAfterClass(){
        entityManager.close();
        entityManagerFactory.close();
    }

    @BeforeAll
    public static void setUp(){
        entityManager = entityManagerFactory.createEntityManager();
    }


    @AfterAll
    public static void tearDown(){
        entityManager.close();
    }


}