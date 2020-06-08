package com.vaadin.Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.vaadin.Backend.Contacto;
import com.vaadin.Backend.ServicioContacto;

class PruebasServicioContacto {
	
	private ServicioContacto serviciodatos;

	@Test
	void testSave() 
	{
		this.serviciodatos = new ServicioContacto();
		assertEquals(serviciodatos.count(),0);
		Contacto contactoPruebaGuardar = new Contacto(null,"Gabrielle","Patel","Apple Inc.","PatelKalash@gmail.com","653842564","Calle Pantomima Full, 45");
		serviciodatos.save(contactoPruebaGuardar);
		assertEquals(serviciodatos.count(),1);
	}

}
