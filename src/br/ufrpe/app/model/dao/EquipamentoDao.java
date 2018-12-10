package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Equipamento;

public interface EquipamentoDao {

		Equipamento[] findAll();

		Equipamento findByCodigo(String codigo);

		Equipamento findByPosicao(int posicao);

		boolean contem(Equipamento equipamento);

		int tamanho();

		void create(Equipamento equipamento);

		void create(int posicao, Equipamento equipamento);

		void update(Equipamento equipamento);

		void delete(int posicao);

	}

