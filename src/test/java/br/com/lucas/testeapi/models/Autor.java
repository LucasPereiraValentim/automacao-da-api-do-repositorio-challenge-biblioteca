package br.com.lucas.testeapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Autor {
	
	private String nome; 
}
