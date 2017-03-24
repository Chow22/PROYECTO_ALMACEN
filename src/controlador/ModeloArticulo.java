package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import modelo.Conectar;

public class ModeloArticulo extends Conectar {
	
	
	
	
	Scanner scan = new Scanner(System.in);

	public ModeloArticulo() {
		super();
	}

	public ArrayList<Articulo> seleccionarNombres() throws Exception {

		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("SELECT titulo FROM ArticuloS ");
		//pasar de ResultSet a ArrayList
		
		ArrayList<Articulo> Articulos=new ArrayList<Articulo>();
		while (rs.next()){
			Articulo Articulo=new Articulo();
			Articulo.setNombre(rs.getString(1));
			
			Articulos.add(Articulo);
		}
		return Articulos;
	}

	public void insertar(Articulo articulo) throws SQLException {
		// escribir la instruccion INSERT
		try {

			PreparedStatement pst = cn.prepareStatement("INSERT INTO ArticuloS (nombre, proveedor, precio, existencias) VALUES (?,?,?,?)");
			
			System.out.println(pst);
			
			pst.setString(1, articulo.getNombre());
			pst.setString(2, articulo.getProveedor());
			pst.setDouble(3, articulo.getPrecio());
			pst.setInt(4, articulo.getExistencias());

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
		String titulo="";
		try {
			pst = cn.prepareStatement("SELECT TITULO FROM ArticuloS WHERE id=?");
			pst.setInt(1, id_Articulo);

			ResultSet rs = pst.executeQuery();// ejecuta

			while (rs.next()) { // coge el titulo que es UNO SOLO

				titulo = rs.getString(1);
			}
			return titulo;
			
		} catch (Exception e) {
			throw e;

		} 
	}

	public Articulo seleccionarDatosArticulo(String titulo) throws Exception {
		PreparedStatement pst;
		Articulo Articulo=new Articulo();

		try {
			pst = cn.prepareStatement("SELECT * FROM ArticuloS WHERE titulo=?");
			pst.setString(1, titulo);

			ResultSet rs = pst.executeQuery();// ejecuta

			while (rs.next()) { // coge el titulo que es UNO SOLO
				
				Articulo.setId(rs.getInt(1));
				Articulo.setNombre(rs.getString(2));
				Articulo.setProveedor(rs.getString(3));
				Articulo.setPrecio(rs.getDouble(4));
				Articulo.setExistencias(rs.getInt(5));
			}
			return Articulo;
			
		} catch (Exception e) {
			throw e;

		} 
	}

	public void borrarArticulo(String titulo) throws Exception {
		
		PreparedStatement pst;
		
		
		try {
			pst = cn.prepareStatement("DELETE FROM ArticuloS WHERE TITULO=?");
			pst.setString(1, titulo);
			
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
		Articulo Articulo;
		
		try {
			pst = cn.prepareStatement("SELECT * FROM ArticuloS ");
			
			ResultSet rs = pst.executeQuery();// ejecuta

			//pasar de ResultSet a ArrayList

			ArrayList<Articulo> Articulos=new ArrayList<Articulo>();
			while (rs.next()){
				Articulo=new Articulo();
				Articulo.setId(Integer.parseInt(rs.getString(1)));
				Articulo.setNombre(rs.getString(2));
				Articulo.setProveedor(rs.getString(3));
				Articulo.setPrecio(Double.parseDouble(rs.getString(4)));
				Articulo.setExistencias(Integer.parseInt(rs.getString(4)));
				//System.out.println(Articulo.getTitulo());
				Articulos.add(Articulo);
			}
			return Articulos;
			
		} catch (Exception e) {
			throw e;

		} 
	}
}
