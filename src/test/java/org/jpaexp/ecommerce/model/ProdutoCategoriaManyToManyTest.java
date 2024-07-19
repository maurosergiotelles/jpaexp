package org.jpaexp.ecommerce.model;

import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoCategoriaManyToManyTest extends EntityManagerTest {

    @Test
    public void teste_manyTomany(){
        Produto produto = entityManager.find(Produto.class, 1);
        Categoria categoria = entityManager.find(Categoria.class, 1);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
//        categoria.setProdutos(Arrays.asList(produto));
        produto.setCategorias(Arrays.asList(categoria));
        transaction.commit();
        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, categoria.getId());

        Assertions.assertFalse(categoriaVerificacao.getProdutos().isEmpty());
    }
}