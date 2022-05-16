package com.votacao.demo.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pauta {

    public static final String PAUTA_SEQ = "PAUTA_SEQ";

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PAUTA_SEQ)
    @SequenceGenerator(allocationSize = 1, name = PAUTA_SEQ, sequenceName = PAUTA_SEQ)
    private Long id;

    private String descricao;

}
