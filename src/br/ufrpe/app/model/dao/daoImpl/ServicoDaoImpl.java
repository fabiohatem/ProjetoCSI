package br.ufrpe.app.model.dao.daoImpl;

import br.ufrpe.app.model.dao.ServicoDao;
import br.ufrpe.app.model.repository.ServicoRepository;
import br.ufrpe.app.model.entity.Servico;

public class ServicoDaoImpl implements ServicoDao {
	
	private int totalDeServicos = 0;
	
	public ServicoDaoImpl(){
		ServicoRepository.iniciaRepository();
		totalDeServicos = ServicoRepository.totalDeServicosInicial;
	}

	@Override
	public Servico[] acharTudo() {	
		return ServicoRepository.servicos;
	}

	@Override
	public Servico acharPeloNome(String nome) {
		Servico result = null;
		for (int i = 0; i < totalDeServicos; i++) {
			if (ServicoRepository.servicos[i].getNome().equals(nome)) {
				result = ServicoRepository.servicos[i];
			}
		}
		return result;
	}

	@Override
	public Servico acharPelaPosicao(int posicao) {
		return ServicoRepository.servicos[posicao];
	}

	@Override
	public boolean contem(Servico servico) {
		for (int i = 0; i < this.totalDeServicos; i++) {
			if (servico.equals(ServicoRepository.servicos[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int tamanho() {
		return this.totalDeServicos;
	}

	@Override
	public void criar(Servico servico) {
		this.garantaEspaco();
		ServicoRepository.servicos[this.totalDeServicos] = servico;
		this.totalDeServicos++;
	}

	@Override
	public void criar(int posicao, Servico servico) {
		this.garantaEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = this.totalDeServicos - 1; i >= posicao; i--) {
			ServicoRepository.servicos[i + 1] = ServicoRepository.servicos[i];
		}
		ServicoRepository.servicos[posicao] = servico;
		this.totalDeServicos++;
	}


	@Override
	public void atualizar(Servico servico) {
		for (int i = 0; i < this.totalDeServicos; i++) {
			if (servico.getNome().equals(ServicoRepository.servicos[i].getNome())) {
				ServicoRepository.servicos[i] = servico;
			}
		}
	}
	
	public void deletar(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = posicao; i < this.totalDeServicos - 1; i++) {
			ServicoRepository.servicos[i] = ServicoRepository.servicos[i + 1];
		}
		this.totalDeServicos--;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeServicos;
	}

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeServicos;
	}

	private void garantaEspaco() {
		if (this.totalDeServicos == ServicoRepository.servicos.length) {
			Servico[] novoArray = new Servico[ServicoRepository.servicos.length * 2];
			for (int i = 0; i < ServicoRepository.servicos.length; i++) {
				novoArray[i] = ServicoRepository.servicos[i];
			}
			ServicoRepository.servicos = novoArray;
		}
	}
	
}
	
	


