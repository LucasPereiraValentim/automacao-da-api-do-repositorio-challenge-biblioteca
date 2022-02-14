#Author: lucas.valentim.costa@gmail.com
@Login
Feature: Login
	
	# @TA = Teste de API
	
  @TA_0001
  Scenario: Validar token no header da resposta
    Given que eu envio um solicitacao para uma uri valida
    When preencho campos de login
   	Then valido token no header
