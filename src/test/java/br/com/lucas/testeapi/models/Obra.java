package br.com.lucas.testeapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Obra {
	
	private String titulo;
	
	private String editora;
	
	
}
