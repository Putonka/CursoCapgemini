package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ioc.Entorno;
import com.example.ioc.Rango;
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
	@Autowired
	Entorno entorno;
	@Autowired
	private Rango rango;
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada");
		
		
		
		saluda.saluda("Mundo");
		saluda.saluda("Mundo");
		saluda2.saluda("World");
		
		System.out.println("saludaEs: " +saluda.getContador());
		System.out.println("entorno: " +entorno.getContador());
		
		System.out.println("saluda2: " + saluda2.getContador());
		
		System.out.println(rango.getMin() + "->" + rango.getMax());
	}

}
