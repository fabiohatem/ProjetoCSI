package br.ufrpe.app.model.repository;

import br.ufrpe.app.model.entity.Servico;

public class ServicoRepository {

	public static Servico[] servicos = new Servico[100];
	private static boolean estaIniciado = false;
	
	public static void iniciaRepository() {
		if(!estaIniciado) {
			
			servicos[0] = new Servico("Manuten��o de micro", "Manuten��o de micro computadores");
			servicos[1] = new Servico("Manuten��o de impressora", "Manuten��o de impressoras jatos de tinta e a laser");
			servicos[2] = new Servico("Cadastro de Equipamento", "Cadastro de equipamentos de inform�tica");
			servicos[3] = new Servico("Instala��o de software", "Instala��o de softwares aplicativos");
			
			estaIniciado = true;
		}
	}
}
