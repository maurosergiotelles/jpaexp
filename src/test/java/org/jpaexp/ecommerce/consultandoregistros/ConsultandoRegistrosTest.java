package org.jpaexp.ecommerce.consultandoregistros;

import org.jpaexp.ecommerce.EntityManagerTest;
import org.jpaexp.ecommerce.model.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsultandoRegistrosTest extends EntityManagerTest {
    @Test
    public void buscarPorIdentificador(){
        Produto produto = entityManager.find(Produto.class, 1);
        Assertions.assertNotNull(produto);

        Assertions.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void buscarPorReferencia(){
        Produto produto = entityManager.getReference(Produto.class, 1);

        Assertions.assertEquals("Kindle", produto.getNome());
    }

    @Test
    public void atualizarReferencia(){
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setNome("Microfone Samson");

        entityManager.refresh(produto);

        Assertions.assertEquals("Kindle", produto.getNome());
    }
}