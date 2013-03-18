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
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La valeur n'est pas vraie.");

		new AffirmationBooleeneDeBase(false).estVrai();
	}

	@Test
	public void onNePeutPasAffirmerQueNullEstVrai() {
		exception.expect(ExceptionAffirmation.class);

		new AffirmationBooleeneDeBase(null).estVrai();
	}

	@Test
	public void onPeutAffirmerQueFauxEstFaux() {
		new AffirmationBooleeneDeBase(false).estFaux();
	}

	@Test
	public void onNePeutPasAffirmerQueVraiEstFaux() {
		exception.expect(ExceptionAffirmation.class);
		exception.expectMessage("La valeur n'est pas fausse.");

		new AffirmationBooleeneDeBase(true).estFaux();
	}

	@Test
	public void onPeutAffirmerQuUneValeurVraieEstVraie() {
		new AffirmationBooleeneDeBase(true).estVraie();
	}

	@Test
	public void onPeutAffirmerQuUneValeurFausseEstFausse() {
		new AffirmationBooleeneDeBase(false).estFausse();
	}
}
