package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Usuario;
import br.ufrpe.app.util.exception.UsuarioException;

public interface UsuarioDao {
	
	void salvarArquivo();

	Usuario[] findAll();

	Usuario findByLogin(String login);

	Usuario findByMatricula(String matricula);

	boolean contem(Usuario usuario);

	int tamanho();

	void create(Usuario usuario) throws UsuarioException;

	void update(Usuario usuario);

	void delete(String matricula);

}
