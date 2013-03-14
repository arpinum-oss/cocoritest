package fr.arpinum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAffirmationBooleeneAuMasculin {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		new AffirmationBooleeneAuMasculin(true).estVrai();
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		exception.expect(ExceptionAssertion.class);
		exception.expectMessage("La valeur n'est pas vraie.");

		new AffirmationBooleeneAuMasculin(false).estVrai();
	}

	@Test
	public void onNePeutPasAffirmerQueNullEstVrai() {
		exception.expect(ExceptionAssertion.class);

		new AffirmationBooleeneAuMasculin(null).estVrai();
	}

	@Test
	public void onPeutAffirmerQueFauxEstFaux() {
		new AffirmationBooleeneAuMasculin(false).estFaux();
	}

	@Test
	public void onNePeutPasAffirmerQueVraiEstFaux() {
		exception.expect(ExceptionAssertion.class);
		exception.expectMessage("La valeur n'est pas fausse.");

		new AffirmationBooleeneAuMasculin(true).estFaux();
	}

}
