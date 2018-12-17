package br.ufrpe.app.model.dao.daoImpl;

import java.io.Serializable;

import br.ufrpe.app.model.dao.OrgaoDao;
import br.ufrpe.app.model.entity.Orgao;
import br.ufrpe.app.model.repository.OrgaoRepository;

public class OrgaoDaoImpl implements OrgaoDao , Serializable{

	private int totalDeOrgaos = 0;

	public OrgaoDaoImpl() {
		OrgaoRepository.iniciaRepository();
		totalDeOrgaos = OrgaoRepository.totalDeOrgaosInicial;
	}

	@Override
	public Orgao[] findAll() {
		return OrgaoRepository.orgaos;
	}

	@Override
	public Orgao findSigla(String sigla) {
		Orgao result = null;
		for (int i = 0; i < totalDeOrgaos; i++) {
			if (OrgaoRepository.orgaos[i].getSigla().equals(sigla)) {
				result = OrgaoRepository.orgaos[i];
			}
		}
		return result;
	}

	@Override
	public Orgao findPosicao(int posicao) {
		return OrgaoRepository.orgaos[posicao];
	}

	@Override
	public boolean contem(Orgao orgao) {
		for (int i = 0; i < this.totalDeOrgaos; i++) {
			if (orgao.equals(OrgaoRepository.orgaos[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int tamanho() {
		return this.totalDeOrgaos;
	}

	@Override
	public void criar(Orgao orgao) {
		this.garantaEspaco();
		OrgaoRepository.orgaos[this.totalDeOrgaos] = orgao;
		this.totalDeOrgaos++;
	}

	@Override
	public void criar(int posicao, Orgao orgao) {
		this.garantaEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = this.totalDeOrgaos - 1; i >= posicao; i--) {
			OrgaoRepository.orgaos[i + 1] = OrgaoRepository.orgaos[i];
		}
		OrgaoRepository.orgaos[posicao] = orgao;
		this.totalDeOrgaos++;
	}

	@Override
	public void update(Orgao orgao) {
		for (int i = 0; i < this.totalDeOrgaos; i++) {
			if (orgao.getSigla().equals(OrgaoRepository.orgaos[i].getSigla())) {
				OrgaoRepository.orgaos[i] = orgao;
			}
		}
	}

	@Override
	public void delete(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = posicao; i < this.totalDeOrgaos - 1; i++) {
			OrgaoRepository.orgaos[i] = OrgaoRepository.orgaos[i + 1];
		}
		this.totalDeOrgaos--;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeOrgaos;
	}

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeOrgaos;
	}

	private void garantaEspaco() {
		if (this.totalDeOrgaos == OrgaoRepository.orgaos.length) {
			Orgao[] novoArray = new Orgao[OrgaoRepository.orgaos.length * 2];
			for (int i = 0; i < OrgaoRepository.orgaos.length; i++) {
				novoArray[i] = OrgaoRepository.orgaos[i];
			}
			OrgaoRepository.orgaos = novoArray;
		}
	}
	

	}

