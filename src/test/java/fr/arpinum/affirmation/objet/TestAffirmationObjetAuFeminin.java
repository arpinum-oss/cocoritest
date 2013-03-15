package fr.arpinum.affirmation.objet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.affirmation.ExceptionAffirmation;

public class TestAffirmationObjetAuFeminin {

	@Rule
	public ExpectedException politiqueException = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUneValeurEstNulle() {
		new AffirmationObjetAuFeminin<String>(null).estNulle();
	}

	@Test
	public void onNePeutPasAffirmerQuUneValeurNonNulleEstNulle() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est toto et non null.");

		new AffirmationObjetAuFeminin<String>("toto").estNulle();
	}

	@Test
	public void onPeutAffirmerQuUneValeurNEstPasNulle() {
		new AffirmationObjetAuFeminin<String>("toto").nEstPasNulle();
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNulNEstPasNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est null alors que ce n'était pas voulu.");

		new AffirmationObjetAuFeminin<String>(null).nEstPasNulle();
	}
}
