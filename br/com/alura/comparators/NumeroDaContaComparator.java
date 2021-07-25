package br.com.alura.comparators;

import java.util.Comparator;

import br.com.alura.conta.Conta;


/**
 * @author Felipe Sardim
 * @version 1.0.0
 * Classe com sobrecarga do método compare, da interface Comparator, por meio do número da conta
 */
public class NumeroDaContaComparator implements Comparator<Conta> {

	@Override
	public int compare(Conta c1, Conta c2) {
		return Integer.compare(c1.getNumero(), c2.getNumero());
	}

}

// Implementação 1
//		if(c1.getNumero() < c2.getNumero()) {
//			return -1;
//		} 
//		
//		if(c1.getNumero() > c2.getNumero()) {
//			return 1;
//		}
//				
//		return 0;
//
//	Implementação 2
//		return c1.getNumero() - c2.getNumero();