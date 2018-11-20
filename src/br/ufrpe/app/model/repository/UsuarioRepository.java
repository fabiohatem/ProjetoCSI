package br.ufrpe.app.model.repository;

import br.ufrpe.app.model.entity.Usuario;

public class UsuarioRepository {

	public static Usuario[] usuarios = new Usuario[100];
	private static boolean iniciado = false;
	public static int totalDeUsuariosInicial = 2;

	public static boolean isIniciado() {
		return iniciado;
	}

	public static void iniciaRepository() {
		if (!isIniciado()) {
			usuarios[0] = new Usuario("Administrador", "123", "admin");
			usuarios[1] = new Usuario("Usuário 1", "321", "user1");
			iniciado = true;
		}
	}
	
}
