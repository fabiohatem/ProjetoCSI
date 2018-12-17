
package br.ufrpe.app.controller;


import br.ufrpe.app.model.dao.UsuarioDao;
import br.ufrpe.app.model.dao.daoImpl.UsuarioDaoImpl;
import br.ufrpe.app.model.entity.Usuario;



public class UsuarioController {
	
UsuarioDao usuarioDao = new UsuarioDaoImpl();
	
	public Usuario[] findAll() {
		return usuarioDao.findAll();
	}

	public Usuario findByLogin(String login) {
		return usuarioDao.findByLogin(login);
	}
	
	public void criar(Usuario usuario) {
		usuarioDao.create(usuario);
	}

	public void atualizar(Usuario usuario) {
		usuarioDao.update(usuario);
	}

	public void deletar(int posicao) {
		usuarioDao.delete(posicao);
	}

}

