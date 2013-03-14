package fr.arpinum;

public class AffirmationBooleene {

	public AffirmationBooleene(Boolean valeur) {
		booléen = valeur;
	}

	public void estVrai() {
		if (!estSatisfaite()) {
			throw new ExceptionAssertion("la valeur n'est pas vraie");
		}
	}

	public void estVraie() {
		estVrai();
	}

	public void estFaux() {
		if (estSatisfaite()) {
			throw new ExceptionAssertion("la valeur n'est pas fausse");
		}
	}

	public void estFausse() {
		estFaux();
	}

	private Boolean estSatisfaite() {
		return booléen != null && booléen;
	}

	private Boolean booléen;
}
