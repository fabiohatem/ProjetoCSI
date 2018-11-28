package br.ufrpe.app.model.dao.daoImpl;

import br.ufrpe.app.model.dao.UsuarioDao;
import br.ufrpe.app.model.entity.Usuario;
import br.ufrpe.app.model.repository.UsuarioRepository;

public class UsuarioDaoImpl implements UsuarioDao {

	private int totalDeUsuarios = 0;

	public UsuarioDaoImpl() {
		UsuarioRepository.iniciaRepository();
		totalDeUsuarios = UsuarioRepository.totalDeUsuariosInicial;
	}

	@Override
	public Usuario[] findAll() {
		return UsuarioRepository.usuarios;//
	}

	@Override
	public Usuario findByLogin(String login) {
		Usuario result = null;
		for (int i = 0; i < totalDeUsuarios; i++) {
			if (UsuarioRepository.usuarios[i].getLogin().equals(login)) {
				result = UsuarioRepository.usuarios[i];
			}
		}
		return result;
	}

	@Override
	public Usuario findByPosicao(int posicao) {
		return UsuarioRepository.usuarios[posicao];
	}

	@Override
	public boolean contem(Usuario usuario) {
		for (int i = 0; i < this.totalDeUsuarios; i++) {
			if (usuario.equals(UsuarioRepository.usuarios[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int tamanho() {
		return this.totalDeUsuarios;
	}

	@Override
	public void create(Usuario usuario) {
		this.garantaEspaco();
		UsuarioRepository.usuarios[this.totalDeUsuarios] = usuario;
		this.totalDeUsuarios++;
	}

	@Override
	public void create(int posicao, Usuario usuario) {
		this.garantaEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = this.totalDeUsuarios - 1; i >= posicao; i--) {
			UsuarioRepository.usuarios[i + 1] = UsuarioRepository.usuarios[i];
		}
		UsuarioRepository.usuarios[posicao] = usuario;
		this.totalDeUsuarios++;
	}

	@Override
	public void update(Usuario usuario) {
		for (int i = 0; i < this.totalDeUsuarios; i++) {
			if (usuario.getLogin().equals(UsuarioRepository.usuarios[i].getLogin())) {
				UsuarioRepository.usuarios[i] = usuario;
			}
		}
	}

	@Override
	public void delete(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = posicao; i < this.totalDeUsuarios - 1; i++) {
			UsuarioRepository.usuarios[i] = UsuarioRepository.usuarios[i + 1];
		}
		this.totalDeUsuarios--;
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeUsuarios;
	}

	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeUsuarios;
	}

	private void garantaEspaco() {
		if (this.totalDeUsuarios == UsuarioRepository.usuarios.length) {
			Usuario[] novoArray = new Usuario[UsuarioRepository.usuarios.length * 2];
			for (int i = 0; i < UsuarioRepository.usuarios.length; i++) {
				novoArray[i] = UsuarioRepository.usuarios[i];
			}
			UsuarioRepository.usuarios = novoArray;
		}
	}
	
}
