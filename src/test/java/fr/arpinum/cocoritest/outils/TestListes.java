package fr.arpinum.cocoritest.outils;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import java.util.List;

import org.junit.Test;

public class TestListes {

	@Test
	public void peutCréerUneListe() {
		List<String> liste = Listes.cree("a", "b");

		assertNotNull(liste);
		assertEquals(2, liste.size());
	}
}
