package org.jpaexp.ecommerce.consultandoregistros;


import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.jpaexp.ecommerce.model.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemovePedidoReferenciado extends EntityManagerTest {

    @Test
    public void removePedido(){
        EntityTransaction transaction = entityManager.getTransaction();
        Pedido pedido = entityManager.find(Pedido.class, 1);

        Assertions.assertEquals(1, pedido.getId());




        transaction.begin();
            pedido.getItens().forEach(item -> entityManager.remove(item));


        entityManager.remove(pedido);


        transaction.commit();
    }
}
