package br.com.alura.conta.enums;

public enum LiteraisExtrato {

	SAQUE("Saque"), TRANSFERENCIA("Transfer�ncia"), DEPOSITO("Dep�sito"), ESTORNO("Estorno de opera��o");

	private String literais;
	
	LiteraisExtrato(String literal) {
		this.literais = literal;
	}
	
}