package org.jpaexp.ecommerce.model;

import jakarta.persistence.EntityTransaction;
import org.jpaexp.ecommerce.EntityManagerTest;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CategoriaTest extends EntityManagerTest {

    @Test
    @Order(1)
    public void test_estrategia_chave_primaria() {

        Categoria categoria = new Categoria();

        categoria.setNome("Celular");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(categoria);
        entityManager.clear();
        transaction.commit();
   }

    @Test
    @Order(2)
    public void test_consulta(){
        Categoria categoria = entityManager.find(Categoria.class, 1);
        Assertions.assertEquals(1, categoria.getId());
    }

    @Test
    @Order(3)
    public void test_autorelacionamento(){
        EntityTransaction transaction = entityManager.getTransaction();
        Categoria categoriaPaiEletronicos = new Categoria();


//        categoriaPaiEletronicos.setId(1);
        categoriaPaiEletronicos.setNome("Eletronicos");
        Categoria categoriaCelular = new Categoria();
        categoriaCelular.setNome("Celulares");
        categoriaPaiEletronicos.setCategoriaFilha(categoriaCelular);


        Categoria categoriaPaiMoveis = new Categoria();
//        categoriaPaiMoveis.setId(2);
        categoriaPaiMoveis.setNome("Sofás");

        Categoria categoriaSofaDeMadeira = new Categoria();
        categoriaSofaDeMadeira.setNome("Sofá de madeira");
        categoriaPaiMoveis.setCategoriaFilha(categoriaSofaDeMadeira);

        transaction.begin();
        entityManager.persist(categoriaPaiMoveis);
        entityManager.persist(categoriaPaiEletronicos);

        transaction.commit();
    }

}