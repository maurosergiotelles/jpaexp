package org.jpaexp.ecommerce.transacao;

import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.jpaexp.ecommerce.model.Produto;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    @Order(10)
    public void inserirPrimeiroObjeto() {

        Produto produto = new Produto();
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definicao para suas fotos.");
        produto.setPreco(new BigDecimal("5000.99"));


        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(produto);
        transaction.commit();

    }

    @Test
    @Order(11)
    public void alterarObjeto() {

        Produto produto = new Produto();


        produto.setNome("fdsafdsa");
        produto.setDescricao("fdsafda");
        produto.setPreco(new BigDecimal("56.77"));

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(produto);
        transaction.commit();


    }

    @Test
    @Order(12)
    public void atualizarObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class, 1);

        produto.setDescricao("Alterado somente a descrição");

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(produto);

        transaction.commit();
    }

    @Test
    @Order(13)
    public void inserirObjetoComMerge() {
        Produto produto = new Produto();

        produto.setNome("Camera Canon");
        produto.setDescricao("A melhor definicao para suas fotos.");
        produto.setPreco(new BigDecimal("5000.99"));
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(produto);
        transaction.commit();
    }

    @Test
    @Order(20)
    public void removeObjeto() {
        Produto produto = entityManager.find(Produto.class, 2);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.remove(produto);
        transaction.commit();
    }

    @Test
    @Order(30)
    public void objetoNaoExiste() {
        Produto produto = entityManager.find(Produto.class, 2);

        Assertions.assertNull(produto);

    }


    @Test
    @Order(40)
    public void abrirEFecharTransacao() {
        //Produto produto = new Produto();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //entityManager.persist(produto);
        //entityManager.merge(produto);
        //entityManager.remove(produto);

        transaction.commit();
    }
}
