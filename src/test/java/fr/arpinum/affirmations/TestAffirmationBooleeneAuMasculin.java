package fr.arpinum.affirmations;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.affirmations.AffirmationBooleeneAuMasculin;
import fr.arpinum.affirmations.ExceptionAffirmation;

public class TestAffirmationBooleeneAuMasculin {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		new AffirmationBooleeneAuMasculin(true).estVrai();
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La valeur n'est pas vraie.");

		new AffirmationBooleeneAuMasculin(false).estVrai();
	}

	@Test
	public void onNePeutPasAffirmerQueNullEstVrai() {
		exception.expect(ExceptionAffirmation.class);

		new AffirmationBooleeneAuMasculin(null).estVrai();
	}

	@Test
	public void onPeutAffirmerQueFauxEstFaux() {
		new AffirmationBooleeneAuMasculin(false).estFaux();
	}

	@Test
	public void onNePeutPasAffirmerQueVraiEstFaux() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La valeur n'est pas fausse.");

		new AffirmationBooleeneAuMasculin(true).estFaux();
	}

}
