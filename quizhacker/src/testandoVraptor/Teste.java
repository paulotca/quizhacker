package testandoVraptor;


import com.quizhacker.dao.PessoaDao;
import com.quizhacker.entity.Pessoa;

import br.com.caelum.vraptor.Resource;

@Resource
public class Teste {
	
	//private final PessoaDao dao;
	
	//public Teste(PessoaDao dao){
	//	this.dao = dao;
	//}

	public void teste(){
		System.out.println("entrando no teste");
	}
	
	//public void testarSalvar(){
	//	Pessoa p = new Pessoa();
	//	p.setNome("teste");
	//	p.setCpf("03231321");
	//	dao.salvar(p);
		
	//}

	
	
}
