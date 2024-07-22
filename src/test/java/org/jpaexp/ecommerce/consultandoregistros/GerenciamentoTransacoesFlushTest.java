package org.jpaexp.ecommerce.consultandoregistros;

import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.jpaexp.ecommerce.model.Pedido;
import org.jpaexp.ecommerce.model.StatusPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

 public class GerenciamentoTransacoesFlushTest extends EntityManagerTest {

    @Test
    public void abrirFecharCancelarTransacao(){
        Assertions.assertThrows(Exception.class,  ()-> erroAoChamarFlush());


    }

    private static void erroAoChamarFlush() {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            Pedido pedido = entityManager.find(Pedido.class, 1);
            pedido.setStatus(StatusPedido.PAGO);

            entityManager.flush();// força para o banco sem transação

            if (pedido.getPagamentoCartao() == null){
                throw new RuntimeException("Pedido ainda não foi pago.");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
}