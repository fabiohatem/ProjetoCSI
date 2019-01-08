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
		
		Servico s = new Servico("Monitor","Sem ligar");
		// Servico s = ServicoDao.findByNome("CPU");
		ser.create(s);
		ser.salvarArquivo();
		Servico t = ser.findByNome("RAM");
		System.out.println(s);
	}
}
