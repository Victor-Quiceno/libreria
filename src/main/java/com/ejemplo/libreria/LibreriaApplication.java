package com.ejemplo.libreria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

// Excluimos las configuraciones automáticas de base de datos ya que no las usamos todavía
@SpringBootApplication (exclude = {
	DataSourceAutoConfiguration.class,
	HibernateJpaAutoConfiguration.class
})
public class LibreriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}

}
