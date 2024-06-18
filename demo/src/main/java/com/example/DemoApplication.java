package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ioc.Saluda;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	Saluda saluda;
	
	@Autowired
	Saluda saluda2;
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada");
		
		System.out.println(saluda2.getContador());
		
		saluda.saluda("Mundo");
		saluda.saluda("Mundo");
		
		System.out.println(saluda2.getContador());
	}

}
