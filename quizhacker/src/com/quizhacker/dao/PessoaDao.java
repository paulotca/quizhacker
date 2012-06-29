package com.quizhacker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

	public void atualiza(Pessoa pessoa) {
		Transaction tx = session.beginTransaction();
		this.session.update(pessoa);
		tx.commit();
	}

	public void remove(Pessoa pessoa) {
		Transaction tx = session.beginTransaction();
		this.session.delete(pessoa);
		tx.commit();
	}

	// criar uma lista de pessoa

	public List<Pessoa> listaTudo() {
		return this.session.createCriteria(Pessoa.class).list();
	}

	public Pessoa carrega(int id) {
		return (Pessoa) this.session.load(Pessoa.class, id);
	}

	public List<Pessoa> busca(String sisbov) {
		return session.createCriteria(Pessoa.class)
				.add(Restrictions.ilike("sisbov", sisbov, MatchMode.ANYWHERE))
				.list();
	}
}
