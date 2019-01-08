package br.ufrpe.test;

import br.ufrpe.app.controller.CsiFacade;
import br.ufrpe.app.model.dao.ServicoDao;
import br.ufrpe.app.model.dao.daoImpl.ServicoDaoImpl;
import br.ufrpe.app.model.entity.Servico;
import br.ufrpe.app.util.exception.ServicoException;

public class ServicoTest {
	
	public static void main(String[] args) throws ServicoException {
		
		CsiFacade facade = new CsiFacade();
		ServicoDao ser = ServicoDaoImpl.getInstance();
		
		Servico s = new Servico("Microfone","Sem pegar");
		// Servico s = ServicoDao.findByNome("CPU");
		ser.create(s);
		ser.salvarArquivo();
		ser.delete("Monitor");
		System.out.println(s);
		System.out.println();
		
		Servico[] se = facade.findAllServico();
		for (int i = 0; i < se.length; i++) {
			System.out.println(se[i]);
		}
	}
}
