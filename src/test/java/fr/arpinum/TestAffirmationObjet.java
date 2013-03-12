package fr.arpinum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestAffirmationObjet {

	@Rule
	public ExpectedException politiqueException = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUnNombreEstLeMêmeNombre() {
		new AffirmationObjet(1).est(1);
	}

	@Test
	public void onNePeutPasAffirmerQuUnNombreEstUnNombreDifferent() {
		politiqueException.expect(ExceptionAssertion.class);
		politiqueException.expectMessage("attendu: <1>, obtenu: <2>");

		new AffirmationObjet(1).est(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneChaîneEstUneChaîneDifferente() {
		politiqueException.expect(ExceptionAssertion.class);
		politiqueException.expectMessage("attendu: <toto>, obtenu: <tutu>");

		new AffirmationObjet("toto").est("tutu");
	}
}
