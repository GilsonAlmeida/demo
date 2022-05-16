package com.votacao.demo.service;

import com.votacao.demo.domain.model.Sessao;
import com.votacao.demo.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class SessaoVotacaoService {

    public static final long MINUTES_DEFAULT = 1L;
    @Autowired
    private SessaoRepository repositorySessao;

    @Transactional
    public Sessao salvar(Sessao sessao) {
        sessao.setAbertura(LocalDateTime.now());
        return repositorySessao.save(sessao);
    }

    public boolean isSessaoValid(Long idSessao) {
        Sessao sessao = repositorySessao.findById(idSessao).get();
        LocalDateTime tempoSessao;
        if (Objects.nonNull(sessao.getTempo())) {
            tempoSessao = sessao.getAbertura().plusMinutes(sessao.getTempo());
        } else {
            tempoSessao = sessao.getAbertura().plusMinutes(MINUTES_DEFAULT);
        }
        if (tempoSessao.compareTo(LocalDateTime.now()) < 0) {
            return false;
        }
        return true;
    }
}
