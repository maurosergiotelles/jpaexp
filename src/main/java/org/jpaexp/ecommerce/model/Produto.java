package org.jpaexp.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
}
