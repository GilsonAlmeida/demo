package com.votacao.demo.repository;

import com.votacao.demo.domain.model.Pauta;
import com.votacao.demo.domain.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao,Long> {

}
