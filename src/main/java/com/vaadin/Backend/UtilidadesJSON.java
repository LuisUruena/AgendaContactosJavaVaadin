package com.vaadin.Backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
	
	public static HashMap<Long, Contacto> cargarJSON(String ruta) throws FileNotFoundException
	{
		Gson gson = new Gson();
		File archivoJSON = new File(ruta);
		String JSON;
		Scanner lectorFichero = new Scanner (archivoJSON);
		JSON = lectorFichero.nextLine();
		Type tipo = new TypeToken<HashMap<Long, Contacto>>(){}.getType();
	    HashMap<Long, Contacto> contactos = gson.fromJson(JSON, tipo); 
		
		return contactos;
	}
	
	
	
	

}
