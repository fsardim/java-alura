package br.com.alura.listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.comparators.NumeroDaContaComparator;
import br.com.alura.comparators.TitularDaContaComparator;
import br.com.alura.conta.Cliente;
import br.com.alura.conta.Conta;
import br.com.alura.conta.ContaCorrente;
import br.com.alura.conta.ContaPoupanca;

public class OrdernarLista {
	public static void main(String[] args) throws Exception {
		
		Conta cc1 = new ContaCorrente(2, 33);
        Cliente clienteCC1 = new Cliente();
        clienteCC1.setNome("Nico");
        cc1.setTitular(clienteCC1);
        cc1.depositar(333.0);

        Conta cc2 = new ContaPoupanca(22, 44);
        Cliente clienteCC2 = new Cliente();
        clienteCC2.setNome("Guilherme");
        cc2.setTitular(clienteCC2);
        cc2.depositar(444.0);

        Conta cc3 = new ContaCorrente(222, 11);
        Cliente clienteCC3 = new Cliente();
        clienteCC3.setNome("Paulo");
        cc3.setTitular(clienteCC3);
        cc3.depositar(1110.0);

        Conta cc4 = new ContaPoupanca(22, 22);
        Cliente clienteCC4 = new Cliente();
        clienteCC4.setNome("Ana");
        cc4.setTitular(clienteCC4);
        cc4.depositar(22.0);
		
		List<Conta> lista = new ArrayList<>();
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);
		
		//Classificar de acordo com o número da Conta - critérios da classe NumeroDaContaComparator;
		lista.sort(new NumeroDaContaComparator());

		//Classificar de acordo com o nome do titular - critérios da classe TitularDaContaComparator;
		lista.sort(new TitularDaContaComparator());
		
		//Classificar usando classe anonima com critério de saldo 
		lista.sort(new Comparator<Conta>() {
			
				@Override
				public int compare(Conta c1, Conta c2) {
					return Double.compare(c1.getSaldo(), c2.getSaldo());
				}
			
			}
		);
		
		//Classificar usando lambda function com critério de número de agência
		lista.sort( 
				(c1, c2) -> Integer.compare(c1.getAgencia(), c2.getAgencia()) 
		); 

		//Classificar usando lambda function com critério de renda do cliente
		lista.sort( (c1, c2) -> {
			double renda1 = c1.getCliente().getRenda();
			double renda2 = c2.getCliente().getRenda();
			return Double.compare(renda1, renda2);
		});
		
		
		//Outra forma de classificar usando o número da conta
		Collections.sort(lista, new NumeroDaContaComparator());

		//Outra forma de classificar usando o titular da conta
		Collections.sort(lista, new TitularDaContaComparator());
		
		//Outros métodos
		Collections.rotate(lista, 1);
		Collections.shuffle(lista);
		System.out.println();
		System.out.println("Maior saldo: " + Collections.max(lista));
		System.out.println("Menor saldo: " + Collections.min(lista));
		
		//lambda function para decidir o que fazer na iteração da lista
		lista.forEach( 
			(conta) -> System.out.println(conta)
		);
				
		//Classificar de acordo com a ordem natural de comparação da classe Conta - método compareTo(Conta c);
		Collections.sort(lista);

		System.out.println();
		for (Conta conta : lista) {
			System.out.println(conta + ", Saldo: " + conta.getSaldo());
		}
		

	}
}
