@obra
Feature: Testar funcionalidade de crud
	
	#@TA = Teste de API
	
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
    Then valido mensagem
  