package br.com.lucas.testeapi.logic;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static io.restassured.RestAssured.*;

import br.com.lucas.testeapi.models.Usuario;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginLogic {
	
private static final String BASE_URI = "http://localhost:";
	
	private static final Integer port = 8080;
	
	private static final String BASE_PATH = "/login";
	
	public static Response response;
	
	//public static RestAssured restAssured;
	
	public void solicitoRequisicao() {
		given()
		.and()
		.baseUri(BASE_URI)
		.port(port)
		.basePath(BASE_PATH);
	}
	
	
	public void preenchoCamposDeLoginNoJson() {
		response = given()
				.contentType(ContentType.JSON)
				.when()
				.body(Usuario.builder().login("admin").senha("admin").build())
				.when()
				.post(BASE_PATH);
	}
	
	
	public void validoRetornoToken() {
		response.then().log().all().assertThat().statusCode(200).header("Authorization", not(equalTo("")));
	}
	
	
	
}
