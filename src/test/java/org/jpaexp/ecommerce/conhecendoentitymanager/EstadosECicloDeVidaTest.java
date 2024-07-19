package org.jpaexp.ecommerce.conhecendoentitymanager;

import org.jpaexp.ecommerce.EntityManagerTest;
import org.jpaexp.ecommerce.model.Categoria;
import org.jpaexp.ecommerce.model.Cliente;
import org.jpaexp.ecommerce.model.ClienteTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstadosECicloDeVidaTest extends EntityManagerTest {

    @Test
    public void analisarEstados(){
        Categoria categoriaNovo = new Categoria();//Estado TRANSIENTE
        Categoria categoriaGerenciadaMerge = entityManager.merge(categoriaNovo);//Estado GERENCIADA somente o categoriaGerenciadaMerge

        Cliente clienteGerenciada = entityManager.find(Cliente.class, 1);//Estado GERENCIADO

        entityManager.remove(clienteGerenciada); // Estado REMOVED

        entityManager.persist(clienteGerenciada);//Estado GERENCIADO

entityManager.detach(clienteGerenciada);// Estado DESANEXADA







    }
}