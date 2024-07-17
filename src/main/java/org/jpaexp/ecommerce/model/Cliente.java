package org.jpaexp.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    private Integer id;

    private String nome;

    @Enumerated
    private SexoCliente sexo;

}
