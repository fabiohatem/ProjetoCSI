package br.ufrpe.app.controller;

import br.ufrpe.app.model.dao.OrgaoDao;
import br.ufrpe.app.model.dao.daoImpl.OrgaoDaoImpl;
import br.ufrpe.app.model.entity.Orgao;

public class OrgaoController {

	OrgaoDao orgaoDao = new OrgaoDaoImpl();

	public Orgao[] findAll() {
		
		return orgaoDao.findAll();
	
	}

	public Orgao findSigla(String sigla) {
		return orgaoDao.findSigla(sigla);
	}

	public void create(Orgao orgao) {
		orgaoDao.criar(orgao);
	}

	public void update(Orgao orgao) {
		orgaoDao.update(orgao);
	}

	public void delete(int posicao) {
		orgaoDao.delete(posicao);
	}
}
