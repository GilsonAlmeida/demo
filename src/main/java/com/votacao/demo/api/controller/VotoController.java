package com.votacao.demo.api.controller;

import com.votacao.demo.domain.model.Voto;
import com.votacao.demo.service.VotacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/voto")
public class VotoController {

    public VotacaoService votacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Voto adicionar(@RequestBody Voto voto) {
        return votacaoService.salvar(voto);
    }

}
