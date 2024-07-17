package org.jpaexp.ecommerce.model;

public enum SexoCliente {
    MASCULINO("M"),    FEMININO("F");


    private final String sexoCliente;

    SexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    public String getSexoCliente() {
        return this.sexoCliente;
    }
}
