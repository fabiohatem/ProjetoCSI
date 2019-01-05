package br.ufrpe.app.model.dao;

import br.ufrpe.app.model.entity.Equipamento;
import br.ufrpe.app.util.exception.EquipamentoException;


public interface EquipamentoDao {

	void salvarArquivo();

	Equipamento[] findAll();

	Equipamento findByCodigo(String codigo);

	boolean contem(Equipamento equipamento);

	int tamanho();

	void create(Equipamento equipamento) throws EquipamentoException;

	void update(Equipamento equipamento);

	void delete(String codigo);

	}

