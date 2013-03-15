package fr.arpinum.affirmation.booleene;

public class AffirmationBooleeneAuMasculin extends AffirmationBooleene {

	public AffirmationBooleeneAuMasculin(Boolean valeur) {
		super(valeur);
	}

	public void estVrai() {
		estVraiInterne();
	}

	public void estFaux() {
		estFauxInterne();
	}
}
