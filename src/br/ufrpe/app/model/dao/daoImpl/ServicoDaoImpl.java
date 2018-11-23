package br.ufrpe.app.model.dao.daoImpl;

import br.ufrpe.app.model.dao.ServicoDao;
import br.ufrpe.app.model.repository.ServicoRepository;
import br.ufrpe.app.model.entity.Servico;

public class ServicoDaoImpl implements ServicoDao {
	
	public ServicoDaoImpl(){
		ServicoRepository.iniciaRepository();
		
	}

	@Override
	public Servico[] acharTudo() {	
		return ServicoRepository.servicos;
	}

	@Override
	public Servico acharPeloNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Servico acharPelaPosicao(int posicao) {
		return ServicoRepository.servicos[posicao];
	}

	@Override
	public boolean contem(Servico servico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int tamanho() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean criar(Servico servico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean criar(int posicao, Servico servico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Servico servico) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
