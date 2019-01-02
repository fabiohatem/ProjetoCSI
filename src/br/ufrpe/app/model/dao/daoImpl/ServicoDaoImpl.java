package br.ufrpe.app.model.dao.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.ufrpe.app.model.dao.ServicoDao;
import br.ufrpe.app.model.entity.Servico;
import br.ufrpe.app.util.exception.ServicoException;

public class ServicoDaoImpl implements ServicoDao, Serializable{

	private static final long serialVersionUID = 1L;

	private Servico[] servicos;
	private int indice;

	private final static int TAMANHO = 100;
	private static ServicoDaoImpl instance;

	public ServicoDaoImpl() {
		this.servicos = new Servico[TAMANHO];
		this.indice = 0;
	}

	public static ServicoDaoImpl getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	public static ServicoDaoImpl lerDoArquivo() {
		ServicoDaoImpl instanciaLocal = null;

		File in = new File("servicos.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (ServicoDaoImpl) o;
		} catch (Exception e) {
			instanciaLocal = new ServicoDaoImpl();
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
		File out = new File("servicos.dat");
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
	public Servico[] findAll() {
		Servico us[] = new Servico[tamanho()];
		for (int i = 0; i < us.length; i++) {
			us[i] = servicos[i];
		}
		return us;
	}

	@Override
	public Servico findByNome(String nome) {
		for (int i = 0; i < indice; i++) {
			if (servicos[i].getNome().equals(nome)) {
				return servicos[i];
			}

		}
		return null;
	}

	@Override
	public boolean contem(Servico servico) {
		for (int i = 0; i < indice; i++) {
			if (servicos[i].getNome().equals(servico.getNome())) {
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
	public void create(Servico servico) throws ServicoException {
		if (contem(servico)) {
			throw new ServicoException("Servico: " + servico.getNome() + " já está cadastrado!");
		} else {
			this.servicos[indice] = servico;
			this.indice = this.indice + 1;
		}
	}

	@Override
	public void update(Servico servico) {
		Servico servicoAtualizado = findByNome(servico.getNome());
		servicoAtualizado = servico;
	}

	@Override
	public void delete(String nome) {
		for (int i = 0; i < indice; i++) {
			if (servicos[i].getNome().equals(nome)) {
				servicos[i] = servicos[this.indice];
				this.indice--;
			}

		}
	}
}