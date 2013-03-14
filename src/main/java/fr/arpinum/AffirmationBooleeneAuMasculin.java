package fr.arpinum;

public class AffirmationBooleeneAuMasculin extends AffirmationBooleene {

	public AffirmationBooleeneAuMasculin(Boolean valeur) {
		super(valeur);
	}

	public void estVrai() {
		if (!estSatisfaite()) {
			throw new ExceptionAssertion("la valeur n'est pas vraie");
		}
	}

	public void estFaux() {
		if (estSatisfaite()) {
			throw new ExceptionAssertion("la valeur n'est pas fausse");
		}
	}
}
