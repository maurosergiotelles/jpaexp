package org.jpaexp.ecommerce.model;

import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest extends EntityManagerTest {

    @Test
    public void test_Cliente(){
        EntityTransaction transaction = entityManager.getTransaction();
        Cliente cliente = new Cliente();


        cliente.setNome("Joana");
        cliente.setSexo(SexoCliente.FEMININO);


        transaction.begin();

        entityManager.persist(cliente);

        transaction.commit();
    }
}