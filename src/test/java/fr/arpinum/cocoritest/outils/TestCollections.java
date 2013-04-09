package fr.arpinum.cocoritest.outils;

import static fr.arpinum.cocoritest.affirmation.Affirmations.*;

import java.util.List;

import org.junit.Test;

public class TestCollections {

	@Test
	public void deuxCollectionsDeTaillesDifférentesSontDifférentes() {
		List<Integer> première = Listes.cree(1, 2, 3);
		List<Integer> seconde = Listes.cree(1, 2);

		boolean égalité = Collections.egales(première, seconde);

		alors().cette(égalité).estFausse();
	}

	@Test
	public void deuxCollectionsAvecLesMêmesElémentsSontEgales() {
		List<Integer> première = Listes.cree(1, 2, 3);
		List<Integer> seconde = Listes.cree(1, 2, 3);

		boolean égalité = Collections.egales(première, seconde);

		alors().cette(égalité).estVraie();
	}

	@Test
	public void deuxCollectionsAvecDesElémentsDifférentsSontDifférentes() {
		List<Integer> première = Listes.cree(1, 2, 3);
		List<Integer> seconde = Listes.cree(1, 2, 4);

		boolean égalité = Collections.egales(première, seconde);

		alors().cette(égalité).estFausse();
	}

	@Test
	public void deuxCollectionsNullesSontEgales() {
		boolean égalité = Collections.egales(null, null);

		alors().cette(égalité).estVraie();
	}

	@Test
	public void uneCollectionNulleNEstJamaisEgaleAUneNonNulle() {
		boolean égalitéNulleNonNulle = Collections.egales(null, Listes.cree(1));
		alors().cette(égalitéNulleNonNulle).estFausse();

		boolean égalitéNonNulleNulle = Collections.egales(Listes.cree(1), null);
		alors().cette(égalitéNonNulleNulle).estFausse();
	}
}
