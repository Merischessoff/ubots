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
@RequestMapping("atendende")
public class AtendenteController {
    
    @Autowired
    SolicitacaoManager solicitacaoManager;
    
    @GetMapping("/{cpf}/{tipo}")
    public ResponseEntity solicitarAtendimento(@PathVariable String cpf, @PathVariable String tipoA) {
        String retorno = "";
        
        return ResponseEntity.ok(retorno);
    } 
}
