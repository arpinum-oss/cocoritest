package fr.arpinum.cocoritest.affirmation.booleene;

import fr.arpinum.cocoritest.affirmation.Affirmation;
import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjetDeBase;

public class AffirmationBooleeneDeBase extends Affirmation implements AffirmationBooleene, AffirmationBooleeneAuFeminin {

	public AffirmationBooleeneDeBase(Boolean valeur) {
		booléen = valeur;
	}

	@Override
	public void estVrai() {
		affirmeQueLeBooléenEst(true);
	}

	@Override
	public void estVraie() {
		estVrai();
	}

	@Override
	public void estFaux() {
		affirmeQueLeBooléenEst(false);
	}

	@Override
	public void estFausse() {
		estFaux();
	}

	private void affirmeQueLeBooléenEst(boolean attendue) {
		new AffirmationObjetDeBase<>(booléen).est(attendue);
	}

	private final Boolean booléen;
}
