package br.com.lucas.testeapi.steps.login;

import br.com.lucas.testeapi.logic.LoginLogic;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
	
	private LoginLogic loginLogic;
	
	@Before
	public void setup() {
		this.loginLogic = new LoginLogic();
	}
	
	@After
	public void before(Scenario scenario) {
		
	}
	
	@Given("que eu envio um solicitacao para uma uri valida")
	public void envio_solicitação_uri_base() {
		this.loginLogic.solicitoRequisicao();
	}
	
	@When("preencho campos de login")
	public void preencho_atributos_json() {
		this.loginLogic.preenchoCamposDeLoginNoJson();
	}
	
	@Then("valido token no header")
	public void valido_retorno_token() {
		this.loginLogic.validoRetornoToken();
	}
	
}
