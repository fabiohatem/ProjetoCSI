package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Orgao;
import br.ufrpe.app.util.exception.OrgaoException;

public interface OrgaoDao {

	void salvarArquivo();

	Orgao[] findAll();

	Orgao findBySigla(String sigla);

	boolean contem(Orgao orgao);

	int tamanho();

	void create(Orgao orgao) throws OrgaoException;

	void update(Orgao orgao);

	void delete(String sigla);

	
}
