package br.ufrpe.app.controller;

import br.ufrpe.app.model.dao.ServicoDao;
import br.ufrpe.app.model.dao.daoImpl.ServicoDaoImpl;
import br.ufrpe.app.model.entity.Servico;
import br.ufrpe.app.util.exception.ServicoException;


public class ServicoController {
	
	ServicoDao servicoDao = new ServicoDaoImpl();
	
	public Servico[] findAll() {
		return servicoDao.findAll();
	}

	public Servico findByNome(String nome) {
		return servicoDao.findByNome(nome);
	}
	
	public void create(Servico servico) throws ServicoException {
		servicoDao.create(servico);
	}

	public void update(Servico servico) {
		servicoDao.update(servico);
	}

	public void delete(String nome) {
		servicoDao.delete(nome);
	}
	
}
