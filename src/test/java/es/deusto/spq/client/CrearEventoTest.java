package es.deusto.spq.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CrearEventoTest {
	
    Evento e = new Evento("21EC7", "Evento cultural: Exposición artística de pinturas y esculturas", "La selección presentada contiene un buen número de obras maestras. "
    	            	+ "Comienza con Eduardo Zamacois (Bufones jugando al 'cochonnet', 1868), " + "uno de los pintores que más admiración internacional despertó a mediados "
    	            	+ "del siglo XIX, y con Juan de Barroeta (Vista de El Abra de Bilbao desde Algorta, 1886), quien, a través del paisaje, representa la transición entre "
    	            	+ "el realismo y el impresionismo.", 23, 7, 2021, "17:00", 70);
				
    @Test
	public void getNombreTest() {		
		assertEquals("Evento cultural: Exposición artística de pinturas y esculturas", e.getNombre());
	}
    
    @Test
	public void getCodigoTest() {		
		assertEquals("21EC7", e.getCodigo());
	}

    @Test
	public void getDescripcionTest() {		
		assertEquals("La selección presentada contiene un buen número de obras maestras. Comienza con Eduardo Zamacois (Bufones jugando al 'cochonnet', 1868), uno de los pintores "
				   + "que más admiración internacional despertó a mediados del siglo XIX, y con Juan de Barroeta (Vista de El Abra de Bilbao desde Algorta, 1886), quien, a través "
				   + "del paisaje, representa la transición entre el realismo y el impresionismo.", e.getDescripcion());
	}
    
    @Test
	public void getNumMaxPersonasTest() {
		assertEquals(70, e.getNumMaxPersonas());
	}
    
    @Test
	public void getAnyoTest() {
		assertEquals(2021, e.getAnyo());
	}
    
    @Test
	public void getMesTest() {
		assertEquals(7, e.getMes());
	}
    
    @Test
	public void getDiaTest() {
		assertEquals(23, e.getDia());
	}

	@Test
	public void getHoraTest() {
		assertEquals("17:00", e.getHora());
	}
	
}
