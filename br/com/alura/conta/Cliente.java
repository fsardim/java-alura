package br.com.alura.conta;

import java.util.Objects;
/**
 * Classe com informações sobre Clientes
 * @author Felipe Sardim 
 * @version 1.0
 **/

public class Cliente { 
    private String nome;
    private String cpf;
    private String profissao;
    private double renda;
    
    /**
     * @param String cpf
     * @param String nome
     * @param String profissao
     * @param double renda
     * **/
    public Cliente(String cpf, String nome, String profissao, double renda) {
    	this.nome = nome;
    	this.cpf = cpf;
    	this.profissao = profissao;
    	this.renda = renda;
    }
    
    public Cliente() {
    	
    }
    
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", profissao=" + profissao + ", renda: " + renda +"]";
	}


	/**
	 * @return String nome
	 * **/
	public String getNome() {
		return this.nome;
	}	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getRenda() {
		return this.renda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, nome, profissao, renda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(nome, other.nome)
				&& Objects.equals(profissao, other.profissao)
				&& Double.doubleToLongBits(renda) == Double.doubleToLongBits(other.renda);
	}
	
}