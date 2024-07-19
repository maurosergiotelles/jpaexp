package org.jpaexp.ecommerce.conhecendoentitymanager;

import org.jpaexp.ecommerce.EntityManagerTest;
import org.jpaexp.ecommerce.model.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultandoRegistrosTest extends EntityManagerTest {
    @Test
    public void verificarCache(){
        Produto produto = entityManager.find(Produto.class, 1);
        System.out.println(produto.getNome());
        System.out.println("----------------");

        entityManager.clear();//limpa o cache de primeiro nível
        Produto produtoResgatado = entityManager.find(Produto.class, produto.getId());//Busca na memória
        System.out.println(produto.getNome());

    }

}