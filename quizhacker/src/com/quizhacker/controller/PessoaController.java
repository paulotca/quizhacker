package com.quizhacker.controller;

import java.util.List;

import com.quizhacker.entity.Pessoa;
import com.quizhaker.dao.PessoaDao;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

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
	
	
	
	

}
