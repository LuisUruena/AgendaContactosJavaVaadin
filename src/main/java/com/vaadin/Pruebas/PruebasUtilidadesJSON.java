package com.vaadin.Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.vaadin.Backend.ServicioContacto;

public class PruebasUtilidadesJSON 
{
	private ServicioContacto serviciodatos;
	
	@Test
	public void testGuardarJSON()
	{
		serviciodatos = new ServicioContacto();
		serviciodatos.saveSampleData();
		try {
			serviciodatos.guardarFicheroJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File archivoJSON = new File(serviciodatos.RUTA);
		assertTrue(archivoJSON.exists());
		
	}
	
	@Test
	public void testCargarJSON() 
	{
		serviciodatos = new ServicioContacto();
		try {
			serviciodatos.cargarFicheroJSON();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(serviciodatos.count(),2);
	}

}
