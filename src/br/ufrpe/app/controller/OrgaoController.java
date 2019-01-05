package br.ufrpe.app.controller;

import br.ufrpe.app.model.dao.OrgaoDao;
import br.ufrpe.app.model.dao.daoImpl.OrgaoDaoImpl;
import br.ufrpe.app.model.entity.Orgao;
import br.ufrpe.app.util.exception.OrgaoException;

public class OrgaoController {

	OrgaoDao orgaoDao;

	public Orgao[] findAll() {
		orgaoDao = OrgaoDaoImpl.getInstance();
		return orgaoDao.findAll();
	}

	public Orgao findBySigla(String sigla) {
		orgaoDao = OrgaoDaoImpl.getInstance();
		return orgaoDao.findBySigla(sigla);
	}

	public void create(Orgao orgao) throws OrgaoException {
		orgaoDao = OrgaoDaoImpl.getInstance();
		orgaoDao.create(orgao);
		orgaoDao.salvarArquivo();
	}

	public void update(Orgao orgao) {
		orgaoDao = OrgaoDaoImpl.getInstance();
		orgaoDao.update(orgao);
		orgaoDao.salvarArquivo();
	}

	public void delete(String sigla) {
		orgaoDao = OrgaoDaoImpl.getInstance();
		orgaoDao.delete(sigla);
		orgaoDao.salvarArquivo();
	}
}
