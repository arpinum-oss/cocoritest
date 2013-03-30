package fr.arpinum.affirmation.collection;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.affirmation.ExceptionAffirmation;

public class TestsAffirmationCollectionNulle {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNullePossedeUnQuelconqueNombreDEléments() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle et ne possède donc pas un nombre d'éléments de 10.");

		AffirmationCollection.cree(null).sontAuNombreDe(10);
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleEstVide() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle et ne possède donc pas un nombre d'éléments de 0.");

		AffirmationCollection.cree(null).nExistentPas();
	}

	@Test
	public void onNePeutPasAffirmerQuUneCollectionNulleAUnElément() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La collection est nulle, [13, 12] ne sont donc pas présents dedans.");

		AffirmationCollection.cree(null).ont(13, 12);
	}

	@Test
	public void onPeutAffirmerQuUneCollectionEstVide() {
		AffirmationCollection.cree(new ArrayList<Integer>()).nExistentPas();
	}
}
