package org.jpaexp.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Cliente {

    @Id
    private Integer id;

    private String nome;
}
