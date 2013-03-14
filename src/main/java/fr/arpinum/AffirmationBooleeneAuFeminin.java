package fr.arpinum;

public class AffirmationBooleeneAuFeminin extends AffirmationBooleene {

	public AffirmationBooleeneAuFeminin(Boolean valeur) {
		super(valeur);
	}

	public void estVraie() {
		if (!estSatisfaite()) {
			throw new ExceptionAssertion("la valeur n'est pas vraie");
		}
	}

	public void estFausse() {
		if (estSatisfaite()) {
			throw new ExceptionAssertion("la valeur n'est pas fausse");
		}
	}
}
