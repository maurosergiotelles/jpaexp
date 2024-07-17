package org.jpaexp.ecommerce.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
}
