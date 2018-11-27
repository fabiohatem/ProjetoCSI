package br.ufrpe.app.controller;

import br.ufrpe.app.model.dao.ServicoDao;
import br.ufrpe.app.model.dao.daoImpl.ServicoDaoImpl;
import br.ufrpe.app.model.entity.Servico;

public class ServicoController {
	
	ServicoDao servicoDao = new ServicoDaoImpl();
	
	public Servico[] acharTudo() {
		return servicoDao.acharTudo();
	}

	public Servico acharPeloNome(String nome) {
		return servicoDao.acharPeloNome(nome);
	}
	
	public void criar(Servico servico) {
		servicoDao.criar(servico);
	}

	public void atualizar(Servico servico) {
		servicoDao.atualizar(servico);
	}

	public void deletar(int posicao) {
		servicoDao.deletar(posicao);
	}
	
}
