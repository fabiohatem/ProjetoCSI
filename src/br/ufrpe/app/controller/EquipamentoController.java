package br.ufrpe.app.controller;

import br.ufrpe.app.model.dao.daoImpl.EquipamentoDaoImpl;
import br.ufrpe.app.model.entity.Equipamento;
import br.ufrpe.app.util.exception.EquipamentoException;

public class EquipamentoController {

	EquipamentoDaoImpl equipamentoDao = new EquipamentoDaoImpl();

	public Equipamento[] findAll() {
		return equipamentoDao.findAll();
	}

	public Equipamento findByCodigo(String codigo) {
		return equipamentoDao.findByCodigo(codigo);
	}

	public void create(Equipamento equipamento) throws EquipamentoException {
		equipamentoDao.create(equipamento);
	}

	public void update(Equipamento equipamento) {
		equipamentoDao.update(equipamento);
	}

	public void delete(String codigo) {
		equipamentoDao.delete(codigo);
	}
}

