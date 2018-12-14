import br.ufrpe.app.model.dao.daoImpl.RepositorioContasArray;
import br.ufrpe.app.model.entity.Conta;

public class Exemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RepositorioContasArray contas = new RepositorioContasArray();
		Conta conta1 = new Conta("123", 100);
		Conta conta2 = new Conta("321", 200);
		RepositorioContasArray.getInstance().inserir(conta1);
		RepositorioContasArray.getInstance().inserir(conta2);
		RepositorioContasArray.getInstance().salvarArquivo();
		RepositorioContasArray.getInstance().lerDoArquivo();
		System.out.println(RepositorioContasArray.getInstance().procurar("321").getSaldo());

	}

}
