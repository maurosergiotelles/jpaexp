package org.jpaexp.ecommerce.model;

import org.jpaexp.ecommerce.EntityManagerTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EagerAndLazyTest extends EntityManagerTest {
    @Test
    public void verificarComportamento(){
        Pedido pedido = entityManager.find(Pedido.class, 1);

//        pedido.getItens().isEmpty();
    }

}