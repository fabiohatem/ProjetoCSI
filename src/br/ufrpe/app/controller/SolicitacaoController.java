package br.ufrpe.app.controller;

import br.ufrpe.app.model.dao.SolicitacaoDao;
import br.ufrpe.app.model.dao.daoImpl.SolicitacaoDaoImpl;
import br.ufrpe.app.model.entity.Solicitacao;
import br.ufrpe.app.util.exception.SolicitacaoException;

public class SolicitacaoController {

	SolicitacaoDao solicitacaoDao;

	public Solicitacao[] findAll() {
		solicitacaoDao = SolicitacaoDaoImpl.getInstance();
		return solicitacaoDao.findAll();
	}

	public Solicitacao findByCodigo(int codigo) {
		solicitacaoDao = SolicitacaoDaoImpl.getInstance();
		return solicitacaoDao.findByCodigo(codigo);
	}

	public void create(Solicitacao solicitacao) throws SolicitacaoException {
		solicitacaoDao = SolicitacaoDaoImpl.getInstance();
		solicitacaoDao.create(solicitacao);
		solicitacaoDao.salvarArquivo();
	}

	public void update(Solicitacao solicitacao) {
		solicitacaoDao = SolicitacaoDaoImpl.getInstance();
		solicitacaoDao.update(solicitacao);
		solicitacaoDao.salvarArquivo();
	}

	public void delete(int codigo) {
		solicitacaoDao = SolicitacaoDaoImpl.getInstance();
		solicitacaoDao.delete(codigo);
		solicitacaoDao.salvarArquivo();
	}
}
