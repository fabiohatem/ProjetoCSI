package br.ufrpe.app.model.entity;

import java.io.Serializable;

public class Solicitacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descricao;
	private Usuario usuarioRegistro;
	private Usuario usuarioExecucao;
	private Equipamento equipamento;
	private Orgao orgaoSolicitante;
	private Servico servicoSolicitado;
	public Solicitacao() {
		
	}
	public Solicitacao(int codigo, String descricao, Usuario usuarioRegistro, Equipamento equipamento,
			Orgao orgaoSolicitante, Servico servicoSolicitado) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.usuarioRegistro = usuarioRegistro;
		this.equipamento = equipamento;
		this.orgaoSolicitante = orgaoSolicitante;
		this.servicoSolicitado = servicoSolicitado;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuarioRegistro() {
		return usuarioRegistro;
	}
	public void setUsuarioRegistro(Usuario usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}
	public Usuario getUsuarioExecucao() {
		return usuarioExecucao;
	}
	public void setUsuarioExecucao(Usuario usuarioExecucao) {
		this.usuarioExecucao = usuarioExecucao;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	public Orgao getOrgaoSolicitante() {
		return orgaoSolicitante;
	}
	public void setOrgaoSolicitante(Orgao orgaoSolicitante) {
		this.orgaoSolicitante = orgaoSolicitante;
	}
	public Servico getServicoSolicitado() {
		return servicoSolicitado;
	}
	public void setServicoSolicitado(Servico servicoSolicitado) {
		this.servicoSolicitado = servicoSolicitado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Solicitacao other = (Solicitacao) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Solicitacao [codigo=" + codigo + ", descricao=" + descricao + ", usuarioRegistro=" + usuarioRegistro
				+ ", usuarioExecucao=" + usuarioExecucao + ", equipamento=" + equipamento + ", orgaoSolicitante="
				+ orgaoSolicitante + ", servicoSolicitado=" + servicoSolicitado + "]";
	}
	
}
