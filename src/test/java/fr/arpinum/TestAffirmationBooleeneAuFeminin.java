package fr.arpinum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAffirmationBooleeneAuFeminin {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUneValeurVraieEstVraie() {
		new AffirmationBooleeneAuFeminin(true).estVraie();
	}

	@Test
	public void onPeutAffirmerQuUneValeurFausseEstFausse() {
		new AffirmationBooleeneAuFeminin(false).estFausse();
	}
}
