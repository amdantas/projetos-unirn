package amdantas.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MatematicaTest {
	@Test
	public void testSomaSucesso() {
		int resultadoObtido = Matematica.soma(3, 4);
		assertEquals(7, resultadoObtido);
	}

	@Test
	public void testSomaFalha() {
		int resultadoObtido = Matematica.soma(3, 4);
		assertEquals(9, resultadoObtido);
	}

}
