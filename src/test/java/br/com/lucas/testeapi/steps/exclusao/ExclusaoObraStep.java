package br.com.lucas.testeapi.steps.exclusao;

import br.com.lucas.testeapi.logic.ExcluirObraLogic;
import br.com.lucas.testeapi.logic.LoginLogic;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExclusaoObraStep {
	
	
	private LoginLogic loginLogic;
	
	private ExcluirObraLogic excluirObraLogic;
	
	@Before
	public void setup() {
		this.loginLogic = new LoginLogic();
		this.excluirObraLogic = new ExcluirObraLogic();
	}
	
	
	@Given("que eu envio um solicitacao para uma uri valida")
	public void envio_solicitação_uri_base() {
		this.loginLogic.solicitoRequisicao();
	}

	@When("preencho campos de login")
	public void preencho_atributos_json() {
		this.loginLogic.preenchoCamposDeLoginNoJson();
	}
	
	
	@Then("valido login")
	public void valido_login() {
		this.loginLogic.validoRetornoToken();
	}
	
	@When("envio uri com o path {int} da obra")
	public void envio_uri_delete(Integer id) {
		this.excluirObraLogic.envioIdUriParaExcluir(id);
	}
	
	
	@Then("valido mensagem de exclusao")
	public void valido_msg_exclusao() {
		this.excluirObraLogic.validoMsgExclusao();
	}

}
