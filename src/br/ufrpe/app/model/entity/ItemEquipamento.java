package br.ufrpe.app.model.entity;

import java.io.Serializable;

public class ItemEquipamento implements Serializable{

	private static final long serialVersionUID = 1L;
	private Object[] itens = new Object[20];
	private int contador = 0;

	public ItemEquipamento() {

	}

	public void addEquipamento(Equipamento e) {
		if (e == null) {
			throw new IllegalArgumentException("Equipamento inválido");
		}
		if (this.contador > 20) {
			throw new IllegalArgumentException("Equipamento atingiu o limite de 20 itens");
		}
		for (int i = 0; i < this.contador; i++) {
			if (this.itens[i] == null) {
				this.itens[i] = e;
				this.contador++;
			}
		}
	}

	public void addEquipamentoComposto(Equipamento[] ec) {
		if (ec == null) {
			throw new IllegalArgumentException("Equipamento inválido.");
		}
		if (this.contador > 20) {
			throw new IllegalArgumentException("Equipamento atingiu o limite de 20 itens");
		}
		for (int i = 0; i < this.contador; i++) {
			if (this.itens[i] == null) {
				this.itens[i] = ec;
				this.contador++;
			}
		}
	}

	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.contador;
	}

	public void deleteNaPosicao(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição inválida");
		}
		for (int i = posicao; i < this.contador - 1; i++) {
			this.itens[i] = this.itens[i + 1];
		}
		this.contador--;
	}

	public Object[] getItens() {
		return itens;
	}

}
 


