package controlador;

import modelo.Cliente;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.ModeloCliente;
import vista.Principal;
import vista.cliente.FormularioDeBusquedaCliente;
import vista.cliente.FormularioDeBorrado;
import vista.cliente.FormularioDeModificado;
import vista.cliente.FormularioTodosClientes;
import vista.cliente.FormularioCliente;
import vista.cliente.GestionCliente;

public class ControladorCliente {

	// un atributo por cada ventana de Cliente
	// un atributo para el modelo Cliente

	private ModeloCliente modeloCliente;

	private GestionCliente gestionCliente;
	private Principal principal;
	private FormularioCliente formularioCliente;
	private FormularioDeBusquedaCliente formularioBusquedaCliente;
	private FormularioDeBorrado formularioDeBorrado;
	private FormularioDeModificado formDeModificado;
	private FormularioTodosClientes formTodosClientes;


	public FormularioTodosClientes getFormTodosClientes() {
		return formTodosClientes;
	}

	public void setFormTodosClientes(FormularioTodosClientes formTodosClientes) {
		this.formTodosClientes = formTodosClientes;
	}


	public FormularioDeBusquedaCliente getFormularioBusquedaCliente() {
		return formularioBusquedaCliente;
	}

	public void setFormularioBusquedaCliente(FormularioDeBusquedaCliente formularioBusquedaCliente) {
		this.formularioBusquedaCliente = formularioBusquedaCliente;
	}

	public FormularioDeModificado getFormDeModificado() {
		return formDeModificado;
	}

	public void setFormDeModificado(FormularioDeModificado formDeModificado) {
		this.formDeModificado = formDeModificado;
	}

	/**
	 * cliente bat sortu eta modeloari insert egiteko esaten dio
	 * 
	 * @param nombre
	 *            nombre del cliente
	 * @param apellido
	 *            apellido del cliente
	 * @param direccion
	 *            direccion del cliente
	 * @param string 
	 * @param poblacion
	 *            poblacion del cliente
	 * @param provincia
	 *            provincia del cliente
	 * @param dni
	 *            dni del cliente
	 * 
	 */

	public void insertarCliente(String id,String nombre, String direccion, String codPostal, String telefono, String string) {

		Cliente cliente = new Cliente();

		cliente.setId(id);
		cliente.setNombre(nombre);
		cliente.setDireccion(direccion);
		cliente.setCodPostal(codPostal);
		cliente.setTelefono(telefono);

		try {
			this.modeloCliente.insertar(cliente);

			JOptionPane.showMessageDialog(null, "CLIENTE INSERTADO EN LA BD");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR CLIENTE");
		}
	}

	public void abrirGestionCliente() {
		this.gestionCliente.setVisible(true);
	}

	public void abrirFormularioCliente() {
		this.formularioCliente.setVisible(true);
	}

	public void abrirBusquedaCliente() {
		// ArrayList<String> direcciones = this.modeloCliente.selectDirecciones();
		ArrayList<String> pueblos = this.modeloCliente.selectPoblaciones();
		ArrayList<String> provincias = this.modeloCliente.selectProvincias();

		// this.formularioBusquedaCliente.rellenarComboDireccion(direcciones);
		this.formularioBusquedaCliente.rellenarComboPoblacion(pueblos);
		this.formularioBusquedaCliente.rellenarComboProvincia(provincias);

		this.formularioBusquedaCliente.setVisible(true);

	}

	// borrado de cliente
	public void abrirFormDeBorrado() {
		ArrayList<Cliente> clientes = this.modeloCliente.seleccionarTodos();

		this.formularioDeBorrado.rellenarComboClientes(clientes);
		this.formularioDeBorrado.setVisible(true);
	}

	public void abrirFormDeModificar() {
		ArrayList<Cliente> clientes = this.modeloCliente.seleccionarTodos();

		this.formDeModificado.rellenarComboClientes(clientes);
		this.formDeModificado.setVisible(true);
	}

