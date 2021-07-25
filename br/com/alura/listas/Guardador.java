package br.com.alura.listas;

public class Guardador {

	private Object[] referencias;
	private int posicaoLivre;
	
	public Guardador() {
        this.referencias = new Object[10];
        this.posicaoLivre = 0;
    }
	
	public Guardador(int qtdPosicoes) {
		this.referencias = new Object[qtdPosicoes];
		this.posicaoLivre = 0;
	}
	

    public void adiciona(Object ref) {
    	if(validaPosicao(this.posicaoLivre)) {
    		this.referencias[this.posicaoLivre] = ref;    		
    	} else {
    		this.redimensionaReferencias();
    		this.referencias[this.posicaoLivre] = ref;
    	}
    	this.posicaoLivre++;
    }
    
    public Object getReferencia(int pos) {
    	if(validaPosicao(pos)) {
    		return this.referencias[pos];
    	}
    	return null;
    }

    public void apagaReferencia(int pos) {
    	if(validaPosicao(pos)) {    		
    		this.referencias[pos] = null;
    		this.reorganizaArray(pos);
    	}
    }
    
    public void apagarUltimo() {
    	this.referencias[this.posicaoLivre - 1] = null;
    	this.posicaoLivre--;
    }

    public void reorganizaArray(int pos) {
    	for (int i=pos; i <= this.referencias.length - 2; i++) {
    		this.referencias[i] = this.referencias[i+1];
    		this.referencias[i+1] = null;
    	}
    }
    
    public int getQuantidadeDeElementos() {
        return this.posicaoLivre;
    }
    
    public boolean validaPosicao(int pos) {
		return pos >= 0 && pos < this.referencias.length;
    }
    
    public void redimensionaReferencias() {
    	Object[] novaReferencia = new Object[this.posicaoLivre + 1];
    	for(int i = 0; i < this.referencias.length; i++) {
    		novaReferencia[i] = this.referencias[i];
    	}
    	this.referencias = novaReferencia;
    }
    
    public void exibir() {
    	for (int i = 0; i < this.referencias.length; i++) {
    		System.out.println(this.referencias[i]);
    	}
    }
	
}
