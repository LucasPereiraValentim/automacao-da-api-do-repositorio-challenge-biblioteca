package br.com.lucas.testeapi.models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Obra {
	
	private String titulo;
	
	private String editora;
	
	private List<Autor> autores;
	
	public Obra() {
		this.autores = new ArrayList<>();
	}
	
}
