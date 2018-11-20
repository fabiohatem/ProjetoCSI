package br.ufrpe.app.model.repository;

import br.ufrpe.app.model.entity.Servico;

public class ServicoRepository {

	public static Servico[] servicos = new Servico[100];
	private static boolean estaIniciado = false;
	
	public static void iniciaRepository() {
		if(!estaIniciado) {
			
			servicos[0] = new Servico("Manutenção de micro", "Manutenção de micro computadores");
			servicos[1] = new Servico("Manutenção de impressora", "Manutenção de impressoras jatos de tinta e a laser");
			servicos[2] = new Servico("Cadastro de Equipamento", "Cadastro de equipamentos de informática");
			servicos[3] = new Servico("Instalação de software", "Instalação de softwares aplicativos");
			
			estaIniciado = true;
		}
	}
}
