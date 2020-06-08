package com.vaadin.Pruebas;

import static org.junit.Assert.assertTrue;
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
	
	@Test
	void testFindAll() 
	{
		this.serviciodatos = new ServicioContacto();
		assertEquals(serviciodatos.findAll().size(),0);
		Contacto contactoPrueba1 = new Contacto(null,"Gabrielle","Patel","Apple Inc.","PatelKalash@gmail.com","653842564","Calle Pantomima Full, 45");
		Contacto contactoPrueba2 = new Contacto(null,"Pedro","Carlino","Microsoft Corporation","CarlinoPerrete@gmail.com","658942063","Calle Falsa, 123");
		serviciodatos.save(contactoPrueba1);
		assertEquals(serviciodatos.count(),1);
		assertEquals(serviciodatos.findAll().size(),1);
		assertTrue(serviciodatos.findAll().get(0).equals(contactoPrueba1));
		serviciodatos.save(contactoPrueba2);
		assertEquals(serviciodatos.count(),2);
		assertEquals(serviciodatos.findAll().size(),2);
	}

}
