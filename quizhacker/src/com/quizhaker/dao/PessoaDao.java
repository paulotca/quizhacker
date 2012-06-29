package com.quizhaker.dao;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.quizhacker.entity.Pessoa;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class PessoaDao {

	private final Session session;
	

	public PessoaDao(Session session) {
		this.session = session;
	}
	

	public void salvar(Pessoa pessoa) {
		Transaction tx = session.beginTransaction();
		this.session.save(pessoa);
		tx.commit();
	}
	

	public void atualizar(Pessoa pessoa) {
		Transaction tx = session.beginTransaction();
		this.session.update(pessoa);
		tx.commit();
	}
	

	public void remove(Pessoa pessoa) {
		Transaction tx = session.beginTransaction();
		this.session.delete(pessoa);
		tx.commit();
	}
	

	public List<Pessoa> listaTudo() {
		return this.session.createCriteria(Pessoa.class).list();
	}

	
	public Pessoa carrega(long id) {
		return (Pessoa) this.session.load(Pessoa.class, id);
	}
	

	public List<Pessoa> busca(String nome) {
		return session.createCriteria(Pessoa.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

}
