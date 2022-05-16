package com.votacao.demo.api.controller;

import com.votacao.demo.api.model.Resultado;
import com.votacao.demo.domain.model.Pauta;
import com.votacao.demo.repository.PautaRepository;
import com.votacao.demo.service.VotacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/pauta")
public class PautaController {

    private PautaRepository pautaRepository;
    private VotacaoService votacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pauta adicionar(@RequestBody Pauta pauta) {
        return pautaRepository.save(pauta);
    }

    @GetMapping("/{pautaId}/resultado")
    public ResponseEntity<Resultado> getResultado(@PathVariable Long pautaId) {
        return ResponseEntity.ok(votacaoService.getResultadoVotacao(pautaId));
    }

}
