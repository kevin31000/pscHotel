package es.deusto.spq.server;

import org.glassfish.grizzly.http.server.HttpServer;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

public class DBManager {
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;
	private static boolean inicializado = false;

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

		return instance;
	}

}
