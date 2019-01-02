package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Solicitacao;
import br.ufrpe.app.util.exception.SolicitacaoException;

public interface SolicitacaoDao {
	
	void salvarArquivo();

	Solicitacao[] findAll();

	Solicitacao findByCodigo(int codigo);

	boolean contem(Solicitacao solicitacao);

	int tamanho();

	void create(Solicitacao solicitacao) throws SolicitacaoException;

	void update(Solicitacao solicitacao);

	void delete(int codigo);


}
