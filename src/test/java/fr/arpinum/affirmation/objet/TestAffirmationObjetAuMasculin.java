package fr.arpinum.affirmation.objet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.affirmation.ExceptionAffirmation;

public class TestAffirmationObjetAuMasculin {

	@Rule
	public ExpectedException politiqueException = ExpectedException.none();

	@Test
	 public void onPeutAffirmerQuUnObjetEstNul() {
		new AffirmationObjetAuMasculin<String>(null).estNul();
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNonNulEstNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est toto et non null.");

		new AffirmationObjetAuMasculin<String>("toto").estNul();
	}

	@Test
	public void onPeutAffirmerQuUnObjetNEstPasNul() {
		new AffirmationObjetAuMasculin<String>("toto").nEstPasNul();
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNulNEstPasNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est null alors que ce n'était pas voulu.");

		new AffirmationObjetAuMasculin<String>(null).nEstPasNul();
	}
}
