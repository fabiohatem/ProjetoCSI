package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Usuario;

public interface UsuarioDao {
	
	Usuario[] findAll();

	Usuario findByLogin(String login);

	Usuario findByPosicao(int posicao);

	boolean contem(Usuario usuario);

	int tamanho();

	void create(Usuario usuario);

	void create(int posicao, Usuario usuario);

	void update(Usuario usuario);

	void delete(int posicao);


}
