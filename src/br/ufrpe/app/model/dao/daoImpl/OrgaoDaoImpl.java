package br.ufrpe.app.model.dao.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.ufrpe.app.model.dao.OrgaoDao;
import br.ufrpe.app.model.entity.Orgao;
import br.ufrpe.app.util.exception.OrgaoException;


public class OrgaoDaoImpl implements OrgaoDao, Serializable{

	private static final long serialVersionUID = 1L;

	private Orgao[] orgaos;
	private int indice;

	private final static int TAMANHO = 100;
	private static OrgaoDaoImpl instance;

	public OrgaoDaoImpl() {
		this.orgaos = new Orgao[TAMANHO];
		this.indice = 0;
	}

	public static OrgaoDaoImpl getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	public static OrgaoDaoImpl lerDoArquivo() {
		OrgaoDaoImpl instanciaLocal = null;

		File in = new File("orgaos.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (OrgaoDaoImpl) o;
		} catch (Exception e) {
			instanciaLocal = new OrgaoDaoImpl();
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
		File out = new File("orgaos.dat");
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
	public Orgao[] findAll() {
		Orgao us[] = new Orgao[tamanho()];
		for (int i = 0; i < us.length; i++) {
			us[i] = orgaos[i];
		}
		return us;
	}

	@Override
	public Orgao findBySigla(String sigla) {
		for (int i = 0; i < indice; i++) {
			if (orgaos[i].getSigla().equals(sigla)) {
				return orgaos[i];
			}

		}
		return null;
	}

	@Override
	public boolean contem(Orgao orgao) {
		for (int i = 0; i < indice; i++) {
			if (orgaos[i].getSigla().equals(orgao.getSigla())) {
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
	public void create(Orgao orgao) throws OrgaoException {
		if (contem(orgao)) {
			throw new OrgaoException("Orgao: " + orgao.getSigla() + " já está cadastrado!");
		} else {
			this.orgaos[indice] = orgao;
			this.indice = this.indice + 1;
		}
	}

	@Override
	public void update(Orgao orgao) {
		Orgao orgaoAtualizado = findBySigla(orgao.getSigla());
		
		orgaoAtualizado = orgao;
	}

	@Override
	public void delete(String sigla) {
		for (int i = 0; i < indice; i++) {
			if (orgaos[i].getSigla().equals(sigla)) {
				orgaos[i] = orgaos[this.indice];
				this.indice--;
			}

		}
	}

}
