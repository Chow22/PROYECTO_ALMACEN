package vista;

import controlador.ControladorArticulo;
import controlador.ControladorCliente;
import modelo.ModeloArticulo;
import modelo.ModeloCliente;
import vista.cliente.FormularioCliente;
import vista.cliente.FormularioDeBorrado;
import vista.cliente.FormularioDeBusquedaCliente;
import vista.cliente.FormularioDeModificado;
import vista.cliente.FormularioTodosClientes;
import vista.cliente.GestionCliente;


public class Main {

	public static void main(String[] args) {

		// Crear controladores como variables locales del main

		ControladorArticulo controladorArticulo = new ControladorArticulo();
		ControladorCliente controladorCliente = new ControladorCliente();

		ModeloArticulo modeloArticulo = new ModeloArticulo();
		ModeloCliente modeloCliente = new ModeloCliente();
		// ModeloPedido modeloPedido = new ModeloPedido();

		Principal principal = new Principal();
		principal.setControladorArticulo(controladorArticulo);;
		principal.setControladorCliente(controladorCliente);
		//principal.setControladorPrestamo(controladorPrestamo);
		
		
		// Crear ventanas como variables locales del main
		GestionArticulo gestionArticulo = new GestionArticulo(principal, true);
		gestionArticulo.setControladorArticulo(controladorArticulo);

		NuevoArticulo nuevoArticulo = new NuevoArticulo(gestionArticulo, true);
		nuevoArticulo.setControladorArticulo(controladorArticulo);

		BorrarArticulo borrarArticulo = new BorrarArticulo(gestionArticulo, true);
		borrarArticulo.setControladorArticulo(controladorArticulo);

		ConsultarArticulo consultarArticulo = new ConsultarArticulo(gestionArticulo, true);
		consultarArticulo.setControladorArticulo(controladorArticulo);

		// rellenar controlador articulo
		controladorArticulo.setNuevoArticulo(nuevoArticulo);
		controladorArticulo.setBorrarArticulo(borrarArticulo);
		controladorArticulo.setConsultarArticulo(consultarArticulo);
		controladorArticulo.setGestionArticulo(gestionArticulo);
		controladorArticulo.setModeloArticulo(modeloArticulo);
		
		// Cliente
				//creacion de ventanas de la gestion de clientes y asignar controladores
				GestionCliente gestionCliente = new GestionCliente(principal, true);
				gestionCliente.setControladorCliente(controladorCliente);
				
				FormularioDeBorrado formularioDeBorrado = new FormularioDeBorrado(gestionCliente, true);
				formularioDeBorrado.setControladorCliente(controladorCliente);
				
				FormularioCliente formularioCliente = new FormularioCliente(gestionCliente, true);
				formularioCliente.setControladorCliente(controladorCliente);
				
				FormularioDeModificado formularioDeModificado = new FormularioDeModificado(gestionCliente, true);
				formularioDeModificado.setControladorCliente(controladorCliente);
				
				FormularioDeBusquedaCliente formularioDeBusqueda = new FormularioDeBusquedaCliente(gestionCliente, true);
				formularioDeBusqueda.setControladorCliente(controladorCliente);
				
				FormularioTodosClientes formularioTodosClientes = new FormularioTodosClientes(gestionCliente, true);
				formularioTodosClientes.setControladorCliente(controladorCliente);
				
				
				//rellenar controladorCliente
				controladorCliente.setModeloCliente(modeloCliente);
				controladorCliente.setGestionCliente(gestionCliente);
				controladorCliente.setFormularioDeBorrado(formularioDeBorrado);
				controladorCliente.setFormularioCliente(formularioCliente);
				controladorCliente.setFormDeModificado(formularioDeModificado);
				controladorCliente.setFormTodosClientes(formularioTodosClientes);
				
				//prueba de formulario de busquedas
				controladorCliente.setFormularioBusquedaCliente(formularioDeBusqueda);
				
		
		// abrir la ventana principal
		principal.setVisible(true);
	}

}
