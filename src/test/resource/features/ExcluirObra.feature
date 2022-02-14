#Author: lucas.valentim.costa@gmail.com
@ExcluirObra
Feature: Excluir obra e autores
	
	# @TA = Teste de API
	
	@TA_0001
	Scenario Outline: Excluir obra e autores com sucesso
		Given que eu envio um solicitacao para uma uri valida
		When preencho campos de login
		Then valido login
		When envio uri com o path <id> da obra 
		Then valido mensagem de exclusao
		Examples: 
		| id |
		| 11 |