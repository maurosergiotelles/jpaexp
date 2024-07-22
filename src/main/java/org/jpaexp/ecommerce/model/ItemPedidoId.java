package org.jpaexp.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"pedidoId","produtoId"})
public class ItemPedidoId implements Serializable {
    private Integer pedidoId;

    private Integer produtoId;
}
