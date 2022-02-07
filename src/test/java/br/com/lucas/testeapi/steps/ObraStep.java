package br.com.lucas.testeapi.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import br.com.lucas.testeapi.models.Obra;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ObraStep {
	
	private static final String BASE_URI = "http://localhost:";
	
	private static final Integer port = 8080;
	
	private static final String BASE_PATH = "/obras";
	
	private Response response;
	
	private RestAssured restAssured;
	
	@Given("envio solicitação uri base")
	public void envio_solicitação_uri_base() {
		restAssured.given().and()
		.baseUri(BASE_URI).port(port).basePath(BASE_PATH);
	}
	
	@When("preencho atributos json")
	public void preencho_atributos_json() {
		this.response = restAssured.given().contentType(ContentType.JSON).when()
			.body(Obra.builder().titulo("Clean codett").editora("teste").build()).when().post(BASE_PATH);
	}
	
	@Then("valido retorno json")
	public void valido_retorno_json() {
		this.response.then().log().all().assertThat().statusCode(201).body("titulo",
				is(equalTo("Clean codett")));
	}
	
	
	
}
