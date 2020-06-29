package com.vaadin.agendaContactos;


import java.io.IOException;

import com.vaadin.Backend.Contacto;
import com.vaadin.Backend.ServicioContacto;
import com.vaadin.data.Binder;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

public class FormularioContacto extends FormLayout
{
	private TextField nombre = new TextField("Nombre");
	private TextField apellidos = new TextField("Apellidos");
	private TextField empresa = new TextField("Empresa");
	private TextField email = new TextField("Email");
	private TextField telefonoContacto = new TextField("Teléfono de contacto");
	private TextField direccion = new TextField("Dirección");
	private Button save = new Button("Guardar");
	private Button delete = new Button("Eliminar");
	private Binder<Contacto> binder = new Binder<>(Contacto.class);
	
	private VistaPrincipal vistaPrincipal;
	private ServicioContacto servicioContacto = ServicioContacto.getInstance();

	public FormularioContacto(VistaPrincipal vistaPrincipal) 
	{
	    this.vistaPrincipal = vistaPrincipal;
		HorizontalLayout buttons = new HorizontalLayout(save, delete);
	    this.addComponents(nombre, apellidos, empresa, email, telefonoContacto, direccion, buttons);
	    
	    binder.bindInstanceFields(this);
	    
	    save.addClickListener(event -> guardar());
	    delete.addClickListener(event -> eliminar());
	}
	
	public void setContacto(Contacto contacto) 
	{
	    binder.setBean(contacto);

	    if (contacto == null) 
	    {
	        setVisible(false);
	    } 
	    else 
	    {
	        setVisible(true);
	        nombre.focus();
	    }
	}
	
	private void guardar() {
	    Contacto contacto = binder.getBean();
	    try {
			servicioContacto.save(contacto);
			vistaPrincipal.updateList();
		    setContacto(null);
		} catch (IOException e) {
			Notification.show("Error al guardar los datos.","Los cambios realizados podrían perderse.", Notification.Type.HUMANIZED_MESSAGE);
		}
	    
	}
	
	private void eliminar() {
	    Contacto contacto = binder.getBean();
	    try {
			servicioContacto.delete(contacto);
			vistaPrincipal.updateList();
		    setContacto(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Notification.show("Error al guardar el borrado de los datos.","Los cambios realizados podrían perderse.", Notification.Type.HUMANIZED_MESSAGE);
		}
	    
	}

	public void deshabilitarEliminar() 
	{
		this.delete.setEnabled(false);	
	}

	public void habilitarEliminar() 
	{
		this.delete.setEnabled(true);
	}

}
