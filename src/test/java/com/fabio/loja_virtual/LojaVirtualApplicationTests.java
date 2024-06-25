package com.fabio.loja_virtual;

import com.fabio.loja_virtual.controller.AcessoController;
import com.fabio.loja_virtual.model.Acesso;
import com.fabio.loja_virtual.repository.AcessoRepository;
import com.fabio.loja_virtual.service.AcessoService;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = LojaVirtualApplication.class)
public class LojaVirtualApplicationTests extends TestCase {

	@Autowired
	private AcessoService acessoService;

	@Autowired
	AcessoRepository acessoRepository;

	@Autowired
	private AcessoController acessoController;

	@Test
	public void testeCadastraAcesso() {
		Acesso acesso = new Acesso();

		acesso.setDescricao("ROLE_ADMIN");
		acessoController.salvarAcesso(acesso).getBody();


	}

}
