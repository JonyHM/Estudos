package br.com.gsw.flanboyant;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.gsw.flanboyant.controller.ShipwreckController;
import br.com.gsw.flanboyant.model.Shipwreck;
import br.com.gsw.flanboyant.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck(); 
		sw.setId(1l);
		when(shipwreckRepository.getOne(1l)).thenReturn(sw);	
		
		Shipwreck wreck = sc.get(1L);
		
		verify(shipwreckRepository).getOne(1l);
		
//		assertEquals(1l, wreck.getId().longValue());
		assertThat(wreck.getId(), is(1l));
	}
}
