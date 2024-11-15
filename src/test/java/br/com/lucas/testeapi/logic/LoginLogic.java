package br.com.lucas.testeapi.logic;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static br.com.lucas.testeapi.utils.APIUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.*;

import br.com.lucas.testeapi.models.Usuario;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class LoginLogic {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginLogic.class);
	
	private static final String BASE_URI = "http://localhost:";
	
	private static final Integer port = 8080;
	
	private static final String BASE_PATH = "/login";
	
	public static Response response;
	
	public void solicitoRequisicao() {
		String msg = "Solicito requisição";
		LOG.info(msg);
		given()
		.and()
		.baseUri(BASE_URI)
		.port(port)
		.basePath(BASE_PATH);
	}
	
	
	public void preenchoCamposDeLoginNoJson() {
		String msg = "Preencho campos de login";
		LOG.info(msg);
		response = given()
				.contentType(ContentType.JSON)
				.when()
				.body(Usuario.builder().login("admin").senha("admin").build())
				.when()
				.post(BASE_PATH);
	}

	public static String getTokenAcessoAplicacao() {
		setContentTypeRequest(ContentType.JSON);
		Response response = post(BASE_PATH, Usuario.builder().login("admin").senha("admin").build());
		return response.headers().getValue("");
	}
	
	
	public void validoRetornoToken() {
		String msg = "Valido TOKEN no header do response";
		LOG.info(msg);
		response.then().statusCode(200).header("Authorization", not(equalTo("")));
	}
	
	
	
}
