package com.votacao.demo.service;

import com.votacao.demo.api.model.Resultado;
import com.votacao.demo.domain.exception.NegocioException;
import com.votacao.demo.domain.model.Pauta;
import com.votacao.demo.domain.model.Voto;
import com.votacao.demo.repository.PautaRepository;
import com.votacao.demo.repository.VotoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VotacaoService {

    private VotoRepository votoRepository;
    private SessaoVotacaoService sessaoVotacaoService;

    private PautaRepository pautaRepository;

    @Transactional
    public Voto salvar(Voto voto) {
        if (!sessaoVotacaoService.isSessaoValid(voto.getSessao().getId())) {
            throw new NegocioException("Sessão inválida");
        }
        if (isUsuarioJaVotou(voto)) {
            throw new NegocioException("Usuário já participou da votação");
        }
        return votoRepository.save(voto);
    }

    public boolean isUsuarioJaVotou(Voto voto) {
        return votoRepository.findByUsuarioAndSessao(voto.getUsuario(), voto.getSessao()).isPresent();
    }

    public Resultado getResultadoVotacao(Long pautaId) {
        var resultado = new Resultado();
        Optional<Pauta> pauta = pautaRepository.findById(pautaId);
        pauta.ifPresentOrElse(
                (p) -> {
                    List<Voto> votosSim = votoRepository.findByVotoAndPauta("SIM", pauta.get().getId());
                    List<Voto> votosNao = votoRepository.findByVotoAndPauta("NAO", pauta.get().getId());
                    resultado.setQtdeResultadoNao(votosNao.size());
                    resultado.setQtdeResultadoSim(votosSim.size());
                },
                () -> {
                    throw new NegocioException("Nenhuma pauta encontrada!");
                }

        );

        return resultado;
    }

}
