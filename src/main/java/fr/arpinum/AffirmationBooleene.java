package fr.arpinum;

public class AffirmationBooleene {

	public AffirmationBooleene(boolean valeur) {
		booléen = valeur;
	}

	public void estVrai() {
		if (!booléen) {
			throw new ExceptionAssertion("la valeur n'est pas vraie");
		}
	}

	public void estVraie() {
		estVrai();
	}

	public void estFaux() {
		if (booléen) {
			throw new ExceptionAssertion("la valeur n'est pas fausse");
		}
	}

	public void estFausse() {
		estFaux();
	}

	private Boolean booléen;
}
