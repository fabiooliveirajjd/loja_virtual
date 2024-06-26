package com.fabio.loja_virtual.controller;

import com.fabio.loja_virtual.model.Acesso;
import com.fabio.loja_virtual.repository.AcessoRepository;
import com.fabio.loja_virtual.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "**/deleteAcesso") /*Mapeando a url para receber JSON*/
    public ResponseEntity<String> deleteAcesso(@RequestBody Acesso acesso) { /*Recebe o JSON e converte pra Objeto*/
        acessoRepository.deleteById(acesso.getId());
        return new ResponseEntity<String>("Acesso Removido", HttpStatus.OK);
    }

    @DeleteMapping(value = "**/deleteAcessoPorId/{id}")
    public ResponseEntity<String> deleteAcessoPorId(@PathVariable("id") Long id) {
        acessoRepository.deleteById(id);
        return new ResponseEntity<String>("Acesso Removido", HttpStatus.OK);
    }

    @GetMapping(value = "**/obterAcesso/{id}")
    public ResponseEntity<Acesso> obterAcessoPorId(@PathVariable("id") Long id) {
        Acesso acesso = acessoRepository.findById(id).get();
        return new ResponseEntity<>(acesso, HttpStatus.OK);
    }

    @GetMapping(value = "**/buscarPorDesc/{desc}")
    public ResponseEntity<List<Acesso>> buscarPorDesc(@PathVariable("desc") String desc) {

        List<Acesso> acesso = acessoRepository.buscarPorDescricao(desc.toUpperCase());

        return new ResponseEntity<List<Acesso>>(acesso, HttpStatus.OK);
    }
}
