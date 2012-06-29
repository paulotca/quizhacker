package com.quizhacker.hibernate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped
public class CriadorDeSessionFactory implements
		ComponentFactory<SessionFactory> {

	private SessionFactory factory;

	@PostConstruct
	public void abre() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();

		configuration.configure();
		this.factory = configuration.buildSessionFactory();
		System.out.println("abre criador de sessaofactury");

	}

	@PreDestroy
	public void fecha() {
		this.factory.close();
		System.out.println("fecha criador de sessaofacrury");
	}

	@Override
	public SessionFactory getInstance() {

		return this.factory;

	}

	/*
	 * public CriadorDeSessionFactory(){ AnnotationConfiguration configuration =
	 * new AnnotationConfiguration();
	 * 
	 * configuration.configure();
	 * 
	 * factory = configuration.buildSessionFactory(); }
	 */

}
