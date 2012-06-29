package com.quizhacker.controller;

import java.util.List;

import com.quizhacker.dao.PessoaDao;
import com.quizhacker.entity.Pessoa;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;


@Resource
public class PessoaController {
	
	private final PessoaDao dao;
	private final Result result;
	private final Validator validator;
	
	public PessoaController(PessoaDao dao, Result result, Validator validator){
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Get
	@Path("/pessoa")
	public List<Pessoa>lista(){
		return dao.listaTudo();
	}
	
	
	@Post
	@Path("/pessoa")
	public void adiciona(Pessoa pessoa) {

		if (pessoa.getNome() == null || pessoa.getNome().length() < 3) {
			validator.add(new ValidationMessage(
					"Nome obrigatorio e maior que 3", "pessoa.nome"));
		}

		// validator.validate(pessoa); //esse seria pra validar com hibernate
		// validate
		
		validator.onErrorUsePageOf(PessoaController.class).formulario();

		dao.salvar(pessoa);
		result.forwardTo(this).lista();

	}
	
	
	@Get
	@Path("/pessoa/novo")
	public void formulario() {
	}

	@Get
	@Path("/pessoa/{id}")
	public Pessoa edita(int id) {
		return dao.carrega(id);
	}

	@Put
	@Path("/pessoa/{pessoa.id}")
	public void altera(Pessoa pessoa) {
		dao.atualiza(pessoa);
		result.redirectTo(this).lista();
	}

	@Delete
	@Path("/pessoa/{id}")
	public void remove(int id) {
		Pessoa pessoa = dao.carrega(id);
		dao.remove(pessoa);
		result.redirectTo(PessoaController.class).lista();

	}
	


}
