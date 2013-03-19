package fr.arpinum.affirmation.collection;

import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.affirmation.ExceptionAffirmation;
import fr.arpinum.outils.Listes;

public class TestAffirmationCollection {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUneCollectionEstEgaleAUneAutre() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(1, 2, 3);

		creeAffirmation(valeursTestées).sont(valeursAttendues);
		creeAffirmation(valeursTestées).sont(1, 2, 3);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleAUneCollectionDifférente() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		List<Integer> valeursAttendues = Listes.cree(2, 3);
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont [1, 2, 3] et non [2, 3].");

		creeAffirmation(valeursTestées).sont(valeursAttendues);
	}

	@Test
	public void onNePeutPasAffirmerQUneCollectionEstEgaleADesElémentsNonContenus() {
		List<Integer> valeursTestées = Listes.cree(1, 2, 3);
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont [1, 2, 3] et non [2, 3].");

		creeAffirmation(valeursTestées).sont(2, 3);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionPossèdeUnCertainsNombreDElements() {
		creeAffirmation(Listes.cree(1, 2)).sontAuNombreDe(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionPossèdeUnNombreErronéDElements() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("Les éléments sont au nombre de 2 et non 10.");

		creeAffirmation(Listes.cree("a", "b")).sontAuNombreDe(10);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNullePossedeUnQuelconqueNombreDEléments() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle et ne possède donc pas un nombre d'éléments de 10.");

		creeAffirmation(null).sontAuNombreDe(10);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionAUnElément() {
		creeAffirmation(Listes.cree(1, 3, 13)).ont(13);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionADesEléments() {
		creeAffirmation(Listes.cree(1, 3, 13)).ont(13, 3);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionAUnElémentQuElleNAPas() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("[13, 12] ne sont pas présents dans [1, 2].");

		creeAffirmation(Listes.cree(1, 2)).ont(13, 12);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNullAUnElément() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle, [13, 12] ne sont donc pas présents dedans.");

		creeAffirmation(null).ont(13, 12);
	}

	private static <T> AffirmationCollection<T> creeAffirmation(Collection<T> valeurs) {
		return new AffirmationCollection<T>(valeurs);
	}
}
