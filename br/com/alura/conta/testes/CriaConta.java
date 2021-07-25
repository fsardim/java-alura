package br.com.alura.conta.testes;

import br.com.alura.conta.Cliente;
import br.com.alura.conta.ContaCorrente;
import br.com.alura.conta.ContaPoupanca;

public class CriaConta {

	public static void main(String[] args) throws Exception {

		Cliente felipe = new Cliente("399.042.288-09", "Felipe", "Engenheiro", 1000);
		ContaCorrente cc = new ContaCorrente(11, 22);
		ContaPoupanca cp = new ContaPoupanca(felipe);
		
		cc.depositar(200.0);
		cp.depositar(100);
		
		cc.saca(50);
		if(cc.transferir(25, cp)) {
			System.out.println("Transferência ok");
		} else {			
			System.out.println("Transferência nok");
		}
		
		
		System.out.println(" ");

		cc.extrato();
		System.out.println("Saldo CC: " + cc.getSaldo());
		
		System.out.println(" ");
		
		cp.extrato();
		System.out.println("Saldo CP: " + cp.getSaldo());

		try {
			cc.métodoComErro(cc);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());			
		} finally {
			System.out.println("Depois do erro tratado, executei esse comando");
		}		
	}

}