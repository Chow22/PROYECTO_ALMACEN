package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ModeloCliente extends Conectar {

	public ModeloCliente() {
		super();
	}

	public ArrayList<Cliente> seleccionarTodos() {

		Statement st;
		try {
			st = cn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM SOCIOS ");

			// pasar de ResultSet a ArrayList

			ArrayList<Cliente> clientes = new ArrayList<Cliente>();

			while (rs.next()) {

				Cliente cliente = new Cliente();
				cliente.setId(rs.getString(1));
				cliente.setNombre(rs.getString(2));
				cliente.setDireccion(rs.getString(3));
				cliente.setCodPostal(rs.getString(4));
				cliente.setTelefono(rs.getString(5));
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void insertar(Cliente cliente) throws Exception {

		PreparedStatement pst;
		try {
			pst = cn.prepareStatement(
					"INSERT INTO SOCIOS(nombre,apellido,direccion," + "poblacion,provincia,dni) VALUES (?,?,?,?,?,?)");

			pst.setString(1, cliente.getNombre());
			pst.setString(2, cliente.getDireccion());
			pst.setString(3, cliente.getCodPostal());
			pst.setString(4, cliente.getTelefono());

			System.out.println(pst);
			pst.execute();
			System.out.println("Alumno insertado correctamente");
		} catch (Exception e) {
			throw e;
		}

	}

	public void borrar(int id) {

		try {
			PreparedStatement pst = cn.prepareStatement("DELETE FROM clientes WHERE id = ?");
			pst.setInt(1, id);
			pst.execute();// ejecuta
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int modificar(Cliente cliente) {
		int lineascambiadas;
		try {
			Statement st = super.cn.createStatement();
			lineascambiadas = st.executeUpdate("UPDATE clientes " + "SET nombre='" + cliente.getNombre() + "'"
					+ ",direccion='" + cliente.getDireccion() + "'" + ",codpostal='" + cliente.getCodPostal() + "'"
					+ ",telefono='" + cliente.getTelefono() + "'" + " WHERE id=" + cliente.getId());
			return lineascambiadas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public ArrayList<Cliente> seleccionarDni(String dni) throws Exception {

		PreparedStatement pst;
		try {
			pst = cn.prepareStatement("SELECT * FROM clientes WHERE DNI=?");

			pst.setString(1, dni);

			System.out.println(pst);

			ResultSet rs = pst.executeQuery();

			ArrayList<Cliente> clientes = new ArrayList<Cliente>();

			// Solo hay 1 registro para rescatar

			rs.next();
	
			Cliente cliente = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5));

			clientes.add(cliente);
			return clientes;

		} catch (Exception e) {
			throw e;
		}
	}

	public String seleccionarId(String id) throws Exception {
		try {

			PreparedStatement pst = cn.prepareStatement("SELECT NOMBRE,DIRECCION FROM clientes WHERE id = ?");
			pst.setString(1, id);

			// System.out.println(pst);

			ResultSet rs = pst.executeQuery();// ejecuta
			String nomDirecc = "";

			while (rs.next()) {
				nomDirecc = rs.getString(1) + " " + rs.getString(2);
			}

			return nomDirecc;

		} catch (Exception ex) {
			throw ex;
		}
	}

	public String seleccionarPorNombre(String nombre, String direccion) throws Exception {

		try {

			PreparedStatement pst = cn.prepareStatement("SELECT ID from clientes WHERE nombre = ? and direccion=?");

			pst.setString(1, nombre);
			pst.setString(2, direccion);

			// System.out.println(pst);

			ResultSet rs = pst.executeQuery();// ejecuta
			String id = null;

			while (rs.next()) {
				id = rs.getString(1);
			}
			return id;

		} catch (Exception ex) {
			throw ex;
		}

	}

	public Cliente select(String idSocio) {
		PreparedStatement ps;
		Cliente cliente;
		try {
			ps = cn.prepareStatement("select * from clientes where id = ?");
			ps.setString(1, idSocio);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getString(1));
				cliente.setNombre(rs.getString(2));
				cliente.setDireccion(rs.getString(3));
				cliente.setCodPostal(rs.getString(4));
				cliente.setTelefono(rs.getString(5));
				return cliente;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<Cliente> selectLikeNombre(String nombre) {
		PreparedStatement pst;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			
			pst = super.cn.prepareStatement("select * from clientes where nombre like ?");
			pst.setString(1, "%" + nombre + "%");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));

				clientes.add(cliente);
			}
			return clientes;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	public ArrayList<Cliente> selectLikeApellido(String apellido) {
		PreparedStatement pst;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			pst = super.cn.prepareStatement("select * from clientes where apellido like ?");
			pst.setString(1, "%" + apellido + "%");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));

				clientes.add(cliente);
			}
			return clientes;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	public ArrayList<Cliente> selectPorDireccion(String direccion) {
		PreparedStatement pst;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			pst = super.cn.prepareStatement("select * from clientes where direccion = ?");
			pst.setString(1, direccion);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));

				clientes.add(cliente);
			}
			return clientes;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	public ArrayList<Cliente> selectPorPoblacion(String poblacion) {
		PreparedStatement pst;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			pst = super.cn.prepareStatement("select * from clientes where poblacion = ?");
			pst.setString(1, poblacion);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));

				clientes.add(cliente);
			}
			return clientes;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientes;
	}

	public ArrayList<Cliente> selectPorProvincia(String provincia) {
		PreparedStatement pst;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			pst = super.cn.prepareStatement("select * from clientes where provincia = ?");
			pst.setString(1, provincia);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));

				clientes.add(cliente);
			}
			return clientes;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}

	public ArrayList<String> selectDirecciones() {
		ArrayList<String> direcciones = new ArrayList<String>();
		try {
			Statement st = super.cn.createStatement();
			ResultSet rs = st.executeQuery("select distinct direccion from clientes");

			while (rs.next()) {
				direcciones.add(rs.getString(1));
			}
			return direcciones;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return direcciones;
	}
	
	public ArrayList<String> selectPoblaciones() {
		ArrayList<String> poblaciones = new ArrayList<String>();
		try {
			Statement st = super.cn.createStatement();
			ResultSet rs = st.executeQuery("select distinct poblacion from clientes");

			while (rs.next()) {
				poblaciones.add(rs.getString(1));
			}
			return poblaciones;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return poblaciones;
	}
	
	public ArrayList<String> selectProvincias() {
		ArrayList<String> provincias = new ArrayList<String>();
		try {
			Statement st = super.cn.createStatement();
			ResultSet rs = st.executeQuery("select distinct provincia from clientes");

			while (rs.next()) {
				provincias.add(rs.getString(1));
			}
			return provincias;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provincias;
	}

}
