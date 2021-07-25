package br.com.alura.conta;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import br.com.alura.conta.enums.LiteraisExtrato;
import br.com.alura.conta.exceptions.ExceptionDeposita;
import br.com.alura.conta.exceptions.MinhaExcecao;

/**
 * @author Felipe Sardim
 * @version 1.0
 * 
 * */

public abstract class Conta implements Comparable<Conta> {

    private double saldo;
    private int agencia;
    private int numero;
    private static int numeroContas = 1;
    private Cliente titular;
    private Extrato extrato = new Extrato();
    
    /**
     * Construtor padrão 
     * @param Cliente titular
     * */
    public Conta(Cliente titular) {
    	this.saldo = 0.0;
    	this.agencia = 1;
    	this.numero = numeroContas;
    	this.titular = titular;
    	numeroContas++;
    }
    
    /**
     * Construtor alternativo. Cliente será atribuído em outro momento
     * @param int agencia
     * Código de agência
     * @param int numero da conta
     * Número da conta do cliente
     * */
    public Conta(int agencia, int numero) {
    	this.saldo = 0;
    	this.agencia = agencia;
    	this.numero = numero;
    	numeroContas++;
    }
    
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double valor) {
		this.saldo = valor;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}
	  
	public Cliente getCliente() {
		return titular;
	}
	
	public void setTitular(Cliente c) {
		this.titular = c;
	}
	
	public static int getTotalContas() {
		return Conta.numeroContas;
	}
	
	public void depositar(double valor) throws ExceptionDeposita {
		if(valor > 0.0) {
			this.saldo += valor;			
			this.extrato.registrar(this.agencia, this.numero, LiteraisExtrato.DEPOSITO, valor);
		} else { 
			throw new ExceptionDeposita("Valor de depósito invalido: " + valor);
		}
	}
	
	public boolean saca(double valor) {
		if(valor > 0.0) {			
			this.saldo -= valor;
			this.extrato.registrar(this.agencia, this.numero, LiteraisExtrato.SAQUE, valor);
			return true;
		} 
		return false;
	}
	
	public boolean transferir(double valor, Conta destino) {
		if(this.saca(valor)) {
			try {				
				destino.depositar(-1 * valor); //erro proposital
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Desfazendo Saque errado...");
				this.saldo += valor + this.tarifarSaque();
				this.extrato.registrar(this.agencia, this.numero, LiteraisExtrato.ESTORNO, valor + this.tarifarSaque());
				return false; 
			}
			this.extrato.registrar(this.agencia, this.numero, LiteraisExtrato.TRANSFERENCIA, valor);
			return true;
		}
		return false;
	}
 	
	public abstract double tarifarSaque();
	
	public void extrato() {
		this.extrato.exibirExtrato();
	}
	
	public void métodoComErro(Conta c) throws MinhaExcecao, ExceptionDeposita {
		Random r = new Random();
		if(r.nextBoolean()) {			
			throw new MinhaExcecao(this.trataErro(c));
		} else {
			throw new ExceptionDeposita(this.trataErro(c));
		}
	}

	@Override
	public String toString() {
		return "[agencia=" + agencia + ", numero=" + numero + ", titular=" + titular + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(agencia, numero, titular);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return agencia == other.agencia && numero == other.numero && Objects.equals(titular, other.titular);
	}

	public String trataErro(Object c) {
		return "Input: " + c.toString();
	}
	
	public int compareTo(Conta c) {
		return Double.compare(this.saldo, c.saldo);
	}
	
}