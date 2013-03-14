package fr.arpinum.affirmations;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.outils.Listes;

public class TestAffirmationCollection {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUneCollectionEstEgaleAUneAutre() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(1, 2, 3);

		new AffirmationCollection<Integer>(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleAUneCollectionDifférente() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(2, 3);
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont [1, 2, 3] et non [2, 3].");

		new AffirmationCollection<Integer>(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleAUneCollectionDifférenteBienQueLesTaillesSontIdentiques() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(1, 2, 4);
		exception.expect(ExceptionAffirmation.class);

		new AffirmationCollection<Integer>(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onPeutAffirmerQueDeuxCollectionsNullesSontEgales() {
		List<String> valeursTestées = null;
		List<String> valeursAttendues = null;

		new AffirmationCollection<String>(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNonNulleEstEgaleAUneNulle() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont [a, b] et non null.");

		new AffirmationCollection<String>(Listes.cree("a", "b")).sont(null);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionPossèdeUnCertainsNombreDElements() {
		new AffirmationCollection<Integer>(Listes.cree(1, 2)).sontAuNombreDe(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionPossèdeUnNombreErronéDElements() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont au nombre de 2 et non 10.");

		new AffirmationCollection<String>(Listes.cree("a", "b")).sontAuNombreDe(10);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNullePossedeUnQuelconqueNombreDEléments() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle et ne possède donc pas un nombre d'éléments de 10.");

		new AffirmationCollection<Integer>(null).sontAuNombreDe(10);
	}
}
