package fr.arpinum;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.outil.Listes;

public class TestAffirmationCollection {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUneCollectionEstEgaleAUneAutre() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(1, 2, 3);

		new AffirmationCollection(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleAUneCollectionDifferente() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(2, 3);
		exception.expect(ExceptionAssertion.class);
		exception.expectMessage("Les éléments sont <[1, 2, 3]> et non <[2, 3]>.");

		new AffirmationCollection(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleAUneCollectionDifferenteBienQueLesTaillesSoientIdentiques() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(1, 2, 4);
		exception.expect(ExceptionAssertion.class);

		new AffirmationCollection(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onPeutAffirmerQueDeuxCollectionsNullSontEgales() {
		List<String> valeursTestées = null;
		List<String> valeursAttendues = null;

		new AffirmationCollection(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNonNullEstEgaleAUneNull() {
		exception.expect(ExceptionAssertion.class);
		exception.expectMessage("Les éléments sont <[a, b]> et non <null>.");

		new AffirmationCollection(Listes.cree("a", "b")).sont(null);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionPossedeUnCertainsNombreDElements() {
		new AffirmationCollection(Listes.cree(1, 2)).sontAuNombreDe(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionPossedeUnNombreErroneDElements() {
		exception.expect(ExceptionAssertion.class);
		exception.expectMessage("Les éléments sont au nombre de <2> et non <10>.");

		new AffirmationCollection(Listes.cree("a", "b")).sontAuNombreDe(10);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNullPossedeUnNombreDElements() {
		exception.expect(ExceptionAssertion.class);
		exception.expectMessage("La collection est nulle et ne possède donc pas un nombre d'éléments de <10>.");

		new AffirmationCollection(null).sontAuNombreDe(10);
	}
}
