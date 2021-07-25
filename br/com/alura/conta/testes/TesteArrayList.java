package br.com.alura.conta.testes;

import java.util.ArrayList;

import br.com.alura.conta.*;
import br.com.alura.listas.Guardador;

public class TesteArrayList {

	public static void main(String[] args) {

		ArrayList<Conta> lista = new ArrayList<Conta>();
		ContaCorrente cc = new ContaCorrente(1, 11);
		ContaCorrente cc1 = new ContaCorrente(1, 11);
		ContaPoupanca cp = new ContaPoupanca(1, 12);
		lista.add(cc);
		lista.add(cp);
		if(!lista.contains(cc1))
			lista.add(cc1); //nao adiciona
		
		//Compilador não permite essa adição porque String não é do tipo Conta
		//lista.add("Terceiro item, já redimensionado");
		
		lista.remove(0);
		
		for(Object o : lista) {
			System.out.println(o);
		}
		
	}

}
