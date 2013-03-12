package fr.arpinum;

import static junit.framework.TestCase.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAffirmationBooleene {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		AffirmationBooleene assertion = new AffirmationBooleene(true);

		assertion.estVrai();

		assertNotNull(assertion);
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
	public void onPeutAffirmerQueFauxEstFaux() {
		new AffirmationBooleene(false).estFaux();
	}

	@Test
	public void onPeutAffirmerQuUneValeurFausseEstFausse() {
		new AffirmationBooleene(false).estFausse();
	}
}
