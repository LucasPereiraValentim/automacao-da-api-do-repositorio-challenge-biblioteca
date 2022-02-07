@tag
Feature: Testar funcionalidade de crud

  @0001
  Scenario: cadastro de obra e autor
    Given envio solicitação uri base
    When preencho atributos json
    Then valido retorno json
  