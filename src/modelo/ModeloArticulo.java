package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ModeloArticulo extends Conectar {
	
	
	
	
	Scanner scan = new Scanner(System.in);

	public ModeloArticulo() {
		super();
	}

	public ArrayList<Articulo> seleccionarNombres() throws Exception {

		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("SELECT nombre FROM ARTICULOS ");
		//pasar de ResultSet a ArrayList
		
		ArrayList<Articulo> articulos=new ArrayList<Articulo>();
		while (rs.next()){
			Articulo articulo=new Articulo();
			articulo.setNombre(rs.getString(1));
			
			articulos.add(articulo);
		}
		return articulos;
	}

	public void insertar(Articulo articulo) throws SQLException {
		// escribir la instruccion INSERT
		try {

			PreparedStatement pst = cn.prepareStatement("INSERT INTO ARTICULOS (nombre, proveedor, precio, existencias) VALUES (?,?,?,?)");
			
			
			
			pst.setString(1, articulo.getNombre());
			pst.setString(2, articulo.getProveedor());
			pst.setDouble(3, articulo.getPrecio());
			pst.setInt(4, articulo.getExistencias());
			System.out.println(pst);
			pst.execute();// ejecuta
			System.out.println("Articulo insertado correctamente");
		} catch (SQLException ex) {
			throw ex;

		}
	}

	public void borrar(int id) throws Exception {
		try {
			System.out.println("\n\t\tBorrar Articulo por id");
			System.out.println("\t\tId: ");
			id = (Integer.parseInt(scan.nextLine()));

			PreparedStatement pst = cn.prepareStatement("DELETE FROM Articulos WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();// ejecuta

			if (pst.getUpdateCount() == 0) {// no a borrado nada
				System.out.println("Articulo no existe");
			} else {
				System.out.println("Articulo borrado correctamente");
			}

		} catch (SQLException ex) {
			throw ex;
		}
	}

	public void modificar(int id, String nueva_direccion) throws Exception {
		try {

			PreparedStatement pst = cn.prepareStatement("UPDATE socios SET direccion=? WHERE id=?");

			pst.setString(1, nueva_direccion);
			pst.setInt(2, id);

			pst.execute();// ejecuta

			System.out.println("Direccion del Articulo " + id + " modificado exitosisimamente");
		} catch (Exception ex) {
			throw ex;

		}

	}

	public String seleccionarId(int id_Articulo) throws Exception {

		PreparedStatement pst;
		String nombre="";
		try {
			pst = cn.prepareStatement("SELECT TITULO FROM articulos WHERE id=?");
			pst.setInt(1, id_Articulo);

			ResultSet rs = pst.executeQuery();// ejecuta

			while (rs.next()) { // coge el nombre que es UNO SOLO

				nombre = rs.getString(1);
			}
			return nombre;
			
		} catch (Exception e) {
			throw e;

		} 
	}

	public Articulo seleccionarDatosArticulo(String nombre) throws Exception {
		PreparedStatement pst;
		Articulo articulo=new Articulo();

		try {
			pst = cn.prepareStatement("SELECT * FROM ArticuloS WHERE nombre=?");
			pst.setString(1, nombre);

			ResultSet rs = pst.executeQuery();// ejecuta

			while (rs.next()) { // coge el nombre que es UNO SOLO
				
				articulo.setId(rs.getInt(1));
				articulo.setNombre(rs.getString(2));
				articulo.setProveedor(rs.getString(3));
				articulo.setPrecio(rs.getDouble(4));
				articulo.setExistencias(rs.getInt(5));
			}
			return articulo;
			
		} catch (Exception e) {
			throw e;

		} 
	}

	public void borrarArticulo(String nombre) throws Exception {
		
		PreparedStatement pst;
		
		
		try {
			pst = cn.prepareStatement("DELETE FROM articulos WHERE nombre=?");
			pst.setString(1, nombre);
			
			int count=pst.executeUpdate();
			System.out.println(pst +"  "+ count);
			
			if (count>=1){
				JOptionPane.showMessageDialog(null, "Articulo BORRADO");
			} else {
				JOptionPane.showMessageDialog(null, "Articulo NO EXISTE");
			}
			
		} catch (Exception e) {
			throw e;

		} 
		
	}

	public ArrayList<Articulo> seleccionarTodos() throws Exception {
		PreparedStatement pst;
		Articulo articulo;
		
		try {
			pst = cn.prepareStatement("SELECT * FROM ARTICULOS ");
			
			ResultSet rs = pst.executeQuery();// ejecuta

			//pasar de ResultSet a ArrayList

			ArrayList<Articulo> articulos=new ArrayList<Articulo>();
			while (rs.next()){
				articulo=new Articulo();
				articulo.setId(Integer.parseInt(rs.getString(1)));
				articulo.setNombre(rs.getString(2));
				articulo.setProveedor(rs.getString(3));
				articulo.setPrecio(Double.parseDouble(rs.getString(4)));
				articulo.setExistencias(Integer.parseInt(rs.getString(5)));
				articulos.add(articulo);
			}
			return articulos;
			
		} catch (Exception e) {
			throw e;

		} 
	}
}
