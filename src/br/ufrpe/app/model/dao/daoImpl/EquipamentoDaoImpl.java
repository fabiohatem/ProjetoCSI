package br.ufrpe.app.model.dao.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.ufrpe.app.model.dao.EquipamentoDao;
import br.ufrpe.app.model.entity.Equipamento;
import br.ufrpe.app.util.exception.EquipamentoException;

public class EquipamentoDaoImpl implements EquipamentoDao, Serializable {

		private static final long serialVersionUID = 1L;

		private Equipamento[] equipamentos;
		private int indice;

		private final static int TAMANHO = 100;
		private static EquipamentoDaoImpl instance;

		public EquipamentoDaoImpl() {
			this.equipamentos = new Equipamento[TAMANHO];
			this.indice = 0;
		}

		public static EquipamentoDaoImpl getInstance() {
			if (instance == null) {
				instance = lerDoArquivo();
			}
			return instance;
		}

		public static EquipamentoDaoImpl lerDoArquivo() {
			EquipamentoDaoImpl instanciaLocal = null;

			File in = new File("equipamentos.dat");
			FileInputStream fis = null;
			ObjectInputStream ois = null;
			try {
				fis = new FileInputStream(in);
				ois = new ObjectInputStream(fis);
				Object o = ois.readObject();
				instanciaLocal = (EquipamentoDaoImpl) o;
			} catch (Exception e) {
				instanciaLocal = new EquipamentoDaoImpl();
			} finally {
				if (ois != null) {
					try {
						ois.close();
					} catch (IOException e) {
					}
				}
			}

			return instanciaLocal;
		}

		@Override
		public void salvarArquivo() {
			if (instance == null) {
				return;
			}
			File out = new File("equipamentos.dat");
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;

			try {
				fos = new FileOutputStream(out);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(instance);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (oos != null) {
					try {
						oos.close();
					} catch (IOException e) {
					}
				}
			}
		}

		@Override
		public Equipamento[] findAll() {
			Equipamento us[] = new Equipamento[tamanho()];
			for (int i = 0; i < us.length; i++) {
				us[i] = equipamentos[i];
			}
			return us;
		}

		@Override
		public Equipamento findByCodigo(String codigo) {
			for (int i = 0; i < indice; i++) {
				if (equipamentos[i].getCodigo().equals(codigo)) {
					return equipamentos[i];
				}

			}
			return null;
		}

		@Override
		public boolean contem(Equipamento equipamento) {
			for (int i = 0; i < indice; i++) {
				if (equipamentos[i].getCodigo().equals(equipamento.getCodigo())) {
					return true;
				}
			}
			return false;
		}

		@Override
		public int tamanho() {
			return indice;
		}

		@Override
		public void create(Equipamento equipamento) throws EquipamentoException {
			if (contem(equipamento)) {
				throw new EquipamentoException("Equipamento: " + equipamento.getDescricao() + " já está cadastrado!");
			} else {
				this.equipamentos[indice] = equipamento;
				this.indice = this.indice + 1;
			}
		}

		@Override
		public void update(Equipamento equipamento) {
			Equipamento equipamentoAtualizado = findByCodigo(equipamento.getCodigo());
			equipamentoAtualizado = equipamento;
		}

		@Override
		public void delete(String codigo) {
			for (int i = 0; i < indice; i++) {
				if (equipamentos[i].getCodigo().equals(codigo)) {
					equipamentos[i] = equipamentos[this.indice];
					this.indice--;
				}

			}
		}
	}

