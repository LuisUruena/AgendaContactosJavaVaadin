package com.vaadin.Backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioContacto {

	private static ServicioContacto instance;
	private static final Logger LOGGER = Logger.getLogger(ServicioContacto.class.getName());

	private final HashMap<Long, Contacto> contacts = new HashMap<>();
	private long nextId = 0;

	public ServicioContacto() 
	{
	}

	/**
	 * @return a reference to an example facade for Customer objects.
	 */
	public static ServicioContacto getInstance() {
		if (instance == null) {
			instance = new ServicioContacto();
		}
		return instance;
	}

	/**
	 * @return all available Contacto objects.
	 */
	public synchronized List<Contacto> findAll() {
		return null;
	}

	/**
	 * Finds all Customer's that match given filter.
	 *
	 * @param stringFilter filter that returned objects should match or null/empty
	 *                     string if all objects should be returned.
	 * @return list a Customer objects
	 */
	public synchronized List<Contacto> findAll(String stringFilter) 
	{
		return null;
	}

	/**
	 * Finds all Customer's that match given filter and limits the resultset.
	 *
	 * @param stringFilter filter that returned objects should match or null/empty
	 *                     string if all objects should be returned.
	 * @param start        the index of first result
	 * @param maxresults   maximum result count
	 * @return list a Customer objects
	 */
	public synchronized List<Contacto> findAll(String stringFilter, int start, int maxresults) 
	{
		return null;
	}

	/**
	 * @return the amount of all customers in the system
	 */
	public synchronized long count() 
	{
		return -1;
	}

	/**
	 * Deletes a customer from a system
	 *
	 * @param value the Customer to be deleted
	 */
	public synchronized void delete(Contacto value) 
	{
	}

	/**
	 * Persists or updates customer in the system. Also assigns an identifier for
	 * new Customer instances.
	 *
	 * @param entry
	 */
	public synchronized void save(Contacto entry) 
	{
		
	}

	/**
	 * Sample data generation
	 */


}