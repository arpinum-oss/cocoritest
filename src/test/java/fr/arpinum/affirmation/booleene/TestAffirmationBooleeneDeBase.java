package fr.arpinum.affirmation.booleene;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.affirmation.ExceptionAffirmation;

public class TestAffirmationBooleeneDeBase {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		new AffirmationBooleeneDeBase(true).estVrai();
		new AffirmationBooleeneDeBase(true).estVraie();
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La valeur n'est pas vraie.");

		new AffirmationBooleeneDeBase(false).estVrai();
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQueFauxEstVrai() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La valeur n'est pas vraie.");

		new AffirmationBooleeneDeBase(false).estVraie();
	}

	@Test
	public void onNePeutPasAffirmerQueNullEstVrai() {
		exception.expect(ExceptionAffirmation.class);

		new AffirmationBooleeneDeBase(null).estVrai();
	}

	@Test
	public void onPeutAffirmerQueFauxEstFaux() {
		new AffirmationBooleeneDeBase(false).estFaux();
		new AffirmationBooleeneDeBase(false).estFausse();
	}

	@Test
	public void onNePeutPasAffirmerQueVraiEstFaux() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La valeur n'est pas fausse.");

		new AffirmationBooleeneDeBase(true).estFaux();
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQueVraiEstFaux() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La valeur n'est pas fausse.");

		new AffirmationBooleeneDeBase(true).estFausse();
	}
}
