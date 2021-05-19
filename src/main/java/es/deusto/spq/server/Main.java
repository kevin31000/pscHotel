package es.deusto.spq.server;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class.
 *
 */
public class Main {
	// Base URI the Grizzly HTTP server will listen on
	// public static final String BASE_URI = "http://localhost:8080/myapp/";

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// create a resource config that scans for JAX-RS resources and providers
		// in es.deusto.spq package
		final ResourceConfig rc = new ResourceConfig().packages("es.deusto.spq");

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(getURL()), rc);
	}

	public static String getURL() {
		GetProperties properties = new GetProperties();
		String url = "";

		try {
			url = properties.getURL();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return url;

	}
	
	public static PrintStream logFeedback;
	public static Logger loggerGeneral = Logger.getLogger(Main.class.getName());
	
	/**
	 * Metodo para poder crear ficheros log, en nuestro caso el de FeedbackLog.log
	 *
	 */
	public static void crearFicheroLog() {
		try {
			logFeedback = new PrintStream(new FileOutputStream("FeedbackLog.log", true));
		} catch (FileNotFoundException e) {
			es.deusto.spq.server.Main.loggerGeneral.log(Level.INFO, e.toString());
			e.printStackTrace();
		}

	}
	
	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		DBManager.getInstance();

		final HttpServer server = startServer();
		System.out.println(String.format(
				"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
				getURL()));
		System.in.read();
		server.stop();

	}
}
