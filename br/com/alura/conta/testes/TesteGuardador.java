package br.com.alura.conta.testes;

import br.com.alura.conta.*;
import br.com.alura.listas.Guardador;

public class TesteGuardador {

	public static void main(String[] args) {

		Guardador guardador = new Guardador(2);
		ContaCorrente cc = new ContaCorrente(1, 11);
		ContaPoupanca cp = new ContaPoupanca(1, 12);
		guardador.adiciona(cc);
		guardador.adiciona(cp);
		guardador.adiciona("Terceiro item, já redimensionado");
		
		for (int i = 1; i <= 5; i++) {
			guardador.adiciona(new ContaCorrente(1, i*i));
		}

		guardador.exibir();
		System.out.println("  ");
		guardador.apagaReferencia(2);
		guardador.apagaReferencia(2);
		guardador.apagaReferencia(2);
		guardador.exibir();
	}

}
