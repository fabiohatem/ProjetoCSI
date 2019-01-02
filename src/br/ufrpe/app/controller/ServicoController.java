package br.ufrpe.app.controller;

import br.ufrpe.app.model.dao.ServicoDao;
import br.ufrpe.app.model.dao.daoImpl.ServicoDaoImpl;
import br.ufrpe.app.model.entity.Servico;
import br.ufrpe.app.util.exception.ServicoException;


public class ServicoController {
	
	ServicoDao servicoDao = new ServicoDaoImpl();
	
	public Servico[] findAll() {
		servicoDao = ServicoDaoImpl.getInstance();
		return servicoDao.findAll();
	}

	public Servico findByNome(String nome) {
		servicoDao = ServicoDaoImpl.getInstance();
		return servicoDao.findByNome(nome);
	}
	
	public void create(Servico servico) throws ServicoException {
		servicoDao = ServicoDaoImpl.getInstance();
		servicoDao.create(servico);
		servicoDao.salvarArquivo();
	}

	public void update(Servico servico) {
		servicoDao = ServicoDaoImpl.getInstance();
		servicoDao.update(servico);
		servicoDao.salvarArquivo();
	}

	public void delete(String nome) {
		servicoDao = ServicoDaoImpl.getInstance();
		servicoDao.delete(nome);
		servicoDao.salvarArquivo();
	}
	
}
