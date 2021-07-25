package br.com.alura.conta.testes;

import br.com.alura.conta.*;

public class TesteArray {

	public static void main(String[] args) {
		
		Conta[] contas = new Conta[5];

        ContaCorrente cc1 = new ContaCorrente(22, 11);
        contas[0] = cc1;

        ContaPoupanca cc2 = new ContaPoupanca(22, 22);
        contas[1] = cc2;

        //System.out.println(cc2.getNumero());

        System.out.println( contas[1].getNumero() );

        Conta ref = contas[1];
        System.out.println(cc2.getSaldo());
        ref.setSaldo(-100);
        System.out.println(cc2.getSaldo());
//        System.out.println(ref == cc2);
	
	}

}
