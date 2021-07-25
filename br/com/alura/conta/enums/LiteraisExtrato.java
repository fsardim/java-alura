package br.com.alura.conta.enums;

public enum LiteraisExtrato {

	SAQUE("Saque"), TRANSFERENCIA("Transferência"), DEPOSITO("Depósito"), ESTORNO("Estorno de operação");

	private String literais;
	
	LiteraisExtrato(String literal) {
		this.literais = literal;
	}
	
}