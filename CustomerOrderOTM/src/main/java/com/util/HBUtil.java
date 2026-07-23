package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtil {
	public static SessionFactory getSessionFactory() {
		return new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		
	}
}
