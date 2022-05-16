package com.votacao.demo.repository;

import com.votacao.demo.domain.model.Sessao;
import com.votacao.demo.domain.model.Usuario;
import com.votacao.demo.domain.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    Optional<Voto> findByUsuarioAndSessao(Usuario usuario, Sessao sessao);

    @Query(
            value = "select v.* from voto v "
                    + " join sessao s "
                    + " on v.sessao_id = s.id"
                    + " join pauta p"
                    + " on p.id = s.pauta_id "
                    + " where p.id = :pauta_id "
                    + " and v.voto = :voto ",
            nativeQuery = true)
    List<Voto> findByVotoAndPauta(String voto, Long pauta_id);

}
