package org.jpaexp.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoManyToOneTest extends EntityManagerTest {

    @Test
    public void testeManyToOne(){
        Cliente cliente = entityManager.find(Cliente.class, 4);

        Pedido pedido = new Pedido();

        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal("1000.99"));
        pedido.setCliente(cliente);

        Produto produto1 = entityManager.find(Produto.class,1);
        Produto produto2 = entityManager.find(Produto.class,2);


        ItemPedido item1 = new ItemPedido();
        item1.setQuantidade(16);
        item1.setProduto(produto1);
        //item1.setPedido(pedido);
        item1.setPrecoProduto(new BigDecimal("569.99"));

        ItemPedido item2 = new ItemPedido();
        item2.setQuantidade(10);
        //item2.setPedido(pedido);
        item2.setProduto(produto2);
        item2.setPrecoProduto(new BigDecimal("1778.44"));



        pedido.addItem(item1);
        pedido.addItem(item2);


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
        entityManager.clear();
        transaction.commit();

        Pedido pedidoPesquisa = entityManager.find(Pedido.class, 1);


        Cliente clienteVerif = entityManager.find(Cliente.class, 4);
        List<Pedido> pedidos = clienteVerif.getPedidos();
        pedidos.forEach(ped -> {
            System.out.println(ped);
        });

    }

}