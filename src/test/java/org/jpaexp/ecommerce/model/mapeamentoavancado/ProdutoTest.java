package org.jpaexp.ecommerce.model.mapeamentoavancado;

import jakarta.persistence.EntityTransaction;
import net.bytebuddy.asm.Advice;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.jpaexp.ecommerce.model.Produto;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProdutoTest extends EntityManagerTest {

    @Test
    @Order(1)
    public void impedirInsercaoDaColunaAtualizacao(){
        Produto produto = new Produto();
        produto.setNome("Teclado para smartiphone");
        produto.setDescricao("O mais confortável");
        produto.setPreco(BigDecimal.ONE);
        produto.setDataCriacao(LocalDateTime.now());
        produto.setDataUltimaAtualizacao(LocalDateTime.now());

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(produto);
        transaction.commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assertions.assertNotNull(produtoVerificacao.getDataCriacao());
        Assertions.assertNull(produtoVerificacao.getDataUltimaAtualizacao());
    }

    @Test
    @Order(2)
    public void impedirAtualizacaoDaColunaCriacao(){
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        Produto produto = entityManager.find(Produto.class, 1);
        produto.setPreco(BigDecimal.TEN);
        produto.setDataCriacao(LocalDateTime.now());
        produto.setDataUltimaAtualizacao(LocalDateTime.now());
        transaction.commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assertions.assertNotEquals(produto.getDataCriacao().truncatedTo(ChronoUnit.SECONDS), produtoVerificacao.getDataCriacao().truncatedTo(ChronoUnit.SECONDS));
        Assertions.assertEquals(produto.getDataUltimaAtualizacao().truncatedTo(ChronoUnit.SECONDS), produtoVerificacao.getDataUltimaAtualizacao().truncatedTo(ChronoUnit.SECONDS));
    }
}