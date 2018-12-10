package br.ufrpe.app.model.repository;

import br.ufrpe.app.model.entity.Equipamento;

public class EquipamentoRepository {

		public static Equipamento[] equipamentos = new Equipamento[100];
		private static boolean iniciado = false;
		public static int totalDeEquipamentosInicial = 4;
		
		public static boolean isIniciado() {
			return iniciado;
		}

		public static void iniciaRepository() {
			if (!isIniciado()) {
				equipamentos[0] = new Equipamento("Monitor 20 polegadas", "1001", "Monitor", false);
				equipamentos[1] = new Equipamento("CPU Dual Core", "1002", "CPU", true);
				equipamentos[2] = new Equipamento("Impressora jato de tinta", "1003", "Impressora", false);
				equipamentos[3] = new Equipamento("Impressora Laser", "1004", "Impressora", false);
				iniciado = true;
			}
		}

	}

