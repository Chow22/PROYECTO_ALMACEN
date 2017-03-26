package vista;


import controlador.ControladorArticulo;



public class Main {

	public static void main(String[] args) {

		// Crear controladores como variables locales del main

		ControladorArticulo controladorArticulo = new ControladorArticulo();

		Principal principal = new Principal();
		principal.setControladorArticulo(controladorArticulo);
		// Crear ventanas como variables locales del main
		GestionArticulo gestionArticulo = new GestionArticulo(principal, true);
		gestionArticulo.setControladorArticulo(controladorArticulo);

		NuevoArticulo nuevoArticulo = new NuevoArticulo(gestionArticulo, true);
		nuevoArticulo.setControladorArticulo(controladorArticulo);

		BorrarArticulo borrarArticulo = new BorrarArticulo(gestionArticulo, true);
		borrarArticulo.setControladorArticulo(controladorArticulo);
		
		//abrir la ventana principal
		principal.setVisible(true);
	}

}
