package org.jpaexp.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@ToString
public class Produto {

    @Id
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
}
