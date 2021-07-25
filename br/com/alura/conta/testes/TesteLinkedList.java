package br.com.alura.conta.testes;

import java.util.ArrayList;
import java.util.LinkedList;

import br.com.alura.conta.*;
import br.com.alura.listas.Guardador;

public class TesteLinkedList {

	public static void main(String[] args) {

		LinkedList<Conta> lista = new LinkedList<Conta>();
		ContaCorrente cc = new ContaCorrente(1, 11);
		ContaCorrente cc1 = new ContaCorrente(1, 111);
		ContaPoupanca cp = new ContaPoupanca(1, 12);
		lista.add(cc);
		lista.add(cp);
		if(!lista.contains(cc1))
			lista.add(cc1); //nao adiciona
		
		//Compilador n�o permite essa adi��o porque String n�o � do tipo Conta
		//lista.add("Terceiro item, j� redimensionado");
		
		System.out.println(lista.get(0));
//		lista.remove(0);
		
		for(Object o : lista) {
			System.out.println(o);
		}
		
	}

}
