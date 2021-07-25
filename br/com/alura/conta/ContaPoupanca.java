package br.com.alura.conta;
public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(Cliente titular) {
		super(titular);
	}

	public ContaPoupanca(int agencia, int conta) {
		super(agencia, conta);
	}

	public boolean saca(double valor) {
		if(this.getSaldo() + this.tarifarSaque() >= valor) {
			return super.saca(valor + this.tarifarSaque());
		} else {
			return false;
		}
	}
	
	public double tarifarSaque() {
		return 0;
	}

	@Override
	public String toString() {
		return "ContaPoupanca " + super.toString();
	}
	
}
