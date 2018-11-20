package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Servico;

public interface ServicoDao {

	Servico[] acharTudo();
	
	Servico acharPeloNome(String nome);
	
	Servico acharPelaPosicao (int posicao);
	
	boolean contem (Servico servico);
	
	int tamanho();
	
	boolean criar (Servico servico);
	
	boolean criar (int posicao, Servico servico);
	
	boolean atualizar (Servico servico);
	
}
