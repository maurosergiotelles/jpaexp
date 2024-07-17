package org.jpaexp.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    private Integer id;

    @Column(name = "produto_id")
    private Integer produtoId;

    private Integer quantidade;


}
