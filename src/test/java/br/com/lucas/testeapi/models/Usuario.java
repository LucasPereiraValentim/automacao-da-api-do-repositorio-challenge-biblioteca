package br.com.lucas.testeapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class Usuario {
	
	private String login;
	
	private String senha;
	
}
