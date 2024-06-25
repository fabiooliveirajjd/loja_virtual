-- Trigger para validar a chave estrangeira pessoa_id na tabela avaliacao_produto
-- A trigger valida se o id da pessoa existe nas tabelas pessoa_fisica ou pessoa_juridica
create or replace function  validaChavePessoa() -- nome da função
	returns trigger  -- tipo de retorno
	language plpgsql -- linguagem
	as  $$ -- delimitador de bloco
	declare existe integer; -- variável para armazenar o resultado da consulta

begin -- bloco de código
	existe = (select count (1) from pessoa_fisica where id = NEW.pessoa_id); -- consulta para verificar se o id existe na tabela pessoa_fisica
	IF(existe <=0) then  -- se for menor ou igual a zero, então não existe
	 existe = (select count(1) from pessoa_juridica where id = NEW.pessoa_id); -- consulta para verificar se o id existe na tabela pessoa_juridica
	IF(existe <=0) then -- se for menor ou igual a zero, então não existe
		raise exception 'Não foi encontrado o ID ou PK da pessoa para realizar a associação!'; -- exceção para informar que não foi encontrado o id
end if; -- fim do if
end if; -- fim do if
end; -- fim do bloco de código
$$ -- fim do delimitador de bloco

create trigger validaChavePessoaAvaliacaoProduto -- nome da trigger
before insert -- tipo de trigger
on avaliacao_produto -- tabela que a trigger será associada
for each row -- para cada linha
execute procedure validaChavePessoa(); -- executa a função validaChavePessoa