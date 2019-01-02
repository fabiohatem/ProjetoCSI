package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Servico;
import br.ufrpe.app.util.exception.ServicoException;

public interface ServicoDao {

	void salvarArquivo();

	Servico[] findAll();

	Servico findByNome(String nome);

	boolean contem(Servico servico);

	int tamanho();

	void create(Servico servico) throws ServicoException;

	void update(Servico servico);

	void delete(String nome);

	
}
