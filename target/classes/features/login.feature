#Author: lucas.valentim.costa@gmail.com
@login
Feature: login
	
	#@TA = Teste de API
	
  @TA_0001
  Scenario: Validar retorno de token ao realizar login
    Given solicito requisicao
    When preencho campos de login no json
   	Then valido retorno token
