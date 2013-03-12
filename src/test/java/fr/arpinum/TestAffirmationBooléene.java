package fr.arpinum;

import static junit.framework.TestCase.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAffirmationBooléene {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQueVraiEstVrai() {
		AffirmationBooléene assertion = new AffirmationBooléene(true);

		assertion.estVrai();

		assertNotNull(assertion);
	}

	@Test
	public void onPeutAffirmerQuUneValeurVraieEstVraie() {
		new AffirmationBooléene(true).estVraie();
	}

	@Test
	public void onNePeutPasAffirmerQueFauxEstVrai() {
		exception.expect(ExceptionAssertion.class);
		exception.expectMessage("la valeur n'est pas vraie");

		new AffirmationBooléene(false).estVrai();
	}

	@Test
	public void onPeutAffirmerQueFauxEstFaux() {
		new AffirmationBooléene(false).estFaux();
	}

	@Test
	public void onPeutAffirmerQuUneValeurFausseEstFausse() {
		new AffirmationBooléene(false).estFausse();
	}
}
