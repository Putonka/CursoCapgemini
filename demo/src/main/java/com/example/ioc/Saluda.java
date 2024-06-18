package com.example.ioc;

import org.springframework.stereotype.Component;

@Component
public class Saluda {
	Entorno entorno;
	
	
	public Saluda(Entorno entorno) {
		super();
		this.entorno = entorno;
	}


	public void saluda(String nombre) {
		entorno.write("Hola "+ nombre);
	}
}
