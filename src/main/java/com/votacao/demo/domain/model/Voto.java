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

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Voto {

    public static final String VOTO_SEQ = "VOTO_SEQ";

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = VOTO_SEQ)
    @SequenceGenerator(allocationSize = 1, name = VOTO_SEQ, sequenceName = VOTO_SEQ)
    private Long id;

    private String voto;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Sessao sessao;

}
