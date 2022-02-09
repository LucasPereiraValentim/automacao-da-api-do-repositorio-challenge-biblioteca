@obra
Feature: Testar funcionalidade de crud
	
	# @TA = Teste de API
	
	@TA_0002
	Scenario: Cadastro de obra e autor
		Given solicito requisicao
		When preencho campos de login no json
		Then valido login
		When preencho campos de cadastro de obra
		Then valido cadastro
    
    
	@TA_0003
	Scenario: Não deve permitir cadastro de obra duplicada
		Given solicito requisicao
		When preencho campos de login no json
		Then valido login
		When preencho campos de cadastro de obra com titulo já cadastrado
		Then valido mensagem obra duplicada
  
	@TA_0004
	Scenario: Não deve permitir requisição com campos em branco
		Given solicito requisicao
		When preencho campos de login no json
		Then valido login
		When envio requisicao com campos vazios
		Then valido mensagem de campos em branco