	public void rellenarFormDeBorrado(String idCliente) {
		Cliente cliente = this.modeloCliente.select(idCliente);
		this.formularioDeBorrado.rellenarFormulario(cliente);
	}

	public void rellenarFormDeModificado(String idCliente) {
		Cliente cliente = this.modeloCliente.select(idCliente);
		this.formDeModificado.rellenarFormulario(cliente);
	}

	public void eliminarCliente(String string) {
		this.modeloCliente.borrar(string);
		this.formularioDeBorrado.mostrarMensaje("Cliente destruido con exito");
		this.formularioDeBorrado.clearForm();

		// actualizar formulario
		ArrayList<Cliente> clientes = this.modeloCliente.seleccionarTodos();
		this.formularioDeBorrado.rellenarComboClientes(clientes);
	}

	public void cerrarFormularioDeBorrado() {
		this.formularioDeBorrado.clearForm();
		this.formularioDeBorrado.dispose();
	}
	// borrado de cliente FIN

	public void cerrarFormularioDeModificado() {
		this.formDeModificado.clear();
		this.formDeModificado.dispose();
	}

	public ModeloCliente getModeloCliente() {
		return modeloCliente;
	}

	public void setModeloCliente(ModeloCliente modeloCliente) {
		this.modeloCliente = modeloCliente;
	}

	public GestionCliente getGestionCliente() {
		return gestionCliente;
	}

	public void setGestionCliente(GestionCliente gestionCliente) {
		this.gestionCliente = gestionCliente;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public FormularioCliente getFormularioCliente() {
		return formularioCliente;
	}

	public void setFormularioCliente(FormularioCliente formularioCliente) {
		this.formularioCliente = formularioCliente;
	}

	public FormularioDeBorrado getFormularioDeBorrado() {
		return formularioDeBorrado;
	}

	public void setFormularioDeBorrado(FormularioDeBorrado formularioDeBorrado) {
		this.formularioDeBorrado = formularioDeBorrado;
	}

	public void cerrarFormularioCliente() {
		this.formularioCliente.clear();
		this.formularioCliente.dispose();
	}

	public void modificarCliente(String id, String nombre,String direccion, String codPostal,
			String telefono) {
		Cliente cliente = new Cliente();

		cliente.setNombre(nombre);
		cliente.setDireccion(direccion);
		cliente.setCodPostal(codPostal);
		cliente.setTelefono(telefono);

		this.modeloCliente.modificar(cliente);
	}


	public void abrirFormListar() {
		
		ArrayList<Cliente> clientes=new ArrayList<Cliente>(); 
		
		clientes=modeloCliente.seleccionarTodos();
		
		formTodosClientes.rellenarTabla(clientes);
		
		formTodosClientes.setVisible(true);
		
}
	public void mostrarClientesPorNombre(String nombre) {
		ArrayList<Cliente> clientes = this.modeloCliente.selectLikeNombre(nombre);
		this.formularioBusquedaCliente.rellenarTabla(clientes);
	}

	public void mostrarClientesPorApellido(String apellido) {
		ArrayList<Cliente> clientes = this.modeloCliente.selectLikeApellido(apellido);
		this.formularioBusquedaCliente.rellenarTabla(clientes);
	}

	public void mostrarClientesPorDireccion(String direccion) {
		ArrayList<Cliente> clientes = this.modeloCliente.selectPorDireccion(direccion);
		this.formularioBusquedaCliente.rellenarTabla(clientes);
	}

	public void mostrarClientesPorPoblacion(String poblacion) {
		ArrayList<Cliente> clientes = this.modeloCliente.selectPorPoblacion(poblacion);
		this.formularioBusquedaCliente.rellenarTabla(clientes);
	}

	public void mostrarClientesPorProvincia(String provincia) {
		ArrayList<Cliente> clientes = this.modeloCliente.selectPorProvincia(provincia);
		this.formularioBusquedaCliente.rellenarTabla(clientes);

	}

	

}
