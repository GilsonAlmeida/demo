package com.votacao.demo.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    public static final String USUARIO_SEQ = "USUARIO_SEQ";

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USUARIO_SEQ)
    @SequenceGenerator(allocationSize = 1, name = USUARIO_SEQ, sequenceName = USUARIO_SEQ)
    private Long id;

    private String login;

    private String senha;

    private boolean ativo;
}
