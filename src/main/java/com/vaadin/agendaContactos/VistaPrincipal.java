package com.vaadin.agendaContactos;

import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.Backend.Contacto;
import com.vaadin.Backend.ServicioContacto;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import com.vaadin.shared.ui.ValueChangeMode;


/**
 * The main view contains a text field to get the user name and a button
 * that shows a greeting message in a notification.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class VistaPrincipal extends VerticalLayout {

	    private ServicioContacto service = ServicioContacto.getInstance();
	    private Grid<Contacto> grid = new Grid<>(Contacto.class);
	    private TextField filterText = new TextField();
	    private FormularioContacto formContacto = new FormularioContacto(this);

	public VistaPrincipal() {
		
		filterText.setPlaceholder("Filtrar por nombre...");
	    filterText.setValueChangeMode(ValueChangeMode.EAGER);
	    filterText.addValueChangeListener(e -> updateList());
	    
	    Button addCustomerBtn = new Button("Añadir nuevo contacto");
	    addCustomerBtn.addClickListener(e -> {
	    	grid.asSingleSelect().clear();
	    	formContacto.setContacto(new Contacto());
	    	formContacto.deshabilitarEliminar();
	    	});
	    
	    HorizontalLayout toolbar = new HorizontalLayout(filterText,addCustomerBtn);
	    
	    
		grid.setColumns("nombre", "apellidos", "empresa", "email", "telefonoContacto", "direccion");
		
		HorizontalLayout mainContent = new HorizontalLayout(grid, formContacto);
        mainContent.setSizeFull();
        grid.setSizeFull();

        addComponents(toolbar, mainContent);
        
        updateList();
        
        formContacto.setContacto(null);
        grid.asSingleSelect().addValueChangeListener(event -> {
        	formContacto.setContacto(grid.asSingleSelect().getValue());
        	formContacto.habilitarEliminar();
        });
	}
	
	public void updateList() {
		grid.setItems(service.findAll(filterText.getValue()));
    }

}
