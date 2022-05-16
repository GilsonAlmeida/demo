package com.votacao.demo.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sessao {

    public static final String SESSAO_SEQ = "SESSAO_SEQ";

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SESSAO_SEQ)
    @SequenceGenerator(allocationSize = 1, name = SESSAO_SEQ, sequenceName = SESSAO_SEQ)
    private Long id;

    private Long tempo;

    private LocalDateTime abertura;

    @ManyToOne
    private Pauta pauta;

}
