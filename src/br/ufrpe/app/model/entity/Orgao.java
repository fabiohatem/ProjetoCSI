package br.ufrpe.app.model.entity;

import java.io.Serializable;

public class Orgao implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sigla;
	
	public Orgao() {
		
	}
	
	public Orgao(String nome, String sigla) {
		
		super();
		this.nome = nome;
		this.sigla = sigla;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orgao other = (Orgao) obj;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Orgao [nome=" + nome + ", sigla=" + sigla + "]";
	}
	
}
