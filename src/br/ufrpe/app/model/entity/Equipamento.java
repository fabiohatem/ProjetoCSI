package br.ufrpe.app.model.entity;

import java.io.Serializable;

public class Equipamento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String descricao;
	private String codigo;
	private String tipo;
	private ItemEquipamento itens;
	private boolean composto;
	
	

	

	public Equipamento() {

	}

	public Equipamento(String nome, String codigo, String tipo, boolean composto) {
		super();
		this.descricao = descricao;
		this.codigo = codigo;
		this.tipo = tipo;
		this.composto = composto;
		this.itens = new ItemEquipamento();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isComposto() {
		return composto;
	}

	public void setComposto(boolean composto) {
		this.composto = composto;
	}

	public ItemEquipamento getItens() {
		return itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Equipamento other = (Equipamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipamento [descrição=" + descricao + ", codigo=" + codigo + ", tipo=" + tipo + "]";
	}

}
