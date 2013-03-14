package fr.arpinum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAffirmationBooleene {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		new AffirmationBooleeneAuMasculin(true).estVrai();
	}

	@Test
	public void onPeutAffirmerQuUneValeurVraieEstVraie() {
		new AffirmationBooleeneAuFeminin(true).estVraie();
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		exception.expect(ExceptionAssertion.class);
		exception.expectMessage("la valeur n'est pas vraie");

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
	public void onPeutAffirmerQuUneValeurFausseEstFausse() {
		new AffirmationBooleeneAuFeminin(false).estFausse();
	}
}
