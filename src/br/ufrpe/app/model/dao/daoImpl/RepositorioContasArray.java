package br.ufrpe.app.model.dao.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.ufrpe.app.model.dao.RepositorioContas;
import br.ufrpe.app.model.entity.Conta;

public class RepositorioContasArray implements  RepositorioContas , Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Conta[] contas;
	private int indice;
	
	private final static int TAMANHO = 100;
	private static RepositorioContasArray instance;
	
	public RepositorioContasArray() {
		this.contas = new Conta[TAMANHO];
		this.indice = 0;
	}
	
	public static RepositorioContasArray getInstance() {
	    if (instance == null) {
	      instance = lerDoArquivo();
	    }
	    return instance;
	  }
	
	public static RepositorioContasArray lerDoArquivo() {
		RepositorioContasArray instanciaLocal = null;

	    File in = new File("contas.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    try {
	      fis = new FileInputStream(in);
	      ois = new ObjectInputStream(fis);
	      Object o = ois.readObject();
	      instanciaLocal = (RepositorioContasArray) o;
	    } catch (Exception e) {
	      instanciaLocal = new RepositorioContasArray();
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

	public void salvarArquivo() {
	    if (instance == null) {
	      return;
	    }
	    File out = new File("contas.dat");
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
	public void inserir(Conta conta) {
		this.contas[indice] = conta;
		this.indice = this.indice +1;
		
	}

	@Override
	public void atualizar(Conta conta) {
		Conta contaAtualizada = procurar(conta.getNumero());
		contaAtualizada = conta;
		
	}

	@Override
	public Conta procurar(String numero) {
		for (int i = 0; i < indice; i++) {
			if (contas[i].getNumero().equals(numero)) {
				return contas[i];
			}
			
		}
		return null;
	}

	@Override
	public void remover(String numero) {
		for (int i = 0; i < indice; i++) {
			if (contas[i].getNumero().equals(numero)) {
				contas[i] = contas[this.indice];
				
				this.indice--;
			}
			
		}

		
	}

}