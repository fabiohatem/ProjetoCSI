package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Conta;

public interface RepositorioContas {
	
	public void inserir(Conta conta);
	public void atualizar(Conta conta);
	public Conta procurar(String numero);
	public void remover(String numero);

}
