package com.vaadin.Backend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import com.google.gson.Gson;

public class UtilidadesJSON 
{

	public static void guardarJSON(String ruta, HashMap<Long, Contacto> contactos) throws IOException 
	{
		Gson gson = new Gson(); 
		String json = gson.toJson(contactos); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
	    writer.write(json);
	    writer.close();
	}
	
	public static HashMap<Long, Contacto> cargarJSON(String ruta) 
	{
		return null;
	}
	
	
	
	

}
