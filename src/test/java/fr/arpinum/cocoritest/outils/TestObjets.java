package fr.arpinum.cocoritest.outils;

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

	@Test
	public void unBooléenEnChaîneEstEnFrançais() {
		assertEquals("vrai", Objets.enChaîne(true));
		assertEquals("faux", Objets.enChaîne(false));
	}

	@Test
	public void unObjetNulEnChaîneEstEnFrançais() {
		assertEquals("nul", Objets.enChaîne(null));
	}

	@Test
	public void unObjetNonNulEnChaîneEstSonToString() {
		Object objet = new Object();

		assertEquals(objet.toString(), Objets.enChaîne(objet));
	}
}
