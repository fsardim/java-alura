package br.com.alura.comparators;

import java.util.Comparator;

import br.com.alura.conta.Conta;

public class TitularDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {

		String nomeC1 = c1.getCliente().getNome();
		String nomeC2 = c2.getCliente().getNome();
		
		return nomeC1.compareTo(nomeC2);
	}

}
