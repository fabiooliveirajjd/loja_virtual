package com.fabio.loja_virtual;

import com.fabio.loja_virtual.controller.AcessoController;
import com.fabio.loja_virtual.model.Acesso;
import com.fabio.loja_virtual.repository.AcessoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Calendar;
import java.util.List;

@SpringBootTest(classes = LojaVirtualApplication.class)
class LojaVirtualApplicationTests extends TestCase {


    @Autowired
    private AcessoController acessoController;

    @Autowired
    private AcessoRepository acessoRepository;

    @Autowired
    private WebApplicationContext wac;

    /*Teste do end-point de salvar*/
    @Test
    public void testRestApiCadastroAcesso() throws JsonProcessingException, Exception {

        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac); //Configura o contexto da aplicação
        MockMvc mockMvc = builder.build(); //Constrói o objeto MockMvc

        Acesso acesso = new Acesso(); //Instancia um objeto de Acesso

        acesso.setDescricao("ROLE_COMPRADOR" + Calendar.getInstance().getTimeInMillis()); //Seta a descrição do acesso

        ObjectMapper objectMapper = new ObjectMapper(); //Instancia um objeto ObjectMapper

        ResultActions retornoApi = mockMvc  //Chama a API
                .perform(MockMvcRequestBuilders.post("/salvarAcesso") //Chama o end-point de salvar
                        .content(objectMapper.writeValueAsString(acesso)) //Converte o objeto para JSON
                        .accept(MediaType.APPLICATION_JSON) //Aceita JSON
                        .contentType(MediaType.APPLICATION_JSON)); //Define o tipo de conteúdo

