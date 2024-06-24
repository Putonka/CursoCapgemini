package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;
import com.example.ioc.Entorno;
import com.example.ioc.Rango;
import com.example.ioc.Saluda;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@Autowired
	ActorRepository dao;
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada");
		var item = dao.findById(201);
//		if(item.isEmpty()) {
//			System.err.println("No encontrado");
//		}
//		else {
//			System.out.println(item.get());
//		}
		dao.deleteById(201);
		dao.findAll().forEach(System.out::println);
		
//		var actor = new Actor(0, "Pepito", "Grillo");
//		System.out.println(dao.save(actor));
	}

}
