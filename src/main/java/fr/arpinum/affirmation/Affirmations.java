package fr.arpinum.affirmation;

import java.util.Collection;

import fr.arpinum.affirmation.booleene.AffirmationBooleeneAuFeminin;
import fr.arpinum.affirmation.booleene.AffirmationBooleeneAuMasculin;
import fr.arpinum.affirmation.collection.AffirmationCollection;
import fr.arpinum.affirmation.objet.AffirmationObjetAuFeminin;
import fr.arpinum.affirmation.objet.AffirmationObjetAuMasculin;

public class Affirmations {

	public static AffirmationBooleeneAuMasculin alors(boolean booléen) {
		return alorsLe(booléen);
	}

	public static AffirmationBooleeneAuMasculin alorsLe(boolean booléen) {
		return new AffirmationBooleeneAuMasculin(booléen);
	}

	public static AffirmationBooleeneAuFeminin alorsLa(boolean booléen) {
		return new AffirmationBooleeneAuFeminin(booléen);
	}

	public static <T> AffirmationObjetAuMasculin<T> alors(T valeur) {
		return alorsLe(valeur);
	}

	public static <T> AffirmationObjetAuMasculin<T> alorsLe(T valeur) {
		return new AffirmationObjetAuMasculin<T>(valeur);
	}

	public static <T> AffirmationObjetAuFeminin<T> alorsLa(T valeur) {
		return new AffirmationObjetAuFeminin<T>(valeur);
	}

	public static <T> AffirmationCollection<T> alors(Collection<T> valeurs) {
		return new AffirmationCollection<T>(valeurs);
	}

	public static <T> AffirmationCollection<T> alorsLes(Collection<T> valeurs) {
		return alors(valeurs);
	}
}
