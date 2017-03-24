package vista;

import controlador.ControladorCliente;
import controlador.ControladorPedidos;
import controlador.ModeloArticulo;
import controlador.ModeloCliente;
import controlador.ControladorArticulo;

public class Main {

	public static void main(String[] args) {

		// Crear controladores como variables locales del main

		ControladorArticulo controladorArticulo = new ControladorArticulo();
		ControladorCliente controladorCliente = new ControladorCliente();


		ModeloArticulo modeloLibro = new ModeloArticulo();
		ModeloCliente modeloSocio = new ModeloCliente();


		Principal principal = new Principal();
		principal.setControladorArticulo(controladorArticulo);
		principal.setControladorCliente(controladorCliente);


//		// LIBRO
//		// Crear ventanas como variables locales del main
//		GestionLibro gestionLibro = new GestionLibro(principal, true);
//		gestionLibro.setControladorLibro(controladorLibro);
//
//		NuevoLibro nuevoLibro = new NuevoLibro(gestionLibro, true);
//		nuevoLibro.setControladorLibro(controladorLibro);
//
//		BorrarLibro borrarLibro = new BorrarLibro(gestionLibro, true);
//		borrarLibro.setControladorLibro(controladorLibro);
//		
//		ConsultarLibro consultarLibro = new ConsultarLibro(gestionLibro, true);
//		//consultarLibro.setControladorLibro(controladorLibro);
//		
//		ListarLibros listarLibros = new ListarLibros(gestionLibro, true);
//		//listarLibros.setControladorLibro(controladorLibro);
//		
//		
//		controladorLibro.setNuevoLibro(nuevoLibro);
//		controladorLibro.setBorrarLibro(borrarLibro);
//		controladorLibro.setConsultarLibro(consultarLibro);
//		controladorLibro.setGestionLibro(gestionLibro);
//		controladorLibro.setListarLibros(listarLibros);
//		controladorLibro.setModeloLibro(modeloLibro);

		// SOCIO
		// Crear ventanas como variables locales del main
		

		//creacion de ventanas de la gestion de socios y asignar controladores
//		GestionSocio gestionSocio = new GestionSocio(principal, true);
//		gestionSocio.setControladorSocio(controladorSocio);
//		
//		FormularioDeBorrado formularioDeBorrado = new FormularioDeBorrado(gestionSocio, true);
//		formularioDeBorrado.setControladorSocio(controladorSocio);
//		
//		FormularioSocio formularioSocio = new FormularioSocio(gestionSocio, true);
//		formularioSocio.setControladorSocio(controladorSocio);
//		
//		FormularioDeModificado formularioDeModificado = new FormularioDeModificado(gestionSocio, true);
//		formularioDeModificado.setControladorSocio(controladorSocio);
//		
//		FormularioDeBusquedaSocio formularioDeBusqueda = new FormularioDeBusquedaSocio(gestionSocio, true);
//		formularioDeBusqueda.setControladorSocio(controladorSocio);
//		
//		FormularioTodosSocios formularioTodosSocios = new FormularioTodosSocios(gestionSocio, true);
//		formularioTodosSocios.setControladorSocio(controladorSocio);
//		
//		
//		//rellenar controladorSocio
//		controladorSocio.setModeloSocio(modeloSocio);
//		controladorSocio.setGestionSocio(gestionSocio);
//		controladorSocio.setFormularioDeBorrado(formularioDeBorrado);
//		controladorSocio.setFormularioSocio(formularioSocio);
//		controladorSocio.setFormDeModificado(formularioDeModificado);
//		controladorSocio.setFormTodosSocios(formularioTodosSocios);
//		//prueba de formulario de busqueda
//		controladorSocio.setFormularioBusquedaSocio(formularioDeBusqueda);
//		
//		//abrir la ventana principal
//		principal.setVisible(true);

	}

}
