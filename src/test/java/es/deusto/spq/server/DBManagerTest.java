package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.client.Cliente;
import es.deusto.spq.client.Habitacion;
import es.deusto.spq.client.Reserva;

public class DBManagerTest {
    DBManager dbmanager = new DBManager();
    Cliente c1, c2;
    Habitacion h1, h2;
    Reserva r1, r2;
    
    @Rule 
	public ContiPerfRule i = new ContiPerfRule();

    @Test
    public void getUsuarioTest() {
        c1 = dbmanager.getUsuario("test@test2.es");
        assertEquals(c1.getEmail(), "test@test2.es");
    }

    @Test
    public void getHabitacionTest() {
        h1 = dbmanager.getHabitacion("H1");
        assertEquals(h1.getCodigo(), "H1");
    }

    @Test
    public void getReservaTest() {
        r1 = dbmanager.getReserva("R1");
        assertEquals(r1.getCodigoReserva(), "R1");
    }

    @Test
    public void storeClienteTest() {
        c1 = new Cliente("12312312A", "Pablo", "Garcia", "test@test2.es", "qwertyui", false);
        
        dbmanager.store(c1);
        c2 = dbmanager.getUsuario("test@test2.es");
        assertEquals(c2, c1);
    }

    @Test
    public void storeHabitacionTest() {
        h1 = new Habitacion("H80", 3, 60, false);

        dbmanager.store(h1);
        h2 = dbmanager.getHabitacion("H80");
        assertEquals(h2, h1);
    }

    @Test
    public void storeReservaTest() {
        r2 = new Reserva("R80", "H80", "test@test2.es", 1, 5, 2021);

        dbmanager.store(r1);
        r2 = dbmanager.getReserva("R80");
        assertEquals(r2, r1);
    }

    public void actualizarDatosClienteTest() {
        dbmanager.actualizarDatosCliente("12312312A", "Pablo", "Garcia", "test@test2.es", "qwertyui");
        c1 = dbmanager.getUsuario("test@test2.es");

        assertEquals(c1.getDNI(), "12312312A");
    }
}
