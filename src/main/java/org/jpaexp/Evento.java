package org.jpaexp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class Evento {

    private Integer id;
    private String nome;
    private Date data;

}
