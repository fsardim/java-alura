package br.com.alura.conta;

public class ContaCorrente extends Conta {
	
	private int totalSaques = 1;
	private double limite;

	public ContaCorrente(Cliente titular) {
		super(titular);
		this.limite = titular.getRenda();
	}

	public ContaCorrente(int agencia, int conta) { 
		super(agencia, conta);
		this.limite = 100.0;
	}
	
	public boolean saca(double valor) {
		if(this.getSaldo() + this.limite + this.tarifarSaque() >= valor) {
			this.totalSaques++;
			return super.saca(valor + this.tarifarSaque());
		} else {
			return false;
		}
	}
	
	public double tarifarSaque() {
		if(this.totalSaques == 5) {
			this.totalSaques = 1;
			return 0.50;
		} else {
			return 0.10;
		}
	}

	@Override
	public String toString() {
		return "ContaCorrente " + super.toString();
	}
	
}
