package com.fabio.loja_virtual.controller;

import com.fabio.loja_virtual.model.Acesso;
import com.fabio.loja_virtual.repository.AcessoRepository;
import com.fabio.loja_virtual.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @Autowired
    private AcessoRepository acessoRepository;

    @PostMapping(value = "**/salvarAcesso")
    public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) {
        Acesso acessoSalvo = acessoService.save(acesso);
        return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
    }

    @PostMapping(value = "**/deletarAcesso")
    public ResponseEntity<?> deletarAcesso(@RequestBody Acesso acesso) {
        acessoRepository.deleteById(acesso.getId());
        return new ResponseEntity("Removido com sucesso!", HttpStatus.OK);
    }
}
