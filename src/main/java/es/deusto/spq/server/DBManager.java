package es.deusto.spq.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Habitacion;

public class DBManager {
	private static DBManager instance = null;
	private static PersistenceManagerFactory pmf = null;
	private static boolean inicializado = false;
	private static Connection conn;
	
	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	/**
	 * Método para obtener la instancia del DBManager. En caso de no existir la crea
	 * Si ya existe la devuelve
	 *
	 * @return la instancia de DBManager
	 */
	public static DBManager getInstance() {
//		if (instance == null) {
		instance = new DBManager();
//			System.out.println("Nuevo DBManager");
//		}
		if(!inicializado) {
			inicializado = true;
			instance.deleteData();
			instance.initializeData();
			
	}

		return instance;
	}
	
	public void deleteData() {
		deleteClientes();
		
	}
	
	public void storeObjectInDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		

		try {
			tx.begin();
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error storing an object: " + ex.getMessage());
			System.out.println("Object:" + object);
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
		
	public void deleteObjectFromDB(Object object) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			
			pm.deletePersistent(object);
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error deleting an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		}

	public void store(Cliente client) {
		try {
			DBManager.getInstance().storeObjectInDB(client);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void delete(Cliente client) {
		try {
			DBManager.getInstance().deleteObjectFromDB(client);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public void store(Habitacion h) {
		DBManager.getInstance().storeObjectInDB(h);
	}

	public void delete(Habitacion h) {
		DBManager.getInstance().deleteObjectFromDB(h);
	}

	public void update(Cliente client) {
		Cliente user2 = getUsuario(client.getEmail());
		if (user2 != null) {
			System.out.println(user2.getNombre() + user2.getApellido() + user2.getEmail());
			delete(user2);
			store(client);
		}
	}

	public static Cliente getUsuario(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Cliente user = null;

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM " + Cliente.class.getName() + " WHERE email == '" + email + "'");
			query.setUnique(true);
			user = (Cliente) query.execute();

			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo el usuario de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return user;	
	}

	public static ArrayList<Cliente> seleccionaUsuarioBD() {
		ArrayList<Cliente> cl = new ArrayList<Cliente>();
		
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM CLIENTE"); 
			ResultSet rs = pst.executeQuery();	
			String dni;
			String nombre;
			String apellido;
			String email;
			String contrasenya;
			boolean esAdmin;	
			
			
			while(rs.next()) {
				dni = rs.getString("DNI");
				nombre = rs.getString("NOMBRE");
				apellido = rs.getString("APELLIDO");
				email = rs.getString("EMAIL");
				contrasenya= rs.getString("CONTRASENYA");
				esAdmin = rs.getBoolean("ESADMIN");
				Cliente c = new Cliente(dni, nombre, apellido, email, contrasenya, esAdmin);
				
				cl.add(c);
			}
			rs.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}

		return cl;
	}
	
	public List<Cliente> getClientes() {
		List<Cliente> usuarios = new ArrayList<Cliente>();
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			Extent<Cliente> extent = pm.getExtent(Cliente.class, true);

			for (Cliente usuario : extent) {
				usuarios.add(usuario);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarios;
	}

	public void deleteClientes() {
		List<Cliente> usuarios = new ArrayList<Cliente>();
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();

		try {

			tx.begin();

			Extent<Cliente> extent = pm.getExtent(Cliente.class, true);

			for (Cliente usuario : extent) {
				pm.deletePersistent(usuario);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all the Categories: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

	}
	
	public void actualizarDatosCliente(String dni, String nombre, String apellido, String password, String correo) {
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE CLIENTE SET NOMBRE=?, APELLIDO=?, EMAIL=? , CONTRASENYA=? WHERE DNI=?;"); 
			
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setString(3, password);
			pst.setString(4, correo);
			
			pst.setString(5, dni);
			pst.executeUpdate();
						
						
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void anadirHabitaciones(List<Habitacion> habitaciones) {
		PreparedStatement preparedStatement = null;

	        try {
	            
	        	for (Habitacion h : habitaciones) {
	        		String query = " INSERT INTO HABITACION (CODIGO, NUMCAMAS, PRECIO, OCUPADA)"
		                    + " VALUES (?, ?, ?, ?)";

		            preparedStatement = conn.prepareStatement(query);

		            preparedStatement.setString(1, h.getCodigo());
		            preparedStatement.setInt(2, h.getNumCamas());
		            preparedStatement.setDouble(3, h.getPrecio());
		            preparedStatement.setBoolean(4, h.isOcupada());
		            preparedStatement.execute();

		            System.out.println("OperaciÃ³n existosa");
				}
	        	

	        } catch (Exception e) {
	            System.out.println("A ocurrido un ERROR");
	            System.out.println(e);
	        }
	}
	
	public void anadirCliente(List<Cliente> clientes) {
		PreparedStatement preparedStatement = null;

	        try {
	            
	        	for (Cliente c : clientes) {
	        		String query = " INSERT INTO CLIENTE (DNI, NOMBRE, APELLIDO, EMAIL, CONTRASENYA, ESADMIN)"
		                    + " VALUES (?, ?, ?, ?)";

		            preparedStatement = conn.prepareStatement(query);

		            preparedStatement.setString(1, c.getDNI());
		            preparedStatement.setString(2, c.getNombre());
		            preparedStatement.setString(3, c.getApellido());
		            preparedStatement.setString(3, c.getEmail());
		            preparedStatement.setString(3, c.getContrasenya());
		            preparedStatement.setBoolean(4, c.isEsAdmin());
		            preparedStatement.execute();

		            System.out.println("OperaciÃ³n existosa");
				}
	        	

	        } catch (Exception e) {
	            System.out.println("A ocurrido un ERROR");
	            System.out.println(e);
	        }
	}

	public Habitacion getHabitacion(String codigo) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(4);
		Transaction tx = pm.currentTransaction();
		Habitacion h = null;

		try {
			tx.begin();

			Query<?> query = pm.newQuery("SELECT FROM Habitacion WHERE codigo == '" + codigo + "'");
			query.setUnique(true);
			h = (Habitacion) query.execute();

			tx.commit();
		} catch (Exception ex) {
			System.out.println(" $ Error cogiendo la habitacion de la BD: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return h;
	}
	
	public void initializeData() {
		System.out.println(" * Initializing data base");
		List<Habitacion> habitaciones = new ArrayList<Habitacion>();
		
		//Habitacion h1 = new Habitacion...
		Habitacion h1 = new Habitacion("H1", 4, 73, false);
		habitaciones.add(h1);
		Habitacion h2 = new Habitacion("H2", 4, 73, false);
		habitaciones.add(h2);
		Habitacion h3 = new Habitacion("H3", 4, 67, false);
		habitaciones.add(h3);
		Habitacion h4 = new Habitacion("H4", 4, 67, false);
		habitaciones.add(h4);
		Habitacion h5 = new Habitacion("H5", 3, 51, false);
		habitaciones.add(h5);
		Habitacion h6 = new Habitacion("H6", 3, 51, false);
		habitaciones.add(h6);
		Habitacion h7 = new Habitacion("H7", 3, 54, false);
		habitaciones.add(h7);
		Habitacion h8 = new Habitacion("H8", 3, 54, false);
		habitaciones.add(h8);
		Habitacion h9 = new Habitacion("H9", 2, 85, false);
		habitaciones.add(h9);
		Habitacion h10 = new Habitacion("H10", 2, 70, false);
		habitaciones.add(h10);
		Habitacion h11 = new Habitacion("H11", 2, 70, false);
		habitaciones.add(h11);
		Habitacion h12 = new Habitacion("H12", 2, 65, false);
		habitaciones.add(h12);
		Habitacion h13 = new Habitacion("H13", 1, 72, false);
		habitaciones.add(h13);
		Habitacion h14 = new Habitacion("H14", 1, 72, false);
		habitaciones.add(h14);
		Habitacion h15 = new Habitacion("H15", 1, 68, false);
		habitaciones.add(h15);
		Habitacion h16 = new Habitacion("H16", 1, 68, false);
		habitaciones.add(h16);
		
		Cliente c1 = new Cliente("123456", "test", "test", "test@test.es", "test", false);
		Cliente c2 = new Cliente("admin", "admin", "admin", "admin@admin.es", "admin", true);

		//anadirHabitaciones(habitaciones);
		
		try {
			 store(c1);
			 store(c2);
			for (int i = 0; i < habitaciones.size(); i++) {
				store(habitaciones.get(i));
			}
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

}
