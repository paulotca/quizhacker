package com.quizhacker.hibernate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CriadorDeSession implements ComponentFactory<Session> {

	private final SessionFactory factory;
	private Session session;

	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}

	@PostConstruct
	public void abre() {
		this.session = factory.openSession();
		System.out.println("abre criador de sessao");
	}

	@Override
	public Session getInstance() {
		return session;
	}

	@PreDestroy
	public void fecha() {
		this.session.close();
		System.out.println("fecha criador de sessao");
	}

}