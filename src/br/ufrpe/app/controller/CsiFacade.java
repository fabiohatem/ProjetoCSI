package br.ufrpe.app.controller;

import br.ufrpe.app.model.entity.Solicitacao;
import br.ufrpe.app.util.exception.SolicitacaoException;

public class CsiFacade {

	
	SolicitacaoController solicitacaoController;


	public CsiFacade() {

	}
	
	public Solicitacao[] findAllSolicitacao() {
		return getSolicitacaoController().findAll();
	}

	public Solicitacao findSolicitacaoByNome(int codigo) {
		return getSolicitacaoController().findByCodigo(codigo);
	}

	public void createSolicitacao(Solicitacao solicitacao) throws SolicitacaoException {
		getSolicitacaoController().create(solicitacao);
	}

	public void updateSolicitacao(Solicitacao solicitacao) {
		getSolicitacaoController().update(solicitacao);
	}

	public void deleteSolicitacao(int codigo) {
		getSolicitacaoController().delete(codigo);
	}

	public SolicitacaoController getSolicitacaoController() {
		if (solicitacaoController == null) {
			solicitacaoController = new SolicitacaoController();
		}
		return solicitacaoController;
	}
	
	
	

}
