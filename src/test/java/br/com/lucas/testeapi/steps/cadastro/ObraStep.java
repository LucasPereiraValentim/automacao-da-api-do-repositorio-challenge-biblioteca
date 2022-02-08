package br.com.lucas.testeapi.steps.cadastro;

import br.com.lucas.testeapi.logic.LoginLogic;
import br.com.lucas.testeapi.logic.ObraLogic;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ObraStep {

	private LoginLogic loginLogic;
	
	private ObraLogic obraLogic;
	
	@Before
	public void setup() {
		this.loginLogic = new LoginLogic();
		this.obraLogic = new ObraLogic();
	}

	@Given("solicito requisicao")
	public void envio_solicitação_uri_base() {
		this.loginLogic.solicitoRequisicao();
	}

	@When("preencho campos de login no json")
	public void preencho_atributos_json() {
		this.loginLogic.preenchoCamposDeLoginNoJson();
	}
	
	
	@Then("valido login")
	public void valido_login() {
		this.loginLogic.validoRetornoToken();
	}
	
	@Then("preencho campos de cadastro de obra")
	public void cadastro_obra() {
		this.obraLogic.cadastroObraEAutores();
	}
	
	@Then("valido cadastro")
	public void valido_cadastro() {
		this.obraLogic.validoCadastroObra();
	}
	
	
	@When("preencho campos de cadastro de obra com titulo já cadastrado")
	public void preencho_campos_de_cadastro_de_obra_com_titulo_ja_cadastrado() {
		this.obraLogic.cadastroObraComTituloJaCadastrado();
	}
	
	@Then("valido mensagem")
	public void valido_msg_de_titulo_duplicado() {
		this.obraLogic.validoMsgObraDuplicada();
	}
	
}
