package br.com.alura.bytebank;

public class ControleBonificacao {

	private double soma;
	
	public void registraBonificacao(Funcionario f) {
		this.soma += f.getBonificacao();
	}
	
	
	public double getSoma() {
		return soma;
	}
}
