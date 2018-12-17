package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Orgao;

public interface OrgaoDao {

	Orgao[] findAll();

	Orgao findSigla  ( String sigla);

	Orgao findPosicao  (int posicao);

	boolean contem  (Orgao orgao);

	int tamanho();

	void criar (int posicao, Orgao orgao);
	void criar  (Orgao orgao);
	void update  (Orgao orgao);

	void delete  (int posicao);

	
}
