package org.jpaexp.ecommerce.consultandoregistros;

import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.jpaexp.ecommerce.model.Pedido;
import org.jpaexp.ecommerce.model.StatusPedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciamentoTransacoesTest extends EntityManagerTest {

    @Test
    public void abrirFecharCancelarTransacao(){
        Exception exception = assertThrows(Exception.class, () -> errorEsperado());

        Assertions.assertEquals("Pedido ainda não foi pago.", exception.getMessage());
    }

    private static void errorEsperado() {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            metodoDeNegocio();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    private static void metodoDeNegocio() {
        Pedido pedido = entityManager.find(Pedido.class, 1);
        pedido.setStatus(StatusPedido.PAGO);

        if (pedido.getDataConclusao() == null){
            throw new RuntimeException("Pedido ainda não foi pago.");
        }
    }
}