        System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString()); //Imprime o retorno da API

        /*Conveter o retorno da API para um obejto de acesso*/

        Acesso objetoRetorno = objectMapper.
                readValue(retornoApi.andReturn().getResponse().getContentAsString(),
                        Acesso.class);

        assertEquals(acesso.getDescricao(), objetoRetorno.getDescricao()); //Valida se a descrição do objeto é igual a descrição do objeto retornado

    }


    @Test
    public void testRestApiDeleteAcesso() throws Exception {

        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac); //Configura o contexto da aplicação
        MockMvc mockMvc = builder.build(); //Constrói o objeto MockMvc

        Acesso acesso = new Acesso(); //Instancia um objeto de Acesso

        acesso.setDescricao("ROLE_TESTE_DELETE"); //Seta a descrição do acesso

        acesso = acessoRepository.save(acesso); //Salva o acesso no banco de dados

        ObjectMapper objectMapper = new ObjectMapper(); //Instancia um objeto ObjectMapper

        ResultActions retornoApi = mockMvc
                .perform(MockMvcRequestBuilders.post("/deleteAcesso") //Chama o end-point de delete
                        .content(objectMapper.writeValueAsString(acesso)) //Converte o objeto para JSON
                        .accept(MediaType.APPLICATION_JSON)  //Aceita JSON
                        .contentType(MediaType.APPLICATION_JSON)); //Define o tipo de conteúdo

        System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString()); //Imprime o retorno da API
        System.out.println("Status de retorno: " + retornoApi.andReturn().getResponse().getStatus()); //Imprime o status de retorno

        assertEquals("Acesso Removido", retornoApi.andReturn().getResponse().getContentAsString()); //Valida se o retorno da API é igual a "Acesso Removido"
        assertEquals(200, retornoApi.andReturn().getResponse().getStatus()); //Valida se o status de retorno é 200


    }


    @Test
    public void testRestApiDeletePorIDAcesso() throws JsonProcessingException, Exception {

        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac); //Configura o contexto da aplicação
        MockMvc mockMvc = builder.build(); //Constrói o objeto MockMvc

        Acesso acesso = new Acesso(); //Instancia um objeto de Acesso

        acesso.setDescricao("ROLE_TESTE_DELETE_ID"); //Seta a descrição do acesso

        acesso = acessoRepository.save(acesso); //Salva o acesso no banco de dados

        ObjectMapper objectMapper = new ObjectMapper(); //Instancia um objeto ObjectMapper

        ResultActions retornoApi = mockMvc //Chama a API
                .perform(MockMvcRequestBuilders.delete("/deleteAcessoPorId/" + acesso.getId()) //Chama o end-point de delete por ID
                        .content(objectMapper.writeValueAsString(acesso)) //Converte o objeto para JSON
                        .accept(MediaType.APPLICATION_JSON) //Aceita JSON
                        .contentType(MediaType.APPLICATION_JSON)); //Define o tipo de conteúdo

        System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString()); //Imprime o retorno da API
        System.out.println("Status de retorno: " + retornoApi.andReturn().getResponse().getStatus()); //Imprime o status de retorno

        assertEquals("Acesso Removido", retornoApi.andReturn().getResponse().getContentAsString()); //Valida se o retorno da API é igual a "Acesso Removido"
        assertEquals(200, retornoApi.andReturn().getResponse().getStatus()); //Valida se o status de retorno é 200


    }


    @Test
    public void testRestApiObterAcessoID() throws JsonProcessingException, Exception {

        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac); //Configura o contexto da aplicação
        MockMvc mockMvc = builder.build(); //Constrói o objeto MockMvc

        Acesso acesso = new Acesso(); //Instancia um objeto de Acesso

        acesso.setDescricao("ROLE_OBTER_ID"); //Seta a descrição do acesso

        acesso = acessoRepository.save(acesso); //Salva o acesso no banco de dados

        ObjectMapper objectMapper = new ObjectMapper(); //Instancia um objeto ObjectMapper

        ResultActions retornoApi = mockMvc //Chama a API
                .perform(MockMvcRequestBuilders.get("/obterAcesso/" + acesso.getId()) //Chama o end-point de obter por ID
                        .content(objectMapper.writeValueAsString(acesso)) //Converte o objeto para JSON
                        .accept(MediaType.APPLICATION_JSON) //Aceita JSON
                        .contentType(MediaType.APPLICATION_JSON)); //Define o tipo de conteúdo

        assertEquals(200, retornoApi.andReturn().getResponse().getStatus()); //Valida se o status de retorno é 200


        Acesso acessoRetorno = objectMapper.readValue(retornoApi.andReturn().getResponse().getContentAsString(), Acesso.class); //Converte o retorno da API para um objeto de Acesso

        assertEquals(acesso.getDescricao(), acessoRetorno.getDescricao()); //Valida se a descrição do objeto é igual a descrição do objeto retornado

        assertEquals(acesso.getId(), acessoRetorno.getId()); //Valida se o ID do objeto é igual ao ID do objeto retornado

    }


    @Test
    public void testRestApiObterAcessoDesc() throws JsonProcessingException, Exception {

        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac); //Configura o contexto da aplicação
        MockMvc mockMvc = builder.build();  //Constrói o objeto MockMvc

        Acesso acesso = new Acesso(); //Instancia um objeto de Acesso

        acesso.setDescricao("ROLE_TESTE_OBTER_LIST"); //Seta a descrição do acesso

        acesso = acessoRepository.save(acesso); //Salva o acesso no banco de dados

        ObjectMapper objectMapper = new ObjectMapper(); //Instancia um objeto ObjectMapper

        ResultActions retornoApi = mockMvc //Chama a API
                .perform(MockMvcRequestBuilders.get("/buscarPorDesc/OBTER_LIST") //Chama o end-point de obter por descrição
                        .content(objectMapper.writeValueAsString(acesso)) //Converte o objeto para JSON
                        .accept(MediaType.APPLICATION_JSON) //Aceita JSON
                        .contentType(MediaType.APPLICATION_JSON)); //Define o tipo de conteúdo

        assertEquals(200, retornoApi.andReturn().getResponse().getStatus()); //Valida se o status de retorno é 200


        List<Acesso> retornoApiList = objectMapper. //Converte o retorno da API para uma lista de Acesso
                readValue(retornoApi.andReturn() //Retorno da API
                        .getResponse().getContentAsString(), //Conteúdo do retorno
                new TypeReference<List<Acesso>>() { //Tipo de retorno
                });

        assertEquals(1, retornoApiList.size()); //Valida se a lista de retorno tem tamanho 1

        assertEquals(acesso.getDescricao(), retornoApiList.get(0).getDescricao()); //Valida se a descrição do objeto é igual a descrição do objeto retornado


        acessoRepository.deleteById(acesso.getId()); //Deleta o acesso do banco de dados

    }


    @Test
    public void testCadastraAcesso() {

        String descacesso = "ROLE_ADMIN" + Calendar.getInstance().getTimeInMillis(); //Gera uma descrição de acesso

        Acesso acesso = new Acesso(); //Instancia um objeto de Acesso

        acesso.setDescricao(descacesso); //Seta a descrição do acesso

        assertEquals(true, acesso.getId() == null); //Valida se o ID do objeto é nulo

        /*Gravou no banco de dados*/
        acesso = acessoController.salvarAcesso(acesso).getBody(); //Salva o acesso no banco de dados

        assertEquals(true, acesso.getId() > 0); //Valida se o ID do objeto é maior que 0

        /*Validar dados salvos da forma correta*/
        assertEquals(descacesso, acesso.getDescricao()); //Valida se a descrição do objeto é igual a descrição gerada

        /*Teste de carregamento*/

        Acesso acesso2 = acessoRepository.findById(acesso.getId()).get(); //Carrega o acesso do banco de dados

        assertEquals(acesso.getId(), acesso2.getId()); //Valida se o ID do objeto é igual ao ID do objeto carregado


        /*Teste de delete*/

        acessoRepository.deleteById(acesso2.getId()); //Deleta o acesso do banco de dados

        acessoRepository.flush(); /*Roda esse SQL de delete no banco de dados*/

        Acesso acesso3 = acessoRepository.findById(acesso2.getId()).orElse(null); //Carrega o acesso do banco de dados

        assertEquals(true, acesso3 == null); // Validar se o objeto é nulo


        /*Teste de query*/

        acesso = new Acesso(); //Instancia um objeto de Acesso

        acesso.setDescricao("ROLE_ALUNO"); //Seta a descrição do acesso

        acesso = acessoController.salvarAcesso(acesso).getBody(); //Salva o acesso no banco de dados

        List<Acesso> acessos = acessoRepository.buscarPorDescricao("ALUNO".trim().toUpperCase()); //Faz a consulta no banco de dados com a query buscarPorDescricao

        assertEquals(1, acessos.size()); //Valida se a lista de retorno tem tamanho 1

        acessoRepository.deleteById(acesso.getId()); //Deleta o acesso do banco de dados

    }
}