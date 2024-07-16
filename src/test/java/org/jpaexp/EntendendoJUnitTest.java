package org.jpaexp;


import org.junit.jupiter.api.*;

public class EntendendoJUnitTest {

    @BeforeEach
    public void iniciarAntesDeCada(){
        System.out.println("antes de cada - BeforeEach");
    }

    @BeforeAll
    public static void iniciarTestes(){
        System.out.println("antes de todos - BeforeAll");
    }

    @AfterAll
    public static void terminarTestes(){
        System.out.println("depois de todos");
    }

    @AfterEach
    public void terminarAntesDeCada(){
        System.out.println("depois de cada - AfterEach");

        Assertions.assertEquals("mauro", "mauro");
    }

    @Test
    public void testandoAlgo(){

        String teste = "test";
        Assertions.assertEquals("test", teste);
    }

    @Test
    public void testandoAlgo2(){

        String teste = "test2";
        Assertions.assertEquals("test2", teste);
    }
}
