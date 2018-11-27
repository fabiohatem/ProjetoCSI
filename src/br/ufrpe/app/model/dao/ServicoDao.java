package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Servico;

public interface ServicoDao {

	Servico[] acharTudo();
	
	Servico acharPeloNome(String nome);
	
	Servico acharPelaPosicao (int posicao);
	
	boolean contem (Servico servico);
	
	int tamanho();
	
	void criar (Servico servico);
	
	void criar (int posicao, Servico servico);
	
	void atualizar (Servico servico);
	
	void deletar (int posicao);
	
}
