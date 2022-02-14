package br.com.lucas.testeapi.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static io.restassured.RestAssured.given;

public class ExcluirObraLogic {
	
	private static final Logger LOG = LoggerFactory.getLogger(ExcluirObraLogic.class);
	
	private static final String BASE_URI_DELETE = "/obras/";
	
	
	private String getToken() {
		return LoginLogic.response.header("Authorization");
	}
	
	public void envioIdUriParaExcluir(Integer id) {
		String msg = "Envio requisição na URI com ID para exclusão";
		LOG.info(msg);
		LoginLogic.response = given().header("Authorization", this.getToken()).delete(BASE_URI_DELETE + id);
	}
	
	public void validoMsgExclusao() {
		String msg = "Valido status code";
		LOG.info(msg);
		LoginLogic.response.then().log().all().statusCode(200);
	}
}
