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
		politiqueException.expectMessage("attendu: <2>, obtenu: <1>");

		new AffirmationObjet(1).est(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUneChaîneEstUneChaîneDifferente() {
		politiqueException.expect(ExceptionAssertion.class);
		politiqueException.expectMessage("attendu: <tutu>, obtenu: <toto>");

		new AffirmationObjet("toto").est("tutu");
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNonNullEstNull() {
		politiqueException.expect(ExceptionAssertion.class);
		politiqueException.expectMessage("attendu: <null>, obtenu: <toto>");

		new AffirmationObjet("toto").est(null);
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNullEstNonNull() {
		politiqueException.expect(ExceptionAssertion.class);
		politiqueException.expectMessage("attendu: <tutu>, obtenu: <null>");

		new AffirmationObjet(null).est("tutu");
	}
}
