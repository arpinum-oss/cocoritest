package fr.arpinum.outils;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

import java.util.List;

import org.junit.Test;

public class TestCollections {

	@Test
	public void deuxCollectionsDeTaillesDifférentesSontDifférentes() {
		List<Integer> première = Listes.cree(1, 2, 3);
		List<Integer> seconde = Listes.cree(1, 2);

		assertFalse(Collections.egales(première, seconde));
	}

	@Test
	public void deuxCollectionsAvecLesMêmesElémentsSontEgales() {
		List<Integer> première = Listes.cree(1, 2, 3);
		List<Integer> seconde = Listes.cree(1, 2, 3);

		assertTrue(Collections.egales(première, seconde));
	}

	@Test
	public void deuxCollectionsAvecDesElémentsDifférentsSontDifférentes() {
		List<Integer> première = Listes.cree(1, 2, 3);
		List<Integer> seconde = Listes.cree(1, 2, 4);

		assertFalse(Collections.egales(première, seconde));
	}

	@Test
	public void deuxCollectionsNullesSontEgales() {
		assertTrue(Collections.egales(null, null));
	}

	@Test
	public void uneCollectionNulleNEstJamaisEgaleAUneNonNulle() {
		assertFalse(Collections.egales(null, Listes.cree(1)));
		assertFalse(Collections.egales(Listes.cree(1), null));
	}
}
