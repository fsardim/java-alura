package br.com.alura.conta.exceptions;

public class MinhaExcecao extends Exception {

	public MinhaExcecao(String message) {
		super(message);
	}

	public MinhaExcecao(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MinhaExcecao(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}