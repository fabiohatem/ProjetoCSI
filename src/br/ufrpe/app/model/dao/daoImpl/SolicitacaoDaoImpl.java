package br.ufrpe.app.model.dao.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.ufrpe.app.model.dao.SolicitacaoDao;
import br.ufrpe.app.model.entity.Solicitacao;
import br.ufrpe.app.util.exception.SolicitacaoException;

public class SolicitacaoDaoImpl implements SolicitacaoDao, Serializable {

	private static final long serialVersionUID = 1L;

	private Solicitacao[] solicitacoes;
	private int indice;

	private final static int TAMANHO = 100;
	private static SolicitacaoDaoImpl instance;

	public SolicitacaoDaoImpl() {
		this.solicitacoes = new Solicitacao[TAMANHO];
		this.indice = 0;
	}

	public static SolicitacaoDaoImpl getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	public static SolicitacaoDaoImpl lerDoArquivo() {
		SolicitacaoDaoImpl instanciaLocal = null;

		File in = new File("solicitacoes.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (SolicitacaoDaoImpl) o;
		} catch (Exception e) {
			instanciaLocal = new SolicitacaoDaoImpl();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}

		return instanciaLocal;
	}

	@Override
	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("solicitacoes.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
		}
	}

	@Override
	public Solicitacao[] findAll() {
		Solicitacao us[] = new Solicitacao[tamanho()];
		for (int i = 0; i < us.length; i++) {
			us[i] = solicitacoes[i];
		}
		return us;
	}

	@Override
	public Solicitacao findByCodigo(int codigo) {
		for (int i = 0; i < indice; i++) {
			if (solicitacoes[i].getCodigo() == codigo) {
				return solicitacoes[i];
			}

		}
		return null;
	}

	@Override
	public boolean contem(Solicitacao solicitacao) {
		for (int i = 0; i < indice; i++) {
			if (solicitacoes[i].getCodigo() == solicitacao.getCodigo()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int tamanho() {
		return indice;
	}

	@Override
	public void create(Solicitacao solicitacao) throws SolicitacaoException {
		if (contem(solicitacao)) {
			throw new SolicitacaoException("Solicitacao: " + solicitacao.getCodigo() + " já está cadastrado!");
		} else {
			this.solicitacoes[indice] = solicitacao;
			this.indice = this.indice + 1;
		}
	}

	@Override
	public void update(Solicitacao solicitacao) {
		Solicitacao solicitacaoAtualizada = findByCodigo(solicitacao.getCodigo());
		solicitacaoAtualizada = solicitacao;
	}

	@Override
	public void delete(int codigo) {
		for (int i = 0; i < indice; i++) {
			if (solicitacoes[i].getCodigo() == codigo) {
				solicitacoes[i] = solicitacoes[this.indice];
				this.indice--;
			}

		}
	}
}
