package fr.arpinum.outils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestObjets {

	@Test
	public void ilEstPossibleDeTesterLEgaliteDeDeuxObjets() {
		assertTrue(Objets.egaux("toto", "toto"));
		assertTrue(Objets.egaux(3, 3));
		assertFalse(Objets.egaux("toto", 3));
		assertTrue(Objets.egaux(null, null));
		assertFalse(Objets.egaux(null, 3));
		assertFalse(Objets.egaux(3, null));
	}

	@Test
	public void ilEstPossibleDeTesterLInegaliteDeDeuxObjets() {
		assertTrue(Objets.différents("toto", "tutu"));
		assertFalse(Objets.différents(13, 13));
	}
}
