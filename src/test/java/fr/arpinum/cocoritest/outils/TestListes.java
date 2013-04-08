package fr.arpinum.cocoritest.outils;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import java.util.List;

import org.junit.Test;

public class TestListes {

	@Test
	public void peutCréerUneListe() {
		List<String> éléments = Listes.cree("a", "b");

		alorsLes(éléments).sont("a", "b");
	}
}
