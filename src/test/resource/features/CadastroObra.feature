#Author: lucas.valentim.costa@gmail.com
@CadastroObra
Feature: Cadastro de obra e autores
	
	# @TA = Teste de API
	
	@TA_0001
	Scenario: Cadastro de obra e autor
		Given que eu envio um solicitacao para uma uri valida
		When preencho campos de login
		Then valido login
		When preencho campos de cadastro de obra
		Then valido cadastro
    
    
	@TA_0002
	Scenario: Não deve permitir cadastro de titulo duplicada
		Given que eu envio um solicitacao para uma uri valida
		When preencho campos de login
		Then valido login
		When preencho campos de cadastro de obra com titulo já cadastrado
		Then valido mensagem obra duplicada
  
	@TA_0003
	Scenario: Não deve permitir requisicao com campos em branco
		Given que eu envio um solicitacao para uma uri valida
		When preencho campos de login
		Then valido login
		When envio requisicao com campos vazios
		Then valido mensagem de campos em branco