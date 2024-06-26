package com.fabio.loja_virtual;

import com.fabio.loja_virtual.controller.AcessoController;
import com.fabio.loja_virtual.model.Acesso;
import com.fabio.loja_virtual.repository.AcessoRepository;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = LojaVirtualApplication.class)
class LojaVirtualApplicationTests extends TestCase {

    @Autowired
    private AcessoRepository acessoRepository;
    @Autowired
    private AcessoController acessoController;

    @Test
    public void testeCadastraAcesso() {

        Acesso acesso = new Acesso();

        acesso.setDescricao("ROLE_ADMIN");

        assertEquals(true, acesso.getId() == null); // Verifica se o id é nulo

        acesso = acessoController.salvarAcesso(acesso).getBody(); // Grava no banco

        assertEquals(true, acesso.getId() > 0); // Verifica se o id foi gerado

        assertEquals("ROLE_ADMIN", acesso.getDescricao()); // Verifica se a descrição foi gravada corretamente

        //teste de carreramento

        Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();

        assertEquals(acesso.getId(), acesso2.getId());

        //teste de deleção
        acessoRepository.deleteById(acesso.getId());

        acessoRepository.flush(); // Roda o delete no banco

        Acesso acesso3 = acessoRepository.findById(acesso2.getId()).orElse(null); // Tenta carregar o registro

        assertEquals(true, acesso3 == null); // Verifica se o registro foi excluído

        //TESTE DE QUERY
        acesso = new Acesso();
        acesso.setDescricao("ROLE_ALUNO");
        acesso = acessoController.salvarAcesso(acesso).getBody();
        List<Acesso> acessos = acessoRepository.buscarPorDescricao("ALUNO".trim().toUpperCase());

        assertEquals(1, acessos.size());

        acessoRepository.deleteById(acesso.getId());
    }


}
