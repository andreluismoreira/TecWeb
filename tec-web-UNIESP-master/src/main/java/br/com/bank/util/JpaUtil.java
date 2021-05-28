package br.com.bank.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("ACME");
		}
		return factory;
	}
	
	public static void finalFactory() {
		if (factory != null) {
			factory.close();
		}
	}
}
