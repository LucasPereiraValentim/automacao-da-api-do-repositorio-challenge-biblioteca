package br.com.lucas.testeapi.logic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static br.com.lucas.testeapi.utils.APIUtils.*;
import static br.com.lucas.testeapi.utils.Await.*;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lucas.testeapi.models.Autor;
import br.com.lucas.testeapi.models.Obra;
import io.restassured.http.ContentType;


public class CadastroObraLogic {
	
	private static final Logger LOG = LoggerFactory.getLogger(CadastroObraLogic.class);
	
	private static final String BASE_URI_POST = "/obras";
	
	private List<Autor> autores;
	
	private static final String MSG_TITULO_DUPLICADO = "Já existe uma obra cadastrada com este título";
	
	private static final String MSG_CAMPOS_VAZIOS = "Um ou mais campos estão vazios";
	
	public CadastroObraLogic() {
		this.autores = new ArrayList<Autor>();
		autores.add(Autor.builder().nome("Robert C. Martin ").build());
	}
	
	private String getToken() {
		return LoginLogic.response.header("Authorization");
	}
	
	
	public void cadastroObraEAutores() {
		LOG.info("Preencho campos dados válidos");
		setHeader("Authorization", this.getToken());
		setContentTypeRequest(ContentType.JSON);
		await(() -> post(BASE_URI_POST, Obra.builder()
				.titulo("Clean Code").editora("Alta Books; 1ª edição (8 setembro 2009)")
				.autores(autores).build()).statusCode() == 201);
	}
	
	
	public void validoCadastroObra() {
		String msg = "Válido o cadastro da obra";
		LOG.info(msg);
		LoginLogic.response.then().log().all().statusCode(201).body("titulo", is(equalTo("Clean Code")));
	}
	
	public void cadastroObraComTituloJaCadastrado() {
		String msg = "Preencho campos com dados da obra e autores repetidos";
		LOG.info(msg);
		LoginLogic.response = given().headers("Authorization", this.getToken()).body(Obra.builder()
								.titulo("Clean Code").editora("Alta Books; 1ª edição (8 setembro 2009)")
								.autores(autores).build()).contentType(ContentType.JSON).post(BASE_URI_POST);
	}
	
	public void validoMsgObraDuplicada() {
		String msg = "Válido mensagem";
		LOG.info(msg +" '{}'", MSG_TITULO_DUPLICADO);
		LoginLogic.response.then().log().all().statusCode(200).body("titulo", is(equalTo(MSG_TITULO_DUPLICADO)));
	}
	
	public void camposVazios() {
		String msg = "Envio requisição com campos vázios";
		LOG.info(msg);
		LoginLogic.response = given().header("Authorization", this.getToken()).body(Obra.builder().titulo("").editora("").build())
				.contentType(ContentType.JSON).post(BASE_URI_POST);
	}
	
	public void validoMsgCamposVazios() {
		String msg = "Válido mensagem";
		LOG.info(msg + " '{}'", MSG_CAMPOS_VAZIOS);
		LoginLogic.response.then().log().all().statusCode(400)
		.body("titulo", is(equalTo(MSG_CAMPOS_VAZIOS)));
	}
}