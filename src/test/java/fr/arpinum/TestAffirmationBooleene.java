package fr.arpinum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAffirmationBooleene {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		new AffirmationBooleene(true).estVrai();
	}

	@Test
	public void onPeutAffirmerQuUneValeurVraieEstVraie() {
		new AffirmationBooleene(true).estVraie();
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		exception.expect(ExceptionAssertion.class);
		exception.expectMessage("la valeur n'est pas vraie");

		new AffirmationBooleene(false).estVrai();
	}

	@Test
	public void onNePeutPasAffirmerQueNullEstVrai() {
		exception.expect(ExceptionAssertion.class);

		new AffirmationBooleene(null).estVrai();
	}

	@Test
	public void onPeutAffirmerQueFauxEstFaux() {
		new AffirmationBooleene(false).estFaux();
	}

	@Test
	public void onPeutAffirmerQuUneValeurFausseEstFausse() {
		new AffirmationBooleene(false).estFausse();
	}
}
