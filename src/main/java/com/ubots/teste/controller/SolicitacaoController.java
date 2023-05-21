package com.ubots.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubots.teste.SolicitacaoManager;
import com.ubots.teste.domain.Solicitacao;

@RestController
@RequestMapping("solicitacao")
public class SolicitacaoController {

    @Autowired
    SolicitacaoManager solicitacaoManager;
    
    @GetMapping("/{cpf}/{tipo}")
    public ResponseEntity<Solicitacao> solicitarAtendimento(@PathVariable String cpf, @PathVariable String tipo) {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setTipo(tipo);
        solicitacao.setDescricao("Cliente com documento " + cpf);
        solicitacao = SolicitacaoManager.verificaDisponibilidade(solicitacao);

        return ResponseEntity.ok(solicitacao);
    } 
}
