package fr.arpinum.cocoritest.affirmation.booleene;

import fr.arpinum.cocoritest.affirmation.Affirmation;
import fr.arpinum.cocoritest.outils.Objets;

public class AffirmationBooleeneDeBase extends Affirmation implements AffirmationBooleene, AffirmationBooleeneAuFeminin {

	public AffirmationBooleeneDeBase(Boolean valeur) {
		booléen = valeur;
	}

	@Override
	public void estVrai() {
		satisfait(true);
	}

	@Override
	public void estVraie() {
		estVrai();
	}

	@Override
	public void estFaux() {
		satisfait(false);
	}

	@Override
	public void estFausse() {
		estFaux();
	}

	private void satisfait(boolean attendue) {
		if (Objets.différents(booléen, attendue)) {
			échoue("La valeur n'est pas %s.", attendue ? "vraie" : "fausse");
		}
	}

	private final Boolean booléen;
}
