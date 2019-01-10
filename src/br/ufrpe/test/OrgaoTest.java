package br.ufrpe.test;

import br.ufrpe.app.controller.CsiFacade;
import br.ufrpe.app.model.dao.OrgaoDao;
import br.ufrpe.app.model.dao.daoImpl.OrgaoDaoImpl;
import br.ufrpe.app.model.entity.Orgao;
import br.ufrpe.app.util.exception.OrgaoException;

public class OrgaoTest {
	public static void main(String[] args) throws OrgaoException{
		
		CsiFacade facade= new CsiFacade();
		OrgaoDao org = OrgaoDaoImpl.getInstance();
		
		Orgao o = new Orgao("Administrador","ADM");
		
		org.create(o);
		org.salvarArquivo();
		System.out.println(o);
		System.out.println();
		
		Orgao[] or = facade.findAllOrgao();
		for(int i = 0;i<or.length;i++) {
			System.out.println(or[i]);
		}
	}
}
