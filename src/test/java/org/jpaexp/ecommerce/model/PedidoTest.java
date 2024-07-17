package org.jpaexp.ecommerce.model;

import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest extends EntityManagerTest {

    @Test
    public void teste_endereco(){


        Pedido pedido = new Pedido();

        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal("1000.99"));

        Endereco endereco  = new Endereco();
        endereco.setLogradouro("Avenida Paulista");
        endereco.setNumero("1500");
        endereco.setComplemento("14º - conjunto 32");
        endereco.setBairro("Jardins");
        endereco.setCidade("São Paulo");
        endereco.setUf("SP");
        endereco.setCep("04044001");
        pedido.setEndereco(endereco);


        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(pedido);
        transaction.commit();

    }

}