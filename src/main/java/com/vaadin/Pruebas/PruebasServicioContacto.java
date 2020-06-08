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
		Contacto contactoPrueba1 = new Contacto(new Long(1),"Gabrielle","Patel","Apple Inc.","PatelKalash@gmail.com","653842564","Calle Pantomima Full, 45");
		Contacto contactoPrueba2 = new Contacto(new Long(2),"Pedro","Carlino","Microsoft Corporation","CarlinoPerrete@gmail.com","658942063","Calle Falsa, 123");
		Contacto contactoPrueba3 = new Contacto(new Long(3),"Pablo","Terrier","Microsoft Corporation","PabloPerrete@gmail.com","698731032","Calle Falsa, 122");
		serviciodatos.save(contactoPrueba1);
		assertEquals(serviciodatos.count(),1);
		assertEquals(serviciodatos.findAll().size(),1);
		assertTrue(serviciodatos.findAll().get(0).equals(contactoPrueba1));
		serviciodatos.save(contactoPrueba2);
		assertEquals(serviciodatos.count(),2);
		assertEquals(serviciodatos.findAll().size(),2);
		serviciodatos.save(contactoPrueba3);
		assertEquals(serviciodatos.count(),3);
		assertEquals(serviciodatos.findAll().size(),3);
		
		assertEquals(serviciodatos.findAll("Gabrielle").size(),1);
		assertTrue(serviciodatos.findAll("Gabrielle").get(0).equals(contactoPrueba1));
		
		assertEquals(serviciodatos.findAll("Carlino").size(),1);
		assertTrue(serviciodatos.findAll("Carlino").get(0).equals(contactoPrueba2));
		
		assertEquals(serviciodatos.findAll("Microsoft Corporation").size(),2);
		
	}
	
	@Test
	void testDelete() 
	{
		this.serviciodatos = new ServicioContacto();
		Contacto contactoPrueba1 = new Contacto(new Long(1),"Gabrielle","Patel","Apple Inc.","PatelKalash@gmail.com","653842564","Calle Pantomima Full, 45");
		serviciodatos.save(contactoPrueba1);
		Contacto contactoPrueba2 = new Contacto(new Long(2),"Pedro","Carlino","Microsoft Corporation","CarlinoPerrete@gmail.com","658942063","Calle Falsa, 123");
		serviciodatos.save(contactoPrueba2);
		
		serviciodatos.delete(contactoPrueba1);
		assertEquals(serviciodatos.count(),1);
		assertEquals(serviciodatos.findAll("Gabrielle").size(),0);
		serviciodatos.delete(contactoPrueba2);
		assertEquals(serviciodatos.count(),0);
		assertEquals(serviciodatos.findAll("Carlino").size(),0);
		
	}

}
