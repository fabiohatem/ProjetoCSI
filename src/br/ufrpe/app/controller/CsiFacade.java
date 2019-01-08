package br.ufrpe.app.controller;

import br.ufrpe.app.model.entity.Equipamento;
import br.ufrpe.app.model.entity.Orgao;
import br.ufrpe.app.model.entity.Servico;
import br.ufrpe.app.model.entity.Solicitacao;
import br.ufrpe.app.model.entity.Usuario;
import br.ufrpe.app.util.exception.EquipamentoException;
import br.ufrpe.app.util.exception.OrgaoException;
import br.ufrpe.app.util.exception.ServicoException;
import br.ufrpe.app.util.exception.SolicitacaoException;
import br.ufrpe.app.util.exception.UsuarioException;

public class CsiFacade {

	UsuarioController usuarioController;
	EquipamentoController equipamentoController;
	OrgaoController orgaoController;
	ServicoController servicoController;
	SolicitacaoController solicitacaoController;


	public CsiFacade() {

	}

	public Usuario[] findAllUsuario() {
		return getUsuarioController().findAll();
	}

	public Usuario findUsuarioByMatricula(String matricula) {
		return getUsuarioController().findByMatricula(matricula);
	}

	public Usuario findUsuarioByLogin(String login) {
		return getUsuarioController().findByLogin(login);
	}

	public void createUsuario(Usuario usuario) throws UsuarioException {
		getUsuarioController().create(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		getUsuarioController().update(usuario);
	}

	public void deleteUsuario(String matricula) {
		getUsuarioController().delete(matricula);
	}

	public Equipamento[] findAllEquipamento() {
		return getEquipamentoController().findAll();
	}

	public Equipamento findEquipamentoByCodigo(String codigo) {
		return getEquipamentoController().findByCodigo(codigo);
	}

	public void createEquipamento(Equipamento equipamento) throws EquipamentoException {
		getEquipamentoController().create(equipamento);
	}

	public void updateEquipamento(Equipamento equipamento) {
		getEquipamentoController().update(equipamento);
	}

	public void deleteEquipamento(String codigo) {
		getEquipamentoController().delete(codigo);
	}

	public Orgao[] findAllOrgao() {
		return getOrgaoController().findAll();
	}

	public Orgao findOrgaoBySigla(String sigla) {
		return getOrgaoController().findBySigla(sigla);
	}

	public void createOrgao(Orgao orgao) throws OrgaoException {
		getOrgaoController().create(orgao);
	}

	public void updateOrgao(Orgao orgao) {
		getOrgaoController().update(orgao);
	}

	public void deleteOrgao(String sigla) {
		getOrgaoController().delete(sigla);
	}
	public Servico[] findAllServico() {
		return getServicoController().findAll();
	}

	public Servico findServicoByNome(String nome) {
		return getServicoController().findByNome(nome);
	}

	public void createServico(Servico servico) throws ServicoException {
		getServicoController().create(servico);
	}

	public void updateServico(Servico servico) {
		getServicoController().update(servico);
	}

	public void deleteServico(String nome) {
		getServicoController().delete(nome);
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

	public UsuarioController getUsuarioController() {
		if (usuarioController == null) {
			usuarioController = new UsuarioController();
		}
		return usuarioController;
	}

	public EquipamentoController getEquipamentoController() {
		if (equipamentoController == null) {
			equipamentoController = new EquipamentoController();
		}
		return equipamentoController;
	}

	public OrgaoController getOrgaoController() {
		if (orgaoController == null) {
			orgaoController = new OrgaoController();
		}
		return orgaoController;
	}

	public ServicoController getServicoController() {
		if (servicoController == null) {
			servicoController = new ServicoController();
		}
		return servicoController;
	}

	public SolicitacaoController getSolicitacaoController() {
		if (solicitacaoController == null) {
			solicitacaoController = new SolicitacaoController();
		}
		return solicitacaoController;
	}
	
	

}
