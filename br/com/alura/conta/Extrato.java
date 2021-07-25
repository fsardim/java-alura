package br.com.alura.conta;
import java.util.ArrayList;
import java.util.Date;

import br.com.alura.conta.enums.LiteraisExtrato;

public class Extrato {

	private ArrayList operacoes;
	
	public Extrato() {
		this.operacoes = new ArrayList();
	}

	public void registrar(int agencia, int conta, LiteraisExtrato literal, double valor) {
		Date d = new Date();
		operacoes.add(d.toString() + " - " + agencia + "." + conta + " - " + literal + ", R$ " + valor);
	}
	
	public void exibirExtrato() {
		for(int i = 0; i < operacoes.size(); i++) {
			System.out.println(operacoes.get(i));
		}
	}
	
}
