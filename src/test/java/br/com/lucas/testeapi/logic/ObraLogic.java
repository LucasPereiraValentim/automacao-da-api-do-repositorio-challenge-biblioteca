package br.com.lucas.testeapi.logic;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import br.com.lucas.testeapi.models.Autor;
import br.com.lucas.testeapi.models.Obra;
import io.restassured.http.ContentType;


public class ObraLogic {
	
	private static final String BASE_POST = "/obras";
	
	private List<Autor> autores;
	
	public ObraLogic() {
		this.autores = new ArrayList<Autor>();
		autores.add(Autor.builder().nome("Robert C. Martin ").build());
	}
	
	private String getToken() {
		return LoginLogic.response.header("Authorization");
	}
	
	
	public void cadastroObraEAutores() {
		LoginLogic.response = given().headers("Authorization", this.getToken()).body(Obra.builder()
								.titulo("Clean Code").editora("Alta Books; 1ª edição (8 setembro 2009)")
								.autores(autores).build()).contentType(ContentType.JSON).post(BASE_POST);
	}
	
	
	public void validoCadastroObra() {
		LoginLogic.response.then().log().all().assertThat().statusCode(201).body("titulo", is(equalTo("Clean Code")));
	}
	
	public void cadastroObraComTituloJaCadastrado() {
		LoginLogic.response = given().headers("Authorization", this.getToken()).body(Obra.builder()
								.titulo("Clean Code").editora("Alta Books; 1ª edição (8 setembro 2009)")
								.autores(autores).build()).contentType(ContentType.JSON).post(BASE_POST);
	}
	
	public void validoMsgObraDuplicada() {
		LoginLogic.response
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.body("titulo", is(equalTo("Já existe uma obra cadastrada com este título")));
	}
	
	public void camposVazios() {
		LoginLogic.response = given()
				.header("Authorization", this.getToken())
				.body(Obra.builder().titulo("").editora("").build())
				.contentType(ContentType.JSON).post(BASE_POST);
	}
	
	public void validoMsgCamposVazios() {
		LoginLogic.response
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(400)
		.body("titulo", is(equalTo("Um ou mais campos estão vazios")));
	}
}