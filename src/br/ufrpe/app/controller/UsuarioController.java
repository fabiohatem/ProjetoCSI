package br.ufrpe.app.controller;

import br.ufrpe.app.model.dao.UsuarioDao;
import br.ufrpe.app.model.dao.daoImpl.UsuarioDaoImpl;
import br.ufrpe.app.model.entity.Usuario;
import br.ufrpe.app.util.exception.UsuarioException;


public class UsuarioController {
	
	UsuarioDao usuarioDao;

	public Usuario[] findAll() {
		usuarioDao = UsuarioDaoImpl.getInstance();
		return usuarioDao.findAll();
	}
	
	public Usuario findByMatricula(String matricula) {
		usuarioDao = UsuarioDaoImpl.getInstance();
		return usuarioDao.findByMatricula(matricula);
	}

	public Usuario findByLogin(String login) {
		usuarioDao = UsuarioDaoImpl.getInstance();
		return usuarioDao.findByLogin(login);
	}

	public void create(Usuario usuario) throws UsuarioException {
		usuarioDao = UsuarioDaoImpl.getInstance();
		usuarioDao.create(usuario);
		usuarioDao.salvarArquivo();
	}

	public void update(Usuario usuario) {
		usuarioDao = UsuarioDaoImpl.getInstance();
		usuarioDao.update(usuario);
		usuarioDao.salvarArquivo();
	}

	public void delete(String matricula) {
		usuarioDao = UsuarioDaoImpl.getInstance();
		usuarioDao.delete(matricula);
		usuarioDao.salvarArquivo();
	}

}
