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
		exception.expectMessage("attendu: <[1, 2, 3]>, obtenu: <[2, 3]>");

		new AffirmationCollection(valeursTestées).sont(valeursAttendues);
	}
}
