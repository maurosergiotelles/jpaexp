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
        Assertions.assertEquals("Produto(id=1, nome=Kindle, preco=499.00, descricao=Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia., categorias=[], estoque=null)", produto.toString());
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