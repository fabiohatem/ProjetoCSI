package br.ufrpe.app.model.repository;

import br.ufrpe.app.model.entity.Orgao;

public class OrgaoRepository {

	public static Orgao[] orgaos = new Orgao[100];
	private static boolean iniciado = false;
	public static int totalDeOrgaosInicial = 3;

	public static boolean Iniciado() {
		return iniciado;
	}
	
	public static void iniciaRepository() {
		if (! Iniciado () ) {
			
			orgaos[0] = new Orgao("Secretaria da Fazenda",   "SEFAZ");
			orgaos[1] = new Orgao("Instituto de Recursos Humanos",   "IRH");
			orgaos[2] = new Orgao("Unidade de Tecnologia da Informação",   "UTI");
			
			iniciado = true;
		}
	}

}
