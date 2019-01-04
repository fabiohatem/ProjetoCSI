package br.ufrpe.app.model.dao.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.ufrpe.app.model.dao.UsuarioDao;
import br.ufrpe.app.model.entity.Conta;
import br.ufrpe.app.model.entity.Usuario;
import br.ufrpe.app.util.exception.UsuarioException;


public class UsuarioDaoImpl implements UsuarioDao, Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario[] usuarios;
	private int indice;
	
	private final static int TAMANHO = 100;
	private static UsuarioDaoImpl instance;
	
	public UsuarioDaoImpl() {
		this.usuarios = new Usuario[TAMANHO];
		this.indice = 0;
	}
	
	public static UsuarioDaoImpl getInstance() {
		if (instance == null) {
			instance = lerDoArquivo();
		}
		return instance;
	}

	public static UsuarioDaoImpl lerDoArquivo() {
		UsuarioDaoImpl instanciaLocal = null;

		File in = new File("usuarios.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (UsuarioDaoImpl) o;
		} catch (Exception e) {
			instanciaLocal = new UsuarioDaoImpl();
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
		File out = new File("usuarios.dat");
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
	public Usuario[] findAll() {
		Usuario us[] = new Usuario[tamanho()];
		for (int i = 0; i < us.length; i++) {
			us[i] = usuarios[i];
		}
		return us;
	}

	@Override
	public Usuario findByLogin(String login) {
		for (int i = 0; i < indice; i++) {
			if (usuarios[i].getLogin().equals(login)) {
				return usuarios[i];
			}

		}
		return null;
	}

	@Override
	public Usuario findByMatricula(String matricula) {
		for (int i = 0; i < indice; i++) {
			if (usuarios[i].getMatricula().equals(matricula)) {
				return usuarios[i];
			}

		}
		return null;
	}

	@Override
	public boolean contem(Usuario usuario) {
		for (int i = 0; i < indice; i++) {
			if (usuarios[i].getLogin().equals(usuario.getLogin()) || usuarios[i].getMatricula().equals(usuario.getMatricula())) {
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
	public void create(Usuario usuario) throws UsuarioException {
		if (contem(usuario)) {
			throw new UsuarioException("Usuário: "+usuario.getNome()+" já está cadastrado!");
		} else {
			this.usuarios[indice] = usuario;
			this.indice = this.indice + 1;
		}
	}

	@Override
	public void update(Usuario usuario) {
		Usuario usuarioAtualizada = findByMatricula(usuario.getMatricula());
		usuarioAtualizada = usuario;
	}

	@Override
	public void delete(String matricula) {
		for (int i = 0; i < indice; i++) {
			if (usuarios[i].getMatricula().equals(matricula)) {
				usuarios[i] = usuarios[this.indice];
				this.indice--;
			}

		}
	}
	
}
