package br.com.alura.bytebank;

public class TestaFuncionario {

	public static void main(String[] args) {
	
		Funcionario f = new Funcionario("Felipe", "399.042.288-09", 3000.0);
		Gerente g = new Gerente("Laura", "1", 3000.0, 1234);
		ControleBonificacao b = new ControleBonificacao();
		
		System.out.println(f.getBonificacao());
		System.out.println(g.getBonificacao());

		b.registraBonificacao(f);
		b.registraBonificacao(g);
		System.out.println(b.getSoma());
		
	}

}
