package org.jpaexp.ecommerce.model;

import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento(){
        EntityTransaction transaction = entityManager.getTransaction();
        Pedido pedido = entityManager.find(Pedido.class, 1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setNumero("1234");
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setPedido(pedido);


        transaction.begin();
        entityManager.persist(pagamentoCartao);
        transaction.commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, 1);

        Assertions.assertNotNull(pedidoVerificacao);
    }

    @Test
    public void testeOneToOneNotaFiscal(){
        EntityTransaction transaction = entityManager.getTransaction();
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setPedido(pedido);
        notaFiscal.setXml("jfdklsajfdksçlfjsa");
        notaFiscal.setDataEmissao(LocalDateTime.now());


        transaction.begin();

        entityManager.persist(notaFiscal);
        transaction.commit();


        entityManager.clear();
        Pedido pedidoVerificacao = entityManager.find(Pedido.class, 1);

        Assertions.assertNotNull(pedidoVerificacao.getNotaFiscal());

    }